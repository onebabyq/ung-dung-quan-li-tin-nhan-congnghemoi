package com.example.appchat1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRoom();
    }

    public void getRoom() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.8:3000/accountToRooms";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Account> listAccount = new ArrayList<>();
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

//    public void getRoomById(int roomId) {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "http://192.168.242.9:3000/accountToRooms/" + roomId ;
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                Gson gson = new Gson();
//
//                List<Account> listAccount = null;
//                for (int i = 0; i < accounts.length(); i++) {
//                    int size =
//                    try {
//                        JSONObject object = (JSONObject) response.get(i);
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
}