package com.efectopadel.padeltour.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.efectopadel.padeltour.Adapters.CanchaAdapter;
import com.efectopadel.padeltour.R;

import java.util.Arrays;

public class TurnosFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_turnos, container, false);

        RecyclerView recyclerCanchas = view.findViewById(R.id.recyclerCanchas);
        recyclerCanchas.setLayoutManager(new LinearLayoutManager(getContext()));

        // Solo 3 canchas
        CanchaAdapter adapter = new CanchaAdapter(
                Arrays.asList("Cancha 1", "Cancha 2", "Cancha 3")
        );
        recyclerCanchas.setAdapter(adapter);

        return view;
    }
}