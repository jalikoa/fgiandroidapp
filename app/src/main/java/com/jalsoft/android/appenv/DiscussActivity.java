package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jalsoft.android.appenv.adapters.GetDiscussAdapter;
import com.jalsoft.android.appenv.models.GetDiscussModel;

import java.util.ArrayList;
import java.util.List;

public class DiscussActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    GetDiscussModel discussModel;
    GetDiscussAdapter discussAdapter;
    List<GetDiscussModel> messageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discuss);
        messageList = new ArrayList<>();
        discussAdapter = new GetDiscussAdapter(this,messageList);
        recyclerView = findViewById(R.id.messageRecycle);
        recyclerView.setAdapter(discussAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        int j = 20;
        for(int i = 0;i < j;i+=1){
            messageList.add(new GetDiscussModel("Hans Jalikoa","Kenya","Hey there bro it is not quite right for us to raise pandemonium in the environment in terms of making things better for the sea life it is quite abusive and extremely annoying to see that we as humen beings are making thins worse in th seas let us stop wasting and dumping wastes in the sease and water points!","12/12/234","me"));
        }

    }
}