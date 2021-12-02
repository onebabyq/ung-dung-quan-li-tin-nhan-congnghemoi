package com.example.androidprojectsmb;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androidprojectsmb.dto.AccountDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.CompletableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
//abc
import static com.example.androidprojectsmb.LoginActivity.LOCALHOST;
import static com.example.androidprojectsmb.adapter.MessageAdapter.sdf;
import static com.example.androidprojectsmb.config.RestClient.ANDROID_EMULATOR_LOCALHOST;
import static com.example.androidprojectsmb.stomp.dto.ChatMessage.MessageType.*;
import static com.example.androidprojectsmb.stomp.dto.LifecycleEvent.Type.*;


import android.content.Intent;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidprojectsmb.adapter.MessageAdapter;
import com.example.androidprojectsmb.adapter.UserAdapter;
import com.example.androidprojectsmb.config.EchoModel;
import com.example.androidprojectsmb.config.RestClient;
import com.example.androidprojectsmb.dto.MessageDTO;
import com.example.androidprojectsmb.dto.RoomDTO;
import com.example.androidprojectsmb.dto.UserDTO;
import com.example.androidprojectsmb.stomp.Stomp;
import com.example.androidprojectsmb.stomp.StompClient;
import com.example.androidprojectsmb.stomp.dto.ChatMessage;
import com.example.androidprojectsmb.stomp.dto.StompHeader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.reactivex.CompletableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ChatActivity extends AppCompatActivity {
    private ImageView imgBtnGui;
    private EditText editNhap;
    private static final String TAG = "ChatActivity";
    private Gson mGson = new GsonBuilder().create();
    private Disposable mRestPingDisposable;
    private CompositeDisposable compositeDisposable;
    private final SimpleDateFormat mTimeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    private StompClient mStompClient;
    public static final String LOGIN = "login";
    public static final String PASSCODE = "passcode";
    ArrayList<MessageDTO> listMessage;
    MessageAdapter adapter;
    RecyclerView recyclerView;
    private long idAccount,idFriend,idRoom;
    private String topic=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acti_chat);
        Intent intent = getIntent();
        idAccount = intent.getLongExtra("idAccount", 42);
        idFriend = intent.getLongExtra("idFriend", 52);
        idRoom = intent.getLongExtra("idRoom", 40);
        topic = "/app/chat/"+idRoom;


        resetSubscriptions();
        initViews();

    }
    public void eventButton(){
        imgBtnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editNhap.getText().toString().trim();
                ChatMessage chatMessage = new ChatMessage();
                chatMessage.setContent(message);
                chatMessage.setIdSender(idAccount);
                chatMessage.setRoomId(idRoom);
                chatMessage.setType(CHAT);
                chatMessage.setContentType("TEXT");
                sendEchoViaStomp(chatMessage);
                editNhap.setText("");
            }
        });

    }

    public void initViews(){
        listMessage = new ArrayList<>();
        imgBtnGui =  (ImageView) findViewById(R.id.imgBtnGui);
        editNhap =  (EditText) findViewById(R.id.editNhap);
        getListMessageByRoomId(idRoom);
        adapter = new MessageAdapter(this,listMessage,idAccount);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        mStompClient = Stomp.over(Stomp.ConnectionProvider.OKHTTP, "ws://" + ANDROID_EMULATOR_LOCALHOST
                + ":" + RestClient.SERVER_PORT + "/ws/websocket");

        connectStomp();
        eventButton();
       // recyclerView.smoothScrollToPosition(listMessage.size() - 1);
    }
    public void getListMessageByRoomId(long id) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = LOCALHOST+"/messages/byRoomId/"+id;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = (JSONObject) response.get(i);
                        Gson gson = new Gson();
                        MessageDTO messageDTO= gson.fromJson(String.valueOf(object), MessageDTO.class);
                        listMessage.add(messageDTO);
                       // System.out.println(messageDTO.toString());
                        adapter.notifyDataSetChanged();
                        recyclerView.smoothScrollToPosition(listMessage.size() - 1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, error -> Toast.makeText(ChatActivity.this, "Error with JSON Array Object", Toast.LENGTH_SHORT).show());

        queue.add(jsonArrayRequest);

    }
    public void connectStomp() {
    //public void connectStomp(View view) {

            List<StompHeader> headers = new ArrayList<>();
            headers.add(new StompHeader(LOGIN, "guest"));
            headers.add(new StompHeader(PASSCODE, "guest"));

            //mStompClient.withClientHeartbeat(1000).withServerHeartbeat(1000);

            resetSubscriptions();

            Disposable dispLifecycle = mStompClient.lifecycle()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(lifecycleEvent -> {
                        switch (lifecycleEvent.getType()) {
                            case OPENED:
                                toast("Stomp connection opened");
                                break;
                            case ERROR:
                                Log.e(TAG, "Stomp connection error", lifecycleEvent.getException());
                                toast("Stomp connection error");
                                break;
                            case CLOSED:
                                toast("Stomp connection closed");
                                resetSubscriptions();
                                break;
                            case FAILED_SERVER_HEARTBEAT:
                                toast("Stomp failed server heartbeat");
                                break;
                        }
                    });

            compositeDisposable.add(dispLifecycle);


            // Receive greetings
            Disposable dispTopic = mStompClient.topic("/topic/"+idRoom)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(topicMessage -> {
                        Log.d(TAG, "Received " + topicMessage.getPayload());
                        addItem(mGson.fromJson(topicMessage.getPayload(), ChatMessage.class));

                    }, throwable -> {
                        Log.e(TAG, "Error on subscribe topic", throwable);
                    });

            compositeDisposable.add(dispTopic);

            mStompClient.connect(headers);

    }

    public void sendEchoViaStomp(ChatMessage chatMessage) {


        compositeDisposable.add(mStompClient.send(topic+"/sendMessage", mGson.toJson(chatMessage) )
                .compose(applySchedulers())
                .subscribe(() -> {
                    //addItem(chatMessage);
                    Log.d(TAG, "STOMP echo send successfully");
                }, throwable -> {
                    Log.e(TAG, "Error send STOMP echo", throwable);
                    toast(throwable.getMessage());
                }));
    }

    public void sendEchoViaRest(View v) {
        mRestPingDisposable = RestClient.getInstance().getExampleRepository()
                .sendRestEcho("Echo REST " + mTimeFormat.format(new Date()))
                .compose(applySchedulers())
                .subscribe(() -> {
                    Log.d(TAG, "REST echo send successfully");
                }, throwable -> {
                    Log.e(TAG, "Error send REST echo", throwable);
                    toast(throwable.getMessage());
                });
    }

    private void addItem(ChatMessage chatMessage) {
//        mDataSet.add(echoModel.getEcho() + " - " + mTimeFormat.format(new Date()));
//        mAdapter.notifyDataSetChanged();
//        mRecyclerView.smoothScrollToPosition(mDataSet.size() - 1);
            MessageDTO messageDTO = new MessageDTO();
            messageDTO.setContent(chatMessage.getContent());
            messageDTO.setCreateDate(new Date());
            AccountDTO from = new AccountDTO();
            from.setId(chatMessage.getIdSender());
            messageDTO.setFrom(from);
            listMessage.add(messageDTO);
            adapter.notifyDataSetChanged();
            recyclerView.smoothScrollToPosition(listMessage.size() - 1);
    }

    private void toast(String text) {
        Log.i(TAG, text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    protected CompletableTransformer applySchedulers() {
        return upstream -> upstream
                .unsubscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private void resetSubscriptions() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onDestroy() {
        mStompClient.disconnect();

        if (mRestPingDisposable != null) mRestPingDisposable.dispose();
        if (compositeDisposable != null) compositeDisposable.dispose();
        super.onDestroy();
    }
    public void disconnectStomp(View view) {
        mStompClient.disconnect();
    }

}




