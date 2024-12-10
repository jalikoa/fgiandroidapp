package com.jalsoft.android.appenv.models;

public class GetDiscussModel {
    String userName,userCountry,sentMessage,sentTime,sender;

    public GetDiscussModel(String userName, String userCountry, String sentMessage, String sentTime, String sender) {
        this.userName = userName;
        this.userCountry = userCountry;
        this.sentMessage = sentMessage;
        this.sentTime = sentTime;
        this.sender = sender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getSentMessage() {
        return sentMessage;
    }

    public void setSentMessage(String sentMessage) {
        this.sentMessage = sentMessage;
    }

    public String getSentTime() {
        return sentTime;
    }

    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
