package com.jalsoft.android.appenv.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jalsoft.android.appenv.R;
import com.jalsoft.android.appenv.models.GetDiscussModel;

import java.util.List;

public class GetDiscussAdapter extends RecyclerView.Adapter<GetDiscussAdapter.messageHolder> {
    Context context;
    List<GetDiscussModel> messageList;

    public GetDiscussAdapter(Context context, List<GetDiscussModel> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public messageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discuss_message,parent,false);
        messageHolder messageHolder = new messageHolder(view);
        return messageHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull messageHolder holder, int position) {
        GetDiscussModel getDiscussModel = messageList.get(position);
        holder.userName.setText(getDiscussModel.getUserName());
        holder.userCountry.setText(getDiscussModel.getUserCountry());
        holder.sentMessage.setText(getDiscussModel.getSentMessage());
        holder.sentTime.setText(getDiscussModel.getSentTime());
//        if(getDiscussModel.getSender().equals("me")){
//            holder.messageHolder
//        }
//        Adjust this later to set the background of the message holder as well as the position based on who sends the message
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static  class messageHolder extends RecyclerView.ViewHolder{
        TextView userName,userCountry,sentMessage,sentTime;
        LinearLayout messageHolder;
        public messageHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            userCountry = itemView.findViewById(R.id.userCountry);
            sentMessage = itemView.findViewById(R.id.sentText);
            sentTime = itemView.findViewById(R.id.sentTime);
            messageHolder = itemView.findViewById(R.id.message);
        }
    }
}
