package com.example.appchat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Account> listAccount;
    ImageButton btnMore = findViewById(R.id.btnMore);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAccount  = new ArrayList<>();
        //Room room = new Room(4,2,"Personal",false,1);
        getRooms();
        //updateRoomByRoomId(4,room);
        //getAccountByRoomId(4);

//        btnMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    public void getRooms() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.8:3000/accountToRooms";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = (JSONObject) response.get(i);
                        Gson gson = new Gson();
                        Account p = gson.fromJson(String.valueOf(object), Account.class);
                        listAccount.add(p);
                        System.out.println(p.toString());
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
    }

//    public void getAccountByRoomId(int roomId) {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "http://192.168.1.8:3000/accountToRooms/" + roomId ;
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject object = (JSONObject) response.get(i);
//                        Gson gson = new Gson();
//                        Account p = gson.fromJson(String.valueOf(object), Account.class);
//
//                        for (Account_Room acc_room : p.getListAccountRoom()) {
//                            if (acc_room.getRoom().getId() == roomId) {
//                                listAccount.add(p);
//                            }
//                        }
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
//
//    public void updateRoomByRoomId(int roomId, Room room) {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "http://192.168.1.8:3000/accountToRooms/" + roomId ;
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject object = (JSONObject) response.get(i);
//                        Gson gson = new Gson();
//                        Account p = gson.fromJson(String.valueOf(object), Account.class);
//
//                        for (Account_Room acc_room : p.getListAccountRoom()) {
//                            if (acc_room.getRoom().getId() == roomId) {
//                                acc_room.getRoom().setLastMessageId(room.getLastMessageId());
//                                acc_room.getRoom().setAdminId(room.getAdminId());
//                                acc_room.getRoom().setType(room.getType());
//                                acc_room.getRoom().setDeleted(room.isDeleted());
//                                System.out.println(acc_room.getRoom().toString());
//                            }
//                        }
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
//
//    public void deleteRoomByRoomId(int roomId) {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "http://192.168.1.8:3000/accountToRooms/" + roomId ;
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject object = (JSONObject) response.get(i);
//                        Gson gson = new Gson();
//                        Account p = gson.fromJson(String.valueOf(object), Account.class);
//
//                        for (Account_Room acc_room : p.getListAccountRoom()) {
//                            if (acc_room.getRoom().getId() == roomId) {
//                                p.getListAccountRoom().remove(acc_room.getRoom().getId());
//                            }
//                        }
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

}