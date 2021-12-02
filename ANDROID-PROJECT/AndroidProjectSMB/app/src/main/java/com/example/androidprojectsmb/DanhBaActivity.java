package com.example.androidprojectsmb;

import static com.example.androidprojectsmb.LoginActivity.LOCALHOST;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import com.android.volley.toolbox.Volley;
import com.example.androidprojectsmb.adapter.UserAdapter;

import com.example.androidprojectsmb.dto.UserDTO;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DanhBaActivity extends AppCompatActivity {
    ArrayList<UserDTO> listUser;
    UserAdapter adapter;
    RecyclerView recyclerView;
   // Button btnAdd,btnEdit,btnDel;
    //EditText etName,etAge;
   // TextView txtIdHidden;
    private long idAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acti_danhba);
        Intent intent = getIntent();
        idAccount = intent.getLongExtra("idAccount", 42);
        initViews();
    }

    public void initViews(){
        listUser = new ArrayList<>();
        getListContactByAccountId(idAccount);
        adapter = new UserAdapter(this,listUser,idAccount);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    public void getListContactByAccountId(long id) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = LOCALHOST+"/users/byContactOfAccountId/"+id;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = (JSONObject) response.get(i);
                        Gson gson = new Gson();
                        listUser.add(gson.fromJson(String.valueOf(object), UserDTO.class));
                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, error -> Toast.makeText(DanhBaActivity.this, "Error with JSON Array Object", Toast.LENGTH_SHORT).show());
        queue.add(jsonArrayRequest);
    }

}