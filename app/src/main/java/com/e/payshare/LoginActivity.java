package com.e.payshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

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

        btnLogin.setOnClickListener(this);
        linkRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Authentication auth = new Authentication();
        auth.setUsername(etUsername.getText().toString());
        auth.setPassword(etPassword.getText().toString());
        if(v.getId() == R.id.btnLogin) {
            if(auth.Login()){
            }
        }

        else if(v.getId() ==R.id.linkRegister){
            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        }
    }


}
