package com.example.dangnhap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends AppCompatActivity implements OnClickListener {
    private List<User> listUser;
    private static final int REQUEST_CODE_REGISTER = 1;
    private Context context;
    private EditText editUserName;
    private EditText editPassword;
    private TextView loi;
    String url = "http://192.168.1.23:3000/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        listUser = new ArrayList<>();

        context = this;
        connectView();
    }
    private void connectView() {
        editUserName = (EditText) findViewById(R.id.username);
        editPassword = (EditText) findViewById(R.id.password);
        loi = (TextView) findViewById(R.id.textLoi);
        loi.setVisibility(View.INVISIBLE);
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.buttonRegister).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.login:
                loi = (TextView) findViewById(R.id.textLoi);
                loi.setVisibility(View.INVISIBLE);
                login_fix(url);
                break;
            case R.id.buttonRegister:
                register();
                break;
        }
    }

    private void register() {
            Intent intent = new Intent(context, RegisterActivity.class);
            startActivityForResult(intent, REQUEST_CODE_REGISTER);
    }

    public void login_fix(String URL) {
        final boolean[] kt = new boolean[1];
        kt[0] = false;
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = URL;
            // get data
            String sdt = editUserName.getText().toString().trim();
            String pass = editPassword.getText().toString().trim();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = (JSONObject) response.get(i);
                        Gson gson = new Gson();
                        User p = gson.fromJson(String.valueOf(object), User.class);
                      //  listUser.add(p);
                        if(p.getSoDienThoai().equals(sdt) && p.getPassword().equals(pass)){
                            System.out.println("Dang nhap thanh cong !!!");
                            startActivity(new Intent(context, MainActivity.class));
                            kt[0] = true;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if(!kt[0])
                loi = (TextView) findViewById(R.id.textLoi);
                loi.setVisibility(View.VISIBLE);
            }
        }, error -> {
                Toast.makeText(LoginActivity.this, "sai mk", Toast.LENGTH_SHORT).show();

        });
        queue.add(jsonArrayRequest);
    }
    //private void login(String url) {
     //   System.out.println("Mark 1");
     //   final boolean[] kt = new boolean[1];
     //   kt[0] = false;
        // get data
     //   String sdt = editUserName.getText().toString().trim();
     //   String pass = editPassword.getText().toString().trim();
      //  System.out.println("Mark 1.1");
      //  JsonArrayRequest jsonArrayRequest =
       //         new JsonArrayRequest(url,
      //                  new Response.Listener<JSONArray>() {
      //                      @Override
      //                     public void onResponse(JSONArray response) {
      //                          System.out.println("Mark 2");
      //                         for (int i = 0; i < response.length(); i++) {
      //                              try {
      //                                  System.out.println("Mark 3");
      //                                  JSONObject object = (JSONObject) response.get(i);
      //                                  String SDT = (String) object.get("soDienThoai");
      //                                  String MK = (String) object.get("password");
      //                                  System.out.println("SDT: "+SDT+" / MK: "+MK);
//
      //                                  boolean TT = (boolean) object.get("enable");
       //                                 if (SDT.equals(sdt) && MK.equals(pass) && TT == true) {
       //                                     Gson gson = new Gson();
       //                                     User p = gson.fromJson(String.valueOf(object), User.class);
        //                                    i = response.length() + 1;
        //                                    kt[0] = true;
       //                                }
        //                            } catch (JSONException e) {
       //                                 e.printStackTrace();
       //                            }
        //                        }
       //                     }
       //                 }, new Response.ErrorListener() {
        //            @Override
        //            public void onErrorResponse(VolleyError error) {
       //                 if (kt[0]) {
       //                     System.out.println("Mark 4");
       //                     // create intent to show Main Activity
       //                     Intent intent = new Intent(context, MainActivity.class);
        //                    // start Main Activity
       //                    startActivity(intent);
       //                 } else
       //                     Toast.makeText(LoginActivity.this, "sai mk", Toast.LENGTH_SHORT).show();
        //            }
        //        });
      //  RequestQueue requestQueue = Volley.newRequestQueue(this);
      //  requestQueue.add(jsonArrayRequest);
    //}
}


