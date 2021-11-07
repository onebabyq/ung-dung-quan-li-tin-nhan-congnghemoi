package com.example.appchat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DangKyActivity extends AppCompatActivity {
    private EditText mEditSoDienThoai_signup, mEditEmail, mEditMatKhau_signup, mEditNhapLaiMatKhau;
    private Button mBtnDangKy_signup, mBtnDaCoTaiKhoan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        initViews();
    }

    public void initViews(){
        mEditSoDienThoai_signup = (EditText) findViewById(R.id.editSoDienThoai_signup);
        mEditEmail = (EditText) findViewById(R.id.editEmail);
        mEditMatKhau_signup = (EditText) findViewById(R.id.editMatKhau_signup);
        mEditNhapLaiMatKhau = (EditText) findViewById(R.id.editNhapLaiMatKhau);
        mBtnDangKy_signup = (Button) findViewById(R.id.btnDangKy_signup);
        mBtnDaCoTaiKhoan = (Button) findViewById(R.id.btnDaCoTaiKhoan);
    }
}
