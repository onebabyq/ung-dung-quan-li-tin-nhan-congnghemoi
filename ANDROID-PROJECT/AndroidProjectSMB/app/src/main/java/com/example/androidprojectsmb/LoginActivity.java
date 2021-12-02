package com.example.androidprojectsmb;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidprojectsmb.R;
import com.example.androidprojectsmb.dto.UserDTO;
import com.google.gson.Gson;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends AppCompatActivity {
    public static final String LOCALHOST = "http://192.168.1.7:9000/api";
    private EditText mEditPhone_signin, mEditPass_sigin;
    private Button mBtnSignin_signin, mBtnSigninGoogle, mBtnForgotPass, mBtnSignup_signin;
    private UserDTO tempUserDTO=new UserDTO();
    private List<UserDTO> listUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        listUser = new ArrayList<>();
        initViews();

        mBtnSignin_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEnter = mEditPhone_signin.getText().toString();
                String passEnter = mEditPass_sigin.getText().toString();
                checkLogin(userEnter,passEnter);
            }
        });

        mBtnSignup_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
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
    public void checkLogin(String sdt,String pass) {
        String url = LOCALHOST+"/users/bySoDienThoai/"+sdt;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                JSONObject object = (JSONObject) response;
                Gson gson = new Gson();
                UserDTO userDTO= gson.fromJson(String.valueOf(object), UserDTO.class);
                if(userDTO.getPassword().equals(pass)){
                    Intent intent =new Intent(LoginActivity.this,DanhBaActivity.class);
                    intent.putExtra("idAccount",userDTO.getAccount().getId());
                    startActivity(intent);
                }
                else Toast.makeText(LoginActivity.this,"Sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(LoginActivity.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show());

        requestQueue.add(jsonObjectRequest);
    }

}
/*

public class ParseJSON {
    static String json = "...";
    public static void main(String[] args) {
        JSONObject obj = new JSONObject(json);
        String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        System.out.println(pageName);

        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
        }
    }
}
 */