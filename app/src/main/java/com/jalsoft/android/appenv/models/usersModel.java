package com.jalsoft.android.appenv.models;
public class usersModel {
    String regId,userName,gender,userPhone,about,userCountry,registeredDate;

    public usersModel(String regId, String userName, String gender, String userPhone, String about, String userCountry, String registeredDate) {
        this.regId = regId;
        this.userName = userName;
        this.gender = gender;
        this.userPhone = userPhone;
        this.about = about;
        this.userCountry = userCountry;
        this.registeredDate = registeredDate;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
