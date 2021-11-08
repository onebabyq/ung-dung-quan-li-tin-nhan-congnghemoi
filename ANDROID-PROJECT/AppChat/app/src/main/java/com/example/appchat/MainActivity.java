package com.example.appchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
                String sdt, password;
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
                //new Task().execute();
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        mBtnDangKy_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DangKyActivity.class);
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

    class Task extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.8:9000/chat_db", "root","sapassword");
            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }
    }
}