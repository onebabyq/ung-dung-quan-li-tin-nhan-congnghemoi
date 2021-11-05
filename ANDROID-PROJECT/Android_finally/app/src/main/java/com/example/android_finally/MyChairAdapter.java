package com.example.android_finally;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyChairAdapter extends RecyclerView.Adapter<MyChairAdapter.MyViewHolder> {
    List<Friend> friendList;
    Context context;

    public MyChairAdapter(List<Friend> friendList, Context context) {
        this.friendList = friendList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(R.layout.item_danhba, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder h, int position) {
        Friend friend = friendList.get(position);
        h.imageAVT.setImageResource(friend.getImageAVT());
        h.txtText.setText(friend.getTxtText());
        h.imageMess.setImageResource(friend.getImageMess());
        h.imageCall.setImageResource(friend.getImageCall());
    }

    @Override
    public int getItemCount() {
        if (friendList!=null)
        return friendList.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtText;
        ImageView imageAVT,imageMess,imageCall;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAVT = itemView.findViewById(R.id.imageAVT);
            txtText= itemView.findViewById(R.id.txtText);

            imageMess = itemView.findViewById(R.id.imageMess);
            imageCall = itemView.findViewById(R.id.imageCall);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
