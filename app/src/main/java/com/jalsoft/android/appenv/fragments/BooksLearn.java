package com.jalsoft.android.appenv.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jalsoft.android.appenv.R;
import com.jalsoft.android.appenv.adapters.FileAdapter;
import com.jalsoft.android.appenv.models.FileModel;

import java.util.ArrayList;
import java.util.List;

public class BooksLearn extends Fragment {
    private RecyclerView recyclerView;
    private FileAdapter fileAdapter;
    private List<FileModel> fileList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books_learn, container, false);

        recyclerView = view.findViewById(R.id.books_recycle);
        fileList = new ArrayList<>();
        fileAdapter = new FileAdapter(getContext(), fileList);

        recyclerView.setAdapter(fileAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        // Preload data
        loadBooksData();

        return view;
    }

    private void loadBooksData() {
        for (int i = 0; i < 10; i++) {
            fileList.add(new FileModel(
                    "How to plant a tree in dry conditions.pptx",
                    "By Michael Mboya",
                    "September 10, 2024",
                    "30.34 MB"
            ));
        }
        fileAdapter.notifyDataSetChanged();
    }
}
