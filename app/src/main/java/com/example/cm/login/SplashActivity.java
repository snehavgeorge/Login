package com.example.cm.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cm.login.utils.Appconstants;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedpreferences = getSharedPreferences(Appconstants.mypreference,
                Context.MODE_PRIVATE);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedpreferences.getAll().size() > 0 && !sharedpreferences.getString(Appconstants.UserName, "").isEmpty()) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                } else
                {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        },3000);




    }
}
