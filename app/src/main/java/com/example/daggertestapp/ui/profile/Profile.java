package com.example.daggertestapp.ui.profile;

import com.example.daggertestapp.model.User;

public interface Profile {

    interface View{
        void showUser(User user);
        void logOut();
    }

    interface Presenter{
        void setView(Profile.View view);
        void updateUser(User updateUser);
        void logOut();
    }
}
