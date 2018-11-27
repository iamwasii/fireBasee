package com.example.apple.mvplogin.model;

import android.text.TextUtils;

import com.example.apple.mvplogin.presenter.LoginPresenter;
import com.example.apple.mvplogin.view.LoginView;

public class PresenterImpl implements LoginPresenter{



    LoginView myLoginView;
    public PresenterImpl(LoginView loginView){
        this.myLoginView=loginView;
    }
    @Override
    public void performLogin(String userName, String password) {
        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){
            myLoginView.loginValidations();
        }
        else{
            if(userName.equals("Waseem") && password.equals("waseem")){
                myLoginView.loginSuccess();
            }
            else{
                myLoginView.loginError();
            }
        }

    }
}
