package com.example.daggertestapp.ui.login;

public interface Login {

    interface View{
        void usuarioValido();
        void error();
    }

    interface Presenter{
        void validarUsuario(String user, String pass);
        void setView(Login.View view);
    }
}
