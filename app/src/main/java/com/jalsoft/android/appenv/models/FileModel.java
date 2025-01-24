package com.jalsoft.android.appenv.models;

public class FileModel {
    String fileName,fileDescription,dateFilePosted,fileSize;

    public FileModel(String fileName, String fileDescription, String dateFilePosted,String fileSize) {
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.dateFilePosted = dateFilePosted;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getDateFilePosted() {
        return dateFilePosted;
    }

    public void setDateFilePosted(String dateFilePosted) {
        this.dateFilePosted = dateFilePosted;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}

