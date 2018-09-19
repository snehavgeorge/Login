package com.example.cm.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cm.login.utils.Appconstants;


public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    EditText userName1,password1;
    Button login,register1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName1 = (EditText) findViewById(R.id.userName1);
        password1 = (EditText) findViewById(R.id.password1);
        login = (Button) findViewById(R.id.login);
        register1 = (Button) findViewById(R.id.register1);
        sharedpreferences = getSharedPreferences(Appconstants.mypreference,
                Context.MODE_PRIVATE);

        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String un=   userName1.getText().toString();
                String pw=   password1.getText().toString();

                if( sharedpreferences.getString(Appconstants.UserName,"").equalsIgnoreCase(un)){
                    if(sharedpreferences.getString(Appconstants.Password,"").equalsIgnoreCase(pw)){

                        Toast.makeText(LoginActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }else


                    Toast.makeText(LoginActivity.this, "username or password is incurrect", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
