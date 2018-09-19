package com.example.cm.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cm.login.utils.Appconstants;

public class RegistrationActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText name,email,userName,password;


    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        userName = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);
        pd = new ProgressDialog(RegistrationActivity.this);
        pd.setMessage("loading");
        sharedpreferences = getSharedPreferences(Appconstants.mypreference,
                Context.MODE_PRIVATE);
    }
    public void Save(View view) {
        pd.show();

        String n = name.getText().toString();
        String e = email.getText().toString();
        String u = userName.getText().toString();
        String p = password.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Appconstants.Name, n);
        editor.putString(Appconstants.emailid, e);
        editor.putString(Appconstants.UserName, u);
        editor.putString(Appconstants.Password, p);
        editor.putBoolean(Appconstants.Logged, true);
        editor.commit();

        pd.dismiss();
        Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
