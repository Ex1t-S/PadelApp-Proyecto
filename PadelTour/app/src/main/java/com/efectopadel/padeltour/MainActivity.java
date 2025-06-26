package com.efectopadel.padeltour;

import android.os.Bundle;
import android.widget.Button;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.efectopadel.padeltour.Fragments.MisDatosFragment;
import com.efectopadel.padeltour.Fragments.TurnosFragment;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerCanchas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Al iniciar la app, mostrar TurnosFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new TurnosFragment())
                .commit();

        // Listeners para los botones
        Button btnTurnos = findViewById(R.id.btnReservas);
        btnTurnos.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new TurnosFragment())
                    .commit();
        });

        Button btnMisDatos = findViewById(R.id.btnMisDatos);
        btnMisDatos.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new MisDatosFragment())
                    .commit();
        });
        // ...y así para los otros botones
    }
}