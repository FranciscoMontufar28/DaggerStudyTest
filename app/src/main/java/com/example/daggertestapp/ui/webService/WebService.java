package com.example.daggertestapp.ui.webService;

import com.example.daggertestapp.model.User;

public interface WebService {

    interface View{
        void showUser(User user);
    }
    interface Presenter{
        void setView(WebService.View view);
        void solicitudWebService();
    }
}
