package com.example.androidprojectsmb;



import static com.example.androidprojectsmb.LoginActivity.LOCALHOST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidprojectsmb.dto.AccountDTO;
import com.example.androidprojectsmb.dto.UserDTO;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
    private EditText mEditPhone_signup, mEditHoTen, mEditPass_signup, mEditRePass;
    private Button mBtnSignup_signup, mBtnHaveAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        initViews();
        mBtnSignup_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDTO userDTO = new UserDTO();
                userDTO.setSoDienThoai(mEditPhone_signup.getText().toString());
                userDTO.setPassword(mEditPass_signup.getText().toString());
                userDTO.setEnable(true);
                AccountDTO a = new AccountDTO();
                a.setUsername(mEditHoTen.getText().toString());
                userDTO.setAccount(a);
                sendRegister(userDTO);
                Toast toast = Toast.makeText(SignupActivity.this,"Đăng ký thành công!!!",Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

   // private void PostApi(String name, String age){
    private void sendRegister(UserDTO user){
        try {
            String url = LOCALHOST+"/users";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("soDienThoai", user.getSoDienThoai());
            jsonBody.put("password", user.getPassword());
            jsonBody.put("enable", user.isEnable());
        //    jsonBody.put("roles", user.getRoles());
            JSONObject accountJson = new JSONObject();
            accountJson.put("username",user.getAccount().getUsername());

            jsonBody.put("account", accountJson);
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response+"ERR1");
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString()+"ERR2");
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void initViews(){
        mEditPhone_signup = (EditText) findViewById(R.id.editSoDienThoai_signup);
        mEditHoTen = (EditText) findViewById(R.id.editHoTen);
        mEditPass_signup = (EditText) findViewById(R.id.editMatKhau_signup);
        mEditRePass = (EditText) findViewById(R.id.editNhapLaiMatKhau);
        mBtnSignup_signup = (Button) findViewById(R.id.btnDangKy_signup);
        mBtnHaveAccount = (Button) findViewById(R.id.btnDaCoTaiKhoan);
    }
}