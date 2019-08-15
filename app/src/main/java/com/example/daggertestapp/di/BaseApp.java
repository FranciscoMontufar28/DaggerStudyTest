package com.example.daggertestapp.di;

import android.app.Application;

public class BaseApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setUpGraph();
    }

    private void setUpGraph(){
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
