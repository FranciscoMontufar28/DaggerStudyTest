package com.example.daggertestapp.ui.webService;

import android.util.Log;

import com.example.daggertestapp.api.ApiClient;
import com.example.daggertestapp.model.GitHubRepo;
import com.example.daggertestapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServicePresenter implements WebService.Presenter {

    private User user;
    private ApiClient apiClient;
    private WebService.View view;

    public WebServicePresenter(User user, ApiClient apiClient){
        this.user = user;
        this.apiClient = apiClient;
    }

    @Override
    public void setView(WebService.View view) {
        this.view = view;
        view.showUser(user);
    }

    @Override
    public void solicitudWebService() {
        Call<List<GitHubRepo>> call = apiClient.getReposForUser("albertoandroid");
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                for(int i=0; i<response.body().size();i++){
                    GitHubRepo git = response.body().get(i);
                    Log.d("TAG1",  "Respo "+i+", Nombre:" + git.getName());
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });
    }
}
