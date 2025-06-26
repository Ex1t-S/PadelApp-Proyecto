package com.efectopadel.padeltour;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    // Layouts de las distintas secciones
    private LinearLayout layoutBotones, layoutLogin, layoutRegistro;

    // Login fields
    private TextInputEditText editEmailLogin, editPasswordLogin;
    private Button btnLogin, btnVolverLogin;

    // Registro fields
    private TextInputEditText editNombreReg, editEmailReg, editPasswordReg;
    private Button btnRegistrar, btnVolverRegistro;

    // Botones principales
    private Button btnIrLogin, btnIrRegistro, btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // --- Referencias a los layouts ---
        layoutBotones = findViewById(R.id.layoutBotones);
        layoutLogin = findViewById(R.id.layoutLogin);
        layoutRegistro = findViewById(R.id.layoutRegistro);

        // --- Botones principales ---
        btnIrLogin = findViewById(R.id.btnIrLogin);
        btnIrRegistro = findViewById(R.id.btnIrRegistro);
        btnGoogle = findViewById(R.id.btnGoogle);

        // --- Login ---
        editEmailLogin = findViewById(R.id.editEmailLogin);
        editPasswordLogin = findViewById(R.id.editPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        btnVolverLogin = findViewById(R.id.btnVolverLogin);

        // --- Registro ---
        editNombreReg = findViewById(R.id.editNombreReg);
        editEmailReg = findViewById(R.id.editEmailReg);
        editPasswordReg = findViewById(R.id.editPasswordReg);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnVolverRegistro = findViewById(R.id.btnVolverRegistro);

        // --- Mostrar login ---
        btnIrLogin.setOnClickListener(v -> {
            layoutBotones.setVisibility(View.GONE);
            layoutLogin.setVisibility(View.VISIBLE);
            btnGoogle.setVisibility(View.GONE);
        });

        // --- Mostrar registro ---
        btnIrRegistro.setOnClickListener(v -> {
            layoutBotones.setVisibility(View.GONE);
            layoutRegistro.setVisibility(View.VISIBLE);
            btnGoogle.setVisibility(View.GONE);
        });

        // --- Volver desde login ---
        btnVolverLogin.setOnClickListener(v -> {
            layoutLogin.setVisibility(View.GONE);
            layoutBotones.setVisibility(View.VISIBLE);
            btnGoogle.setVisibility(View.VISIBLE);
        });

        // --- Volver desde registro ---
        btnVolverRegistro.setOnClickListener(v -> {
            layoutRegistro.setVisibility(View.GONE);
            layoutBotones.setVisibility(View.VISIBLE);
            btnGoogle.setVisibility(View.GONE);
        });

        // --- LOGIN ---
        btnLogin.setOnClickListener(v -> {
            String email = editEmailLogin.getText().toString().trim();
            String password = editPasswordLogin.getText().toString();

            if (TextUtils.isEmpty(email)) {
                editEmailLogin.setError("Ingrese su email");
                return;
            }
            if (TextUtils.isEmpty(password)) {
                editPasswordLogin.setError("Ingrese su contraseña");
                return;
            }

            // GUARDAR FLAG EN SHARED PREFERENCES
            getSharedPreferences("PadelTourPrefs", MODE_PRIVATE)
                    .edit()
                    .putBoolean("logueado", true)
                    .putString("email", email)
                    .apply();

            // Ir a MainActivity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // --- REGISTRO (simulado, personalizá esto a tu gusto) ---
        btnRegistrar.setOnClickListener(v -> {
            String nombre = editNombreReg.getText().toString().trim();
            String email = editEmailReg.getText().toString().trim();
            String password = editPasswordReg.getText().toString();

            if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }
            // Guardar usuario, etc...

            // Guardar flag de logueado
            getSharedPreferences("PadelTourPrefs", MODE_PRIVATE)
                    .edit()
                    .putBoolean("logueado", true)
                    .putString("email", email)
                    .apply();

            // Ir a MainActivity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // --- GOOGLE (no implementado aún) ---
        btnGoogle.setOnClickListener(v -> {
            Toast.makeText(this, "Google Login próximamente", Toast.LENGTH_SHORT).show();
        });
    }
}