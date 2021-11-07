package com.example.android_finally;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SigninActivity extends AppCompatActivity {
    EditText txtSoDienThoai, txtMatKhau;
    Button btnDangNhap, btnDangNhapGoogle, btnQuenMatKhau;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSoDienThoai = findViewById(R.id.txtSoDienThoai);
        txtMatKhau = findViewById(R.id.txtMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangNhapGoogle = findViewById(R.id.btnDangNhapGoogle);
        btnQuenMatKhau = findViewById(R.id.btnQuenMatKhau);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sdt = txtSoDienThoai.getText().toString();
                String mk = txtMatKhau.getText().toString();
                if(sdt.equals("") && mk.equals("")){
                    Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
