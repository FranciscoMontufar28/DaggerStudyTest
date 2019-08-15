package com.example.daggertestapp.ui.login;

import com.example.daggertestapp.model.User;

public class LoginPresenter implements Login.Presenter {

    private Login.View view;
    private User user;

    public LoginPresenter(User user){
        this.user = user;
    }

    @Override
    public void validarUsuario(String username, String pass) {
        if (view != null){
            if (username.equals("francisco")&&pass.equals("1234")){
                user.setUsername("Francisco Montúfar");
                user.setEdad("24");
                view.usuarioValido();
            }else{
                view.error();
            }
        }
    }

    @Override
    public void setView(Login.View view) {
        this.view = view;
    }
}
