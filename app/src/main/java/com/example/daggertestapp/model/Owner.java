package com.example.daggertestapp.model;

import com.google.gson.annotations.SerializedName;

public class Owner {

    private String login;

    @SerializedName("avatar_name")
    private String avatarUrl;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
