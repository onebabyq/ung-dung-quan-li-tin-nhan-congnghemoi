package com.example.appchat;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appchat.DTO.Contact;
import com.example.appchat.DTO.Friend;
import com.example.appchat.DTO.MyChairAdapter;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DanhBaActivity extends AppCompatActivity {
//    List<Account> listAccount;
    RecyclerView recyclerView;
    List<Friend> fiendList;
    List<Contact> listFriend;
    MyChairAdapter myChairAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listFriend = new ArrayList<>();
//        listAccount = new ArrayList<>();
        fiendList = new ArrayList<>();


        getDanhBaById(1);
        setContentView(R.layout.acti_danhba);
        recyclerView = findViewById(R.id.recyclerView);
        myChairAdapter = new MyChairAdapter(fiendList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(myChairAdapter);




    }
    public void getDanhBaById(int id) {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.242.9:3000/danhba/"+id;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = (JSONObject) response.get(i);
                        Gson gson = new Gson();
                        Contact p = gson.fromJson(String.valueOf(object), Contact.class);

                        fiendList.add(new Friend(R.drawable._061334, p.getFriend().toString(),R.drawable._21014,R.drawable._762106));
                        myChairAdapter.notifyDataSetChanged();


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
        //Toast.makeText(MainActivity.this,"Độ dài chuỗi function: "+listContact.size(), Toast.LENGTH_LONG).show();

    }
//    public void getRoomByRoomId(int id) {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "http://192.168.242.9:3000/accountToRooms/"+id;
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject object = (JSONObject) response.get(i);
//                        Gson gson = new Gson();
//                        Account p = gson.fromJson(String.valueOf(object), Account.class);
//                        listAccount.add(p);
//                        System.out.println(p.toString());
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }, error -> {
//            Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
//
//            Toast.makeText(this, "Error with JSON Array Object", Toast.LENGTH_SHORT).show();
//        });
//
//        queue.add(jsonArrayRequest);
//    }

//    public void getUsers() {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "http://192.168.43.81:3000/users";
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject object = (JSONObject) response.get(i);
//                        Gson gson = new Gson();
//                        User p = gson.fromJson(String.valueOf(object), User.class);
//                        listUser.add(p);
//                        System.out.println(p.toString());
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }, error -> {
//            Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
//
//            Toast.makeText(this, "Error with JSON Array Object", Toast.LENGTH_SHORT).show();
//        });
//
//        queue.add(jsonArrayRequest);
//    }


//    public void getRoomByAccount() {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "http://192.168.43.81:3000/accountToRooms";
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject object = (JSONObject) response.get(i);
//                        Gson gson = new Gson();
//                        Account p = gson.fromJson(String.valueOf(object), Account.class);
//                        listAccount.add(p);
//                        System.out.println(p.toString());
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }, error -> {
//            Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
//
//            Toast.makeText(this, "Error with JSON Array Object", Toast.LENGTH_SHORT).show();
//        });
//
//        queue.add(jsonArrayRequest);
//    }
//    public void getFriendByAccountId(int accountId) {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "http://192.168.43.81:3000/danhba/"+accountId;
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject object = (JSONObject) response.get(i);
//                        Gson gson = new Gson();
//                        Contact p = gson.fromJson(String.valueOf(object), Contact.class);
//                        listFriend.add(p);
//                        System.out.println(p.toString());
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }, error -> {
//            Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
//
//            Toast.makeText(this, "Error with JSON Array Object", Toast.LENGTH_SHORT).show();
//        });
//
//        queue.add(jsonArrayRequest);
//    }

}
