package com.jalsoft.android.appenv.models;

public class VideoModel {
    String fileName,byWho,videoDuration,uploadedTime;

    public VideoModel(String fileName, String byWho, String videoDuration, String uploadedTime) {
        this.fileName = fileName;
        this.byWho = byWho;
        this.videoDuration = videoDuration;
        this.uploadedTime = uploadedTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getByWho() {
        return byWho;
    }

    public void setByWho(String byWho) {
        this.byWho = byWho;
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }

    public String getUploadedTime() {
        return uploadedTime;
    }

    public void setUploadedTime(String uploadedTime) {
        this.uploadedTime = uploadedTime;
    }
}
