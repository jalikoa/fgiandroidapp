package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.jalsoft.android.appenv.adapters.BooksAdapter;
import com.jalsoft.android.appenv.models.FileModel;

import java.util.ArrayList;
import java.util.List;

public class FilesList extends AppCompatActivity {
        RecyclerView recyclerView;
        RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files_list);
        List<FileModel> fileList;
        fileList = new ArrayList<>();
        BooksAdapter booksAdapter = new BooksAdapter(this,fileList);
        recyclerView = findViewById(R.id.recycle);
        relativeLayout = findViewById(R.id.mainLayout);
        recyclerView.setAdapter(booksAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        int j = 25;
        for (int i = 0;i < j;i++){
            fileList.add(new FileModel("How to plant a tree in the dry conditions How to plant a tree in the dry conditions.pptx","By Michael Mboya on how to make trees","On September Friday 10 2024","30.34 Mbs"));
            fileList.add(new FileModel("Making the best out of bees.pptx","By Calvince Owino Jalikoa making bees for pollination","12/12/2025","20.38 Mbs"));
            fileList.add(new FileModel("Doing cleaning in an effective way .pptx","By James Momanyi How to do cleaning effectively","On August Monday 10 2014","10.12 Mbs"));
        }
    }
}