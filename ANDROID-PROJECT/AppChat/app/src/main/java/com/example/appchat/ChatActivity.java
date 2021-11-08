package com.example.appchat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appchat.DTO.MessageAdapter;

import org.json.JSONException;
import org.json.JSONObject;

//import io.socket.client.IO;
//import io.socket.client.Socket;
//import io.socket.emitter.Emitter;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = ChatActivity.class.getSimpleName();
    private EditText mEditNhap;
    private ImageButton mImgBtnGui, mImgBtnGif, mImgBtnDanhBa, mImgBtnTinNhan, mImgBtnCaNhan, mImgBtnTuyChon;
    private ListView mLvMessages;

    private MessageAdapter mMessageAdapter;
    private final List<String> mMessageList = new ArrayList<>();

//    private Socket mSocket;
//    {
//        try {
//            mSocket = IO.socket("http://192.168.1.8:3000");
//        } catch (URISyntaxException e) {
//            Log.d(TAG,"Error connect socket "+ e.getMessage());
//        }
//    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mSocket.connect();
        setContentView(R.layout.activity_nhantin);
        mMessageAdapter = new MessageAdapter(mMessageList, this);
        initViews();
        setListening();

        mImgBtnDanhBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, DanhBaActivity.class);
                startActivity(intent);
            }
        });

        mImgBtnCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, CaNhanActivity.class);
                startActivity(intent);
            }
        });

        mImgBtnTuyChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, TuyChonActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setListening() {
        //mImgBtnGui.setOnClickListener(this);

//        mSocket.on("CHAT", new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                try {
//                    JSONObject messageJson = new JSONObject(args[0].toString());
//                    String message = messageJson.getString("message");
//                    mMessageList.add(0,message);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            mMessageAdapter.notifyDataSetChanged();
//                        }
//                    });
//                } catch (JSONException e) {
//                    Log.d(TAG,"Error connect socket "+ e.getMessage());
//                }
//            }
//        });
    }

    private void initViews() {
        mEditNhap = (EditText) findViewById(R.id.editNhap);
        mImgBtnGui = (ImageButton) findViewById(R.id.imgBtnGui);
        mLvMessages = (ListView) findViewById(R.id.listMessage);
        mLvMessages.setAdapter(mMessageAdapter);
        mImgBtnDanhBa = (ImageButton) findViewById(R.id.imgBtnDanhBa);
        mImgBtnTinNhan = (ImageButton) findViewById(R.id.imgBtnTinNhan);
        mImgBtnCaNhan = (ImageButton) findViewById(R.id.imgBtnCaNhan);
        mImgBtnTuyChon = (ImageButton) findViewById(R.id.imgBtnTuyChon);
    }

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
