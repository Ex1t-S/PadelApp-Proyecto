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

import com.efectopadel.padeltour.Adapters.HorarioAdapter;
import com.efectopadel.padeltour.Utils.HorarioUtils;
import com.efectopadel.padeltour.R;

import java.util.List;

public class HorariosFragment extends Fragment {
    private static final String ARG_CANCHA = "cancha";

    public static HorariosFragment newInstance(String nombreCancha) {
        HorariosFragment fragment = new HorariosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CANCHA, nombreCancha);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_horarios, container, false);

        RecyclerView recyclerHorarios = view.findViewById(R.id.recyclerHorarios);
        recyclerHorarios.setLayoutManager(new LinearLayoutManager(getContext()));

        // Generar horarios cada 1:30 hs desde 8:00 a 00:00
        List<String> horarios = HorarioUtils.generarHorarios();

        HorarioAdapter adapter = new HorarioAdapter(horarios, getArguments().getString(ARG_CANCHA));
        recyclerHorarios.setAdapter(adapter);

        return view;
    }
}