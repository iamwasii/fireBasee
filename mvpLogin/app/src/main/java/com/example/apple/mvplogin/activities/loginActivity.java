package com.example.apple.mvplogin.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apple.mvplogin.R;
import com.example.apple.mvplogin.model.PresenterImpl;
import com.example.apple.mvplogin.presenter.LoginPresenter;
import com.example.apple.mvplogin.view.LoginView;

public class loginActivity extends Activity implements LoginView{


    EditText uName,pass;
    TextView LogIn;
    LoginPresenter myLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uName=findViewById(R.id.uName);
        pass=findViewById(R.id.pass);
        LogIn=findViewById(R.id.logIn);
        LogIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String userName=uName.getText().toString();
                String password=pass.getText().toString();
                myLoginPresenter.performLogin(userName,password);
            }
        });
        myLoginPresenter=new PresenterImpl(loginActivity.this);
    }




    @Override
    public void loginValidations() {
        Toast.makeText(getApplicationContext(),"Please Enter UserName and password",Toast.LENGTH_LONG).show();

    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(),"Login Error",Toast.LENGTH_LONG).show();
    }
}
