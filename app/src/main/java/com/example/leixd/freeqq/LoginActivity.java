package com.example.leixd.freeqq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;
    private OkHttpClient okHttpClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.registerUser);
        okHttpClient=new OkHttpClient();
        initWidget();


    }

    private void initWidget()
    {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue=username.getText().toString();
                String passwordValue=password.getText().toString();
                RequestBody formBody = new FormBody.Builder().add("username", usernameValue).add("password",passwordValue)

                        .build();

                final Request request2 = new Request.Builder().url(ServerInfo.serverLoginIP).post(formBody).build();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Response response=okHttpClient.newCall(request2).execute();
                            if (response.header("result").equals("success"))
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue=username.getText().toString();
                String passwordValue=password.getText().toString();
                RequestBody formBody = new FormBody.Builder().add("username", usernameValue).add("password",passwordValue)

                        .build();

                final Request request2 = new Request.Builder().url(ServerInfo.serverRegisterIP).post(formBody).build();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Response response=okHttpClient.newCall(request2).execute();
                            if (response.header("result").equals("success"))
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();

            }
        });

    }

}
