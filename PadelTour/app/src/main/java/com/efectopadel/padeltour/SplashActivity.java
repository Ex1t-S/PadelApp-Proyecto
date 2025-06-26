package com.efectopadel.padeltour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences("PadelTourPrefs", MODE_PRIVATE);
        boolean yaLogueado = prefs.getBoolean("Logueado",false);
        setContentView(R.layout.activity_splash);
        if (yaLogueado) {
            // Ingresa al main
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }, 3000);
        }
        else{
            // Ingresa al login
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }, 3000);
        }
    }
}