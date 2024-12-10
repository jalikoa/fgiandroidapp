package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.jalsoft.android.appenv.adapters.FileAdapter;
import com.jalsoft.android.appenv.adapters.LearnAdpater;
import com.jalsoft.android.appenv.adapters.VideoAdapter;
import com.jalsoft.android.appenv.models.FileModel;
import com.jalsoft.android.appenv.models.VideoModel;

import java.util.ArrayList;
import java.util.List;

public class LearnActivity extends AppCompatActivity {
    TabLayout eduCont;
    ViewPager2 viewPager2;
    LearnAdpater learnAdpater;
    FileAdapter fileAdapter;
    List<FileModel> fileList;
    RecyclerView recyclerView,vidaRecyclerView;
    List<VideoModel> videoList;
    VideoAdapter videoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        eduCont = findViewById(R.id.nav_tab);
        learnAdpater = new LearnAdpater(this);
        viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setAdapter(learnAdpater);
        fileList = new ArrayList<>();
        fileAdapter = new FileAdapter(this,fileList);
        videoList = new ArrayList<>();
        videoAdapter = new VideoAdapter(this,videoList);
        eduCont.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 3){
                    recyclerView = (RecyclerView) viewPager2.findViewById(R.id.books_recycle);
                    recyclerView.setAdapter(fileAdapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(LearnActivity.this));
                    recyclerView.addItemDecoration(new DividerItemDecoration(LearnActivity.this,DividerItemDecoration.VERTICAL));
                    int j = 10;
                    for (int i = 0;i < j;i++){

                        fileList.add(new FileModel("How to plant a tree in the dry conditions How to plant a tree in the dry conditions.pptx","By Michael Mboya on how to make trees","On September Friday 10 2024","30.34 Mbs"));
                        fileList.add(new FileModel("Making the best out of bees.pptx","By Calvince Owino Jalikoa making bees for pollination","12/12/2025","20.38 Mbs"));
                        fileList.add(new FileModel("Doing cleaning in an effective way .pptx","By James Momanyi How to do cleaning effectively","On August Monday 10 2014","10.12 Mbs"));
                    }
                }
                if(tab.getPosition() == 2){
                    vidaRecyclerView = (RecyclerView) viewPager2.findViewById(R.id.videos_recycle);
                    vidaRecyclerView.setAdapter(videoAdapter);
                    vidaRecyclerView.setHasFixedSize(true);
                    vidaRecyclerView.setLayoutManager(new LinearLayoutManager(LearnActivity.this));
                    vidaRecyclerView.addItemDecoration(new DividerItemDecoration(LearnActivity.this,DividerItemDecoration.VERTICAL));
                    int j = 10;
                    for (int i = 0;i < j;i++){

                        videoList.add(new VideoModel("How to plant a tree in the dry conditions How to plant a tree","By Michael Mboya on how to make trees","1:13:45","5 years ago"));
                        videoList.add(new VideoModel("Making the best out of bees","By Calvince Owino Jalikoa making bees for pollination","00:45:00","8 days ago"));
                        videoList.add(new VideoModel("Doing cleaning in an effective way","By James Momanyi How to do cleaning effectively","03:23:45","2 mins ago"));
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                eduCont.getTabAt(position).select();
            }
        });

    }

}