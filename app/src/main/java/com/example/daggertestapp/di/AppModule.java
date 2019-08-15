package com.example.daggertestapp.di;

import android.app.Application;
import android.content.Context;

import com.example.daggertestapp.api.ApiClient;
import com.example.daggertestapp.model.User;
import com.example.daggertestapp.ui.login.Login;
import com.example.daggertestapp.ui.login.LoginPresenter;
import com.example.daggertestapp.ui.profile.Profile;
import com.example.daggertestapp.ui.profile.ProfilePresenter;
import com.example.daggertestapp.ui.webService.WebService;
import com.example.daggertestapp.ui.webService.WebServicePresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application){
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext(){
        return application;
    }

    /*
    User
     */
    @Provides
    @Singleton
    public User provideUser(){
        return new User();
    }

    /*
    Grafo de retrofit
     */
    private static final String BASE_URL = "https://api.github.com";

    @Singleton
    @Provides
    GsonConverterFactory providesGsonConverterFactory(){
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        return gsonConverterFactory;
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converterFactory){
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(converterFactory)
                .client(client).build();
    }

    @Singleton
    @Provides
    ApiClient provideApiClient(Retrofit retrofit){
        return retrofit.create(ApiClient.class);
    }

    /*
    Grafo de Activities
     */
    @Provides
    @Singleton
    Login.Presenter providePresenterLogin(User user){
        return new LoginPresenter(user);
    }

    /*
    Profile
     */
    @Provides
    @Singleton
    Profile.Presenter providesPresenterProfile(User user){
        return new ProfilePresenter(user);
    }

    @Singleton
    @Provides
    WebService.Presenter provideWebServicePresenter(User user, ApiClient apiClient){
        return new WebServicePresenter(user, apiClient);
    }
}
