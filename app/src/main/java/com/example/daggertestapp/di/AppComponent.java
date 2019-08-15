package com.example.daggertestapp.di;

import com.example.daggertestapp.ui.login.LoginActivity;
import com.example.daggertestapp.ui.profile.ProfileActivity;
import com.example.daggertestapp.ui.webService.WebServiceActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(LoginActivity loginActivity);
    void inject(ProfileActivity profileActivity);
    void inject(WebServiceActivity webServiceActivity);
}
