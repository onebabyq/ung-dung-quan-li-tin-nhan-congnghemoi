package com.example.androidprojectsmb.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidprojectsmb.R;
import com.example.androidprojectsmb.dto.MessageDTO;
import com.example.androidprojectsmb.stomp.dto.ChatMessage;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    Context context;
    ArrayList<MessageDTO> listMessage;
    long idAccount;
   // EditText etName;
   // EditText etAge;
    //TextView txtIdHidden;
   // public UserAdapter(Context context, ArrayList<MessageDTO> listUser,EditText etName,EditText etAge,TextView txtIdHidden) {
    Date date = new Date();
    public static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

    public MessageAdapter(Context context, ArrayList<MessageDTO> listMessage,long idAccount) {
        this.context = context;
        this.listMessage = listMessage;
        this.idAccount=idAccount;
      // this.etName = etName;
        //this.txtIdHidden = txtIdHidden;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_tinnhan,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageDTO message = listMessage.get(position);
        holder.txtId.setText(message.getId()+"");
        holder.txtTime.setText(sdf.format(message.getCreateDate())+"");

        if(message.getContentType().equals("TEXT"))
            holder.txtContent.setText(message.getContent()+"");
        if(message.getContentType().equals("IMAGE")){
            holder.txtContent.setVisibility(View.INVISIBLE);
            holder.imgContent.setVisibility(View.VISIBLE);
            Picasso.get().load(message.getContent()).into(holder.imgContent);
            holder.txtContent.setHeight(200);
            holder.txtContent.setWidth(200);
        }

        if(idAccount==message.getFrom().getId()){
            holder.constraintLayout.setBackgroundResource(R.drawable.mess_dra);
            ConstraintSet constraintSet  = new ConstraintSet();
            constraintSet.clone( holder.constraint_main);
            constraintSet.clear(R.id.view4,ConstraintSet.END);
            constraintSet.connect(R.id.view4,ConstraintSet.START,R.id.constraint_main,ConstraintSet.START,0);
            constraintSet.applyTo(holder.constraint_main);
        }
        else {
            holder.constraintLayout.setBackgroundResource(R.drawable.mess_dra_u);
            ConstraintSet constraintSet  = new ConstraintSet();
            constraintSet.clone( holder.constraint_main);
            constraintSet.clear(R.id.view4,ConstraintSet.START);
            constraintSet.connect(R.id.view4,ConstraintSet.END,R.id.constraint_main,ConstraintSet.END,0);
            constraintSet.applyTo(holder.constraint_main);
        }
      //  holder.txtTime.setText(sdf.format(message.getCreateDate())+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //etName.setText(user.getName());
               // txtIdHidden.setText(user.getId()+"");
               // etAge.setText(user.getAge()+"");
                //Toast.makeText(context,"ID: "+user.getId()+", Name: "+user.getName()+", Age: "+user.getAge(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMessage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtId;
        private TextView txtContent;
        private TextView txtTime;
        private ImageView imgContent;
        private ConstraintLayout constraintLayout,constraint_main;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtId);
            txtContent = itemView.findViewById(R.id.txtContent);
            txtTime = itemView.findViewById(R.id.txtTime);
            constraintLayout = itemView.findViewById(R.id.view4);
            imgContent = itemView.findViewById(R.id.imgContent);
            constraint_main = itemView.findViewById(R.id.constraint_main);

        }


    }
}
