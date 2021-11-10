package com.example.appchat.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appchat.MainActivity;
import com.example.appchat.R;

public class SignupActivity extends AppCompatActivity {
    private EditText mEditPhone_signup, mEditEmail, mEditPass_signup, mEditRePass;
    private Button mBtnSignup_signup, mBtnHaveAccount;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        initViews();

        mBtnHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mBtnSignup_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initViews(){
        mEditPhone_signup = (EditText) findViewById(R.id.editSoDienThoai_signup);
        mEditEmail = (EditText) findViewById(R.id.editEmail);
        mEditPass_signup = (EditText) findViewById(R.id.editMatKhau_signup);
        mEditRePass = (EditText) findViewById(R.id.editNhapLaiMatKhau);
        mBtnSignup_signup = (Button) findViewById(R.id.btnDangKy_signup);
        mBtnHaveAccount = (Button) findViewById(R.id.btnDaCoTaiKhoan);
    }
}
