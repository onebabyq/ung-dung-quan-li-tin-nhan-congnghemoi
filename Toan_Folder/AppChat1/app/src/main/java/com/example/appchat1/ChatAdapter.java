package com.example.appchat1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    List<Message> mListMessage;
    Context mContext;

    public ChatAdapter(List<Message> listMessage, Context context){
        this.mListMessage = listMessage;
        this.mContext = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View messageView = inflater.inflate(R.layout.item_message, parent, false);

        return new MyViewHolder(messageView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = mListMessage.get(position);

        holder.imgAvatar.setText(message.getImgAvatar());
        holder.txtMessage.setText(message.getTxtMessage()+ "");
    }

    @Override
    public int getItemCount() {
        return mListMessage.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView imgAvatar;
        TextView txtMessage;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            txtMessage = itemView.findViewById(R.id.txtMessage);
        }
    }
}
