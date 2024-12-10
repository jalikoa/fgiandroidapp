package com.jalsoft.android.appenv.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jalsoft.android.appenv.R;
import com.jalsoft.android.appenv.models.VideoModel;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {
    Context context;
    List<VideoModel> videoList;

    public VideoAdapter(Context context, List<VideoModel> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.videos_holder,parent,false);
        VideoHolder videoHolder = new VideoHolder(view);
        return videoHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        VideoModel videoModel = videoList.get(position);
        holder.vidName.setText(videoModel.getFileName());
        holder.vidDur.setText(videoModel.getVideoDuration());
        holder.vidDesc.setText(videoModel.getByWho());
        holder.vidUploaded.setText(videoModel.getUploadedTime());

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public static class VideoHolder extends RecyclerView.ViewHolder {
        TextView vidName,vidDur,vidDesc,vidUploaded;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            vidName = itemView.findViewById(R.id.vidName);
            vidDur = itemView.findViewById(R.id.VidDuration);
            vidDesc = itemView.findViewById(R.id.fileUploader);
            vidUploaded = itemView.findViewById(R.id.uploadedAt);
        }
    }
}
