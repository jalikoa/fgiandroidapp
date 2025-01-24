package com.jalsoft.android.appenv.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jalsoft.android.appenv.R;
import com.jalsoft.android.appenv.adapters.VideoAdapter;
import com.jalsoft.android.appenv.models.VideoModel;

import java.util.ArrayList;
import java.util.List;
public class VideosLearn extends Fragment {
    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private List<VideoModel> videoList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videos_learn, container, false);
        recyclerView = view.findViewById(R.id.videos_recycle);
        videoList = new ArrayList<>();
        videoAdapter = new VideoAdapter(getContext(), videoList);
        recyclerView.setAdapter(videoAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        // Preload data
        loadVideosData();
        return view;
    }

    private void loadVideosData() {
        for (int i = 0; i < 10; i++) {
            videoList.add(new VideoModel(
                    "How to plant a tree",
                    "By Michael Mboya",
                    "1:13:45",
                    "5 years ago"
            ));
        }
        videoAdapter.notifyDataSetChanged();
    }
}
