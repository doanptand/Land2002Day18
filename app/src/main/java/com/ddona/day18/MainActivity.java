package com.ddona.day18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPreferences = getSharedPreferences("mypref", MODE_PRIVATE);
        boolean isLogin = mPreferences.getBoolean("is_login", false);
        if(isLogin) {
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        }

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLogin();
            }
        });
    }

    private void saveLogin() {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean("is_login", true);
        editor.commit();
    }
}