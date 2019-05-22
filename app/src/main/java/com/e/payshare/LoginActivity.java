package com.e.payshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity{

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView linkRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        linkRegister = findViewById(R.id.linkRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login()){
                    Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    public boolean login(){
        if( etUsername.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin"))
            return true;
        else
            return false;
    }

}
