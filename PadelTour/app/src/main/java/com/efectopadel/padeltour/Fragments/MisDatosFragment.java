package com.efectopadel.padeltour.Fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.efectopadel.padeltour.Models.Users;
import com.efectopadel.padeltour.R;

public class MisDatosFragment extends Fragment {

    private EditText editNombre, editApellido, editEmail, editTelefono, editCategoria, editFechaNacimiento;
    private Button btnGuardarDatos;

    // Por ahora: usuario local (se podría persistir luego)
    private Users usuario = new Users();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mis_datos, container, false);

        editNombre = view.findViewById(R.id.editNombre);
        editApellido = view.findViewById(R.id.editApellido);
        editEmail = view.findViewById(R.id.editEmail);
        editTelefono = view.findViewById(R.id.editTelefono);
        editCategoria = view.findViewById(R.id.editCategoria);
        editFechaNacimiento = view.findViewById(R.id.editFechaNacimiento);
        btnGuardarDatos = view.findViewById(R.id.btnGuardarDatos);

        // Cargar datos si ya existen (opcional)
        cargarDatosUsuario();

        btnGuardarDatos.setOnClickListener(v -> {
            if (validarCampos()) {
                usuario.setNombre(editNombre.getText().toString());
                usuario.setApellido(editApellido.getText().toString());
                usuario.setEmail(editEmail.getText().toString());
                usuario.setTelefono(editTelefono.getText().toString());
                usuario.setCategoria(editCategoria.getText().toString());
                usuario.setFechaNacimiento(editFechaNacimiento.getText().toString());

                Toast.makeText(getContext(), "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
                // Aquí podrías guardar en base de datos, enviar a backend, etc.
            }
        });

        return view;
    }

    private void cargarDatosUsuario() {
        editNombre.setText(usuario.getNombre());
        editApellido.setText(usuario.getApellido());
        editEmail.setText(usuario.getEmail());
        editTelefono.setText(usuario.getTelefono());
        editCategoria.setText(usuario.getCategoria());
        editFechaNacimiento.setText(usuario.getFechaNacimiento());
    }

    private boolean validarCampos() {
        if (TextUtils.isEmpty(editNombre.getText())) {
            editNombre.setError("Campo requerido");
            return false;
        }
        // Podés validar más campos si querés
        return true;
    }
}
