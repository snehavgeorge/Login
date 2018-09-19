package com.example.cm.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cm.login.utils.Appconstants;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = (Button)findViewById(R.id.logout);
        sharedpreferences = getSharedPreferences(Appconstants.mypreference,
                Context.MODE_PRIVATE);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedpreferences.edit().clear().commit();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }

}
