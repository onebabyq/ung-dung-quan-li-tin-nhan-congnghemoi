package com.example.android_finally;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private com.example.android_finally.RegisterActivity context;
    private EditText editUserName;
    private EditText editPassword;
    private EditText editPassword2;
    private TextView loi2;
    private TextView loi4;
    String url = "http://192.168.1.23:3000/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        context = this;
        connectView();
    }
    private void connectView() {
        loi2 = (TextView) findViewById(R.id.textLoi2);
        loi2.setVisibility(View.INVISIBLE);
        loi4 = (TextView) findViewById(R.id.textLoi4);
        loi4.setVisibility(View.INVISIBLE);
        editUserName = (EditText) findViewById(R.id.soDienThoai);
        editPassword = (EditText) findViewById(R.id.editTextMatKhau);
        editPassword2 = (EditText) findViewById(R.id.editTextMatKhau2);
        findViewById(R.id.buttonSDT).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.buttonSDT:
                loi2 = (TextView) findViewById(R.id.textLoi2);
                loi2.setVisibility(View.INVISIBLE);
                loi4 = (TextView) findViewById(R.id.textLoi4);
                loi4.setVisibility(View.INVISIBLE);
               // PostApi(url);
                //getuser(url);
               Testpost(url);
                break;
        }
    }
    // lấy dữ liệu Account từ user
    //  public void getAccountById(String url,int id) {
    //     RequestQueue queue = Volley.newRequestQueue(this);
    //     JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url+'/'+id, new Response.Listener<JSONArray>() {
    //        @Override
    //         public void onResponse(JSONArray response) {
    //             for (int i = 0; i < response.length(); i++) {
    //                 try {
    //                     JSONObject object = (JSONObject) response.get(i);
    //                     Gson gson = new Gson();
    //                     User p = gson.fromJson(String.valueOf(object), User.class);
    //                     Account account = p;
    //                 } catch (JSONException e) {
    //                     e.printStackTrace();
    //                 }
    //             }
    //        }
    //    }, error -> {
    //       Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
    //       Toast.makeText(this, "Error with JSON Array Object", Toast.LENGTH_SHORT).show();
    //   });
    //    queue.add(jsonArrayRequest);
    // }


// lấy dữ liệu của cac room thuộc về accountid
  //  public void getRoomById(String url,int id) {
   //     RequestQueue queue = Volley.newRequestQueue(this);
   //     JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url+'/'+id, new Response.Listener<JSONArray>() {
    //        @Override
   //         public void onResponse(JSONArray response) {
   //             for (int i = 0; i < response.length(); i++) {
   //                 try {
   //                     JSONObject object = (JSONObject) response.get(i);
   //                     Gson gson = new Gson();
   //                     User p = gson.fromJson(String.valueOf(object), Room.class);
   //                     listRoom.add(p);
   //                 } catch (JSONException e) {
   //                     e.printStackTrace();
   //                 }
   //             }
    //        }
    //    }, error -> {
     //       Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
     //       Toast.makeText(this, "Error with JSON Array Object", Toast.LENGTH_SHORT).show();
    //   });
    //    queue.add(jsonArrayRequest);
   // }
    private void Testpost(String url) {
        final int[] maxid = {0};
        int i;
        final boolean[] kt = {true};
        String sdt = editUserName.getText().toString().trim();
        String pass = editPassword.getText().toString().trim();
        String pass2 = editPassword2.getText().toString().trim();
        System.out.println("Mark 1");
        if (!pass.equals(pass2)){
            kt[0] =false;
            loi4 = (TextView) findViewById(R.id.textLoi4);
            loi4.setVisibility(View.VISIBLE);
        }
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = (JSONObject) response.get(i);
                        Gson gson = new Gson();
                        User p = gson.fromJson(String.valueOf(object), User.class);

                        if (maxid[0] > p.getId()) {
                            maxid[0] = p.getId();
                        }
                        if (p.getSoDienThoai().equals(sdt)){
                            kt[0] =false;
                            loi2 = (TextView) findViewById(R.id.textLoi2);
                            loi2.setVisibility(View.VISIBLE);
                            }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, error -> {
            Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Error with JSON Array Object", Toast.LENGTH_SHORT).show();
        });
        queue.add(jsonArrayRequest);
        if(kt[0]) {
            try {
                System.out.println("Mark 1");
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                JSONObject jsonBody = new JSONObject();
                jsonBody.put("id", maxid[0] +1);
                jsonBody.put("soDienThoai", sdt);
                jsonBody.put("password", pass);
                jsonBody.put("enable", true);
                final String mRequestBody = jsonBody.toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                   @Override
                  public void onResponse(String response) {
                        Log.i("LOG_VOLLEY", response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("LOG_VOLLEY", error.toString());
                    }
                }) {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }

                    @Override
                        public byte[] getBody() throws AuthFailureError {
                            try {
                            return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                            } catch (UnsupportedEncodingException uee) {
                                VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                            return null;
                        }
                    }
                    @Override
                    protected Response<String> parseNetworkResponse(NetworkResponse response) {
                        String responseString = "";
                        if (response != null) {
                            responseString = String.valueOf(response.statusCode);
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                    }
                };
                    requestQueue.add(stringRequest);} catch (JSONException e) {
                    e.printStackTrace();
                }
            startActivity(new Intent(context, LoginActivity.class));
            }
    }
}

