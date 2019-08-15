package com.example.daggertestapp.ui.webService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.daggertestapp.R;
import com.example.daggertestapp.di.BaseApp;
import com.example.daggertestapp.model.User;
import com.example.daggertestapp.ui.profile.ProfileActivity;

import javax.inject.Inject;

public class WebServiceActivity extends AppCompatActivity implements WebService.View{

    private Button btnRegresarAProfile;
    private Button btnHacerPeticionWeb;
    private TextView tvUserName;
    private TextView tvEdad;

    @Inject
    WebService.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);
        ((BaseApp)getApplication()).getAppComponent().inject(this);
        setUpWebService();
        presenter.setView(this);
    }

    private void setUpWebService(){
        tvUserName = findViewById(R.id.tvUserName);
        tvEdad = findViewById(R.id.tvEdad);

        btnHacerPeticionWeb = findViewById(R.id.btnHacerPeticionWeb);
        btnHacerPeticionWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.solicitudWebService();
            }
        });
        btnRegresarAProfile = findViewById(R.id.btnRegresarProfile);
        btnRegresarAProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });
    }

    @Override
    public void showUser(User user) {
        tvUserName.setText(user.getUsername());
        tvEdad.setText(user.getEdad());
    }
}
