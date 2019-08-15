package com.example.daggertestapp.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.daggertestapp.R;
import com.example.daggertestapp.di.BaseApp;
import com.example.daggertestapp.model.User;
import com.example.daggertestapp.ui.login.LoginActivity;
import com.example.daggertestapp.ui.webService.WebServiceActivity;

import javax.inject.Inject;

public class ProfileActivity extends AppCompatActivity implements Profile.View{

    private EditText etName;
    private EditText etEdad;
    private TextView tvLogout;
    private Button btnNextActivity;
    private Button btnUpdate;

    @Inject
    Profile.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ((BaseApp)getApplication()).getAppComponent().inject(this);
        setUpView();
        presenter.setView(this);
    }

    private void setUpView(){
        etName = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
        tvLogout = findViewById(R.id.tvLogout);
        btnNextActivity = findViewById(R.id.btnNextActivity);
        btnUpdate = findViewById(R.id.btnActualizar);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setEdad(etEdad.getText().toString());
                user.setUsername(etName.getText().toString());
                presenter.updateUser(user);
            }
        });
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.logOut();
            }
        });
        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(), WebServiceActivity.class));
            }
        });
    }

    @Override
    public void showUser(User user) {
        etEdad.setText(user.getEdad());
        etName.setText(user.getUsername());
    }

    @Override
    public void logOut() {
       Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
       startActivity(intent);
    }
}
