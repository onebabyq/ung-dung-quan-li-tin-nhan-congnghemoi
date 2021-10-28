package com.example.cong_nghe_moi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity {
    List<Account> listAccount;
    RecyclerView recyclerView;
    List<Friend> fiendList;
    List<Contact> listFriend;
    MyChairAdapter myChairAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         getDanhBaById(1);
        setContentView(R.layout.acti_danhba);
        fiendList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        myChairAdapter = new MyChairAdapter(fiendList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(myChairAdapter);
    }
    public void getDanhBaById(int id) {
        List<Contact> listContact = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.0.110:3000/danhba/"+id;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        fiendList = new ArrayList<>();
                        JSONObject object = (JSONObject) response.get(i);
                        Gson gson = new Gson();
                        Contact p = gson.fromJson(String.valueOf(object), Contact.class);

                        fiendList.add(new Friend(R.drawable._061334, p.getFriend().getUsername(),R.drawable._21014,R.drawable._762106));
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
        Toast.makeText(MainActivity.this,"Độ dài chuỗi function: "+listContact.size(), Toast.LENGTH_LONG).show();


    }
}