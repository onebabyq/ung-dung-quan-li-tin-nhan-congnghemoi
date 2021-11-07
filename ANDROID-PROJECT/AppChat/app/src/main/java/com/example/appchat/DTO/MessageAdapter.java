package com.example.appchat.DTO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appchat.R;

import java.util.List;

public class MessageAdapter extends BaseAdapter {
    private List<String> mMessageList;
    private Context mContext;
    public MessageAdapter(List<String> messageList, Context context){
        this.mMessageList = messageList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mMessageList == null ? 0 : mMessageList.size();
    }

    @Override
    public String getItem(int position) {
        return mMessageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View newView = view;
        ViewHolder vieHolder;
        if(newView == null){
            newView = LayoutInflater.from(mContext).inflate(R.layout.item_mesage, parent,false);
            vieHolder = new ViewHolder();
            vieHolder.tvMessage = (TextView) newView.findViewById(R.id.tvMessage);
            newView.setTag(vieHolder);
        }else{
            vieHolder = (ViewHolder) view.getTag();
        }
        vieHolder.tvMessage.setText(getItem(position));
        return newView;
    }

    public class ViewHolder{
        private TextView tvMessage;
    }
}
