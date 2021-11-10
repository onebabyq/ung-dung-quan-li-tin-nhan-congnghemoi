package com.example.appchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.appchat.Activities.ChatActivity;
import com.example.appchat.Activities.SignupActivity;

import java.net.URI;
import java.net.URISyntaxException;

import tech.gusavila92.websocketclient.WebSocketClient;

public class MainActivity extends AppCompatActivity {
    private EditText mEditPhone_signin, mEditPass_sigin;
    private Button mBtnSignin_signin, mBtnSigninGoogle, mBtnForgotPass, mBtnSignup_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mBtnSignin_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        mBtnSignup_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initViews(){
        mEditPhone_signin = (EditText) findViewById(R.id.editSoDienThoai_signin);
        mEditPass_sigin = (EditText) findViewById(R.id.editMatKhau_signin);
        mBtnSignin_signin = (Button) findViewById(R.id.btnDangNhap_signin);
        mBtnSigninGoogle = (Button) findViewById(R.id.btnDangNhapGoogle);
        mBtnSignup_signin = (Button) findViewById(R.id.btnDangKy_signin);
        mBtnForgotPass = (Button) findViewById(R.id.btnQuenMatKhau);
    }
}