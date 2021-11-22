package com.example.androidprojectsmb.adapter;

import static com.example.androidprojectsmb.LoginActivity.LOCALHOST;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidprojectsmb.ChatActivity;
import com.example.androidprojectsmb.R;
import com.example.androidprojectsmb.dto.RoomDTO;
import com.example.androidprojectsmb.dto.UserDTO;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context context;
    ArrayList<UserDTO> listUser;
    private long idAccount;
   // EditText etName;
   // EditText etAge;
    //TextView txtIdHidden;
   // public UserAdapter(Context context, ArrayList<UserDTO> listUser,EditText etName,EditText etAge,TextView txtIdHidden) {
    public UserAdapter(Context context, ArrayList<UserDTO> listUser,long idAccount) {
        this.context = context;
        this.listUser = listUser;
        this.idAccount = idAccount;
       // this.etAge=etAge;
      // this.etName = etName;
        //this.txtIdHidden = txtIdHidden;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_danhba,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserDTO user = listUser.get(position);
        holder.txtId.setText(user.getId()+"");
        holder.txtName.setText(user.getAccount().getUsername());
        holder.txtSDT.setText("SĐT: " +user.getSoDienThoai());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRoomDualByTwoAccountId(idAccount,user.getAccount().getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtId;
        private TextView txtName;
        private TextView txtSDT;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtId);
            txtName = itemView.findViewById(R.id.txtName);
            txtSDT = itemView.findViewById(R.id.txtSDT);
        }
    }
    public void getRoomDualByTwoAccountId(long id1,long id2) {
        String url = LOCALHOST + "/rooms/byTwoAccountId/" + id1+"/"+id2;
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject object = (JSONObject) response;
                Gson gson = new Gson();
                RoomDTO roomDTO= gson.fromJson(String.valueOf(object), RoomDTO.class);
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("idAccount",id1);
                intent.putExtra("idFriend",id2);
                intent.putExtra("idRoom",roomDTO.getId());
                context.startActivity(intent);
                //getListMessageByRoomId(roomDTO.getId());
               // idRoom = roomDTO.getId();
            }
        }, error -> Toast.makeText(context, "Không load được JSON", Toast.LENGTH_SHORT).show());

        requestQueue.add(jsonObjectRequest);
    }
}
