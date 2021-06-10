package com.example.myui;

import java.io.Serializable;

public class UserMail implements Serializable {

    private String userName;
    private String userType;

    private boolean active;

    public UserMail(String userName, String userType){
        this.userName = userName;
        this.userType = userType;
        this.active = true;
    }

    public UserMail(String userName, String userType, boolean active ){
        this.userName = userName;
        this.userType = userType;
        this.active = active;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType(){
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString(){
        return this.userName + "("+ this.userType+")";
    }
}
