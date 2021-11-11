package com.example.appchat.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appchat.Adapter.ChatAdapter;
import com.example.appchat.R;

import org.json.JSONException;
import org.json.JSONObject;

//import io.socket.client.IO;
//import io.socket.client.Socket;
//import io.socket.emitter.Emitter;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

//import tech.gusavila92.websocketclient.WebSocketClient;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = ChatActivity.class.getSimpleName();
    private EditText mEditNhap;
    private ImageButton mImgBtnSend, mImgBtnGif, mImgBtnDictionnary, mImgBtnChat, mImgBtnPersonal, mImgBtnSelect;
    private ListView mLvMessage;

    private ChatAdapter mChatAdapter;
    private final List<String> mMessageList = new ArrayList<>();
//    private WebSocketClient webSocketClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhantin);
        mChatAdapter = new ChatAdapter(mMessageList, this);
        initViews();
//        setListening();
//        createWebSocketClient();

        mImgBtnDictionnary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, DictionaryActivity.class);
                startActivity(intent);
            }
        });

        mImgBtnPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, PersonalActivity.class);
                startActivity(intent);
            }
        });

        mImgBtnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, SelectActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        mEditNhap = (EditText) findViewById(R.id.editNhap);
        mImgBtnSend = (ImageButton) findViewById(R.id.imgBtnGui);
        mLvMessage = (ListView) findViewById(R.id.listMessage);
        mLvMessage.setAdapter(mChatAdapter);
        mImgBtnDictionnary = (ImageButton) findViewById(R.id.imgBtnDanhBa);
        mImgBtnChat = (ImageButton) findViewById(R.id.imgBtnTinNhan);
        mImgBtnPersonal = (ImageButton) findViewById(R.id.imgBtnCaNhan);
        mImgBtnSelect = (ImageButton) findViewById(R.id.imgBtnTuyChon);
    }

//    private void createWebSocketClient() {
//        URI uri;
//        try {
//            uri = new URI("ws://10.0.2.2:8080/websocket");
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//            return;
//        }
//
//        webSocketClient = new WebSocketClient(uri) {
//            @Override
//            public void onOpen() {
//                Log.i("WebSocket", "Session is starting");
//                webSocketClient.send("Hello World!");
//            }
//
//            @Override
//            public void onTextReceived(String s) {
//                Log.i("WebSocket", "Message received");
//                final String message = s;
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            }
//
//            @Override
//            public void onBinaryReceived(byte[] data) {
//            }
//
//            @Override
//            public void onPingReceived(byte[] data) {
//            }
//
//            @Override
//            public void onPongReceived(byte[] data) {
//            }
//
//            @Override
//            public void onException(Exception e) {
//                System.out.println(e.getMessage());
//            }
//
//            @Override
//            public void onCloseReceived() {
//                Log.i("WebSocket", "Closed ");
//                System.out.println("onCloseReceived");
//            }
//        };
//        webSocketClient.setConnectTimeout(10000);
//        webSocketClient.setReadTimeout(60000);
//        webSocketClient.enableAutomaticReconnection(5000);
//        webSocketClient.connect();
//    }
//
//    public void sendMessage(View view){
//        Log.i("WebSocket", "Button was clicked");
//        // Send button id string to WebSocket Server
//        switch(view.getId()) {
//            case (R.id.imgBtnGui):
//                webSocketClient.send("12345");
//                break;
//        }
//    }
    @Override
    public void onClick(View v) {
        String message = mEditNhap.getText().toString().trim();
        mEditNhap.setText("");
        if(!message.isEmpty()){
            //sendMessage
            String jsonString= "{message: "+"'"+message+"'"+"}";
            try {
                JSONObject jsonData = new JSONObject(jsonString);
//                mSocket.emit("CHAT",jsonData);
            } catch (JSONException e) {
                Log.d(TAG,"Error send message "+ e.getMessage());
            }

        }
    }


}
