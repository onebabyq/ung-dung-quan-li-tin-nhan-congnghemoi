package com.example.appchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {
    private EditText mEditSoDienThoai_signin, mEditMatKhau_sigin;
    private Button mBtnDangNhap_signin, mBtnDangNhapGoogle, mBtnQuenMatKhau, mBtnDangKy_signin;


//    private Socket mSocket;
//    {
//        try {
//            mSocket = IO.socket("http://192.168.1.8:3000");
//        }catch (URISyntaxException e){
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mSocket.connect();

        initViews();


        mBtnDangNhap_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initViews(){
        mEditSoDienThoai_signin = (EditText) findViewById(R.id.editSoDienThoai_signin);
        mEditMatKhau_sigin = (EditText) findViewById(R.id.editMatKhau_signin);
        mBtnDangNhap_signin = (Button) findViewById(R.id.btnDangNhap_signin);
        mBtnDangNhapGoogle = (Button) findViewById(R.id.btnDangNhapGoogle);
        mBtnDangKy_signin = (Button) findViewById(R.id.btnDangKy_signin);
        mBtnQuenMatKhau = (Button) findViewById(R.id.btnQuenMatKhau);
    }
}