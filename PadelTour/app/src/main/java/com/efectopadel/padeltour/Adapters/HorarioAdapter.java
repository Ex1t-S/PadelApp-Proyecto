package com.efectopadel.padeltour.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.efectopadel.padeltour.R;

import java.util.List;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.HorarioViewHolder> {
    private List<String> horarios;
    private String cancha;

    public HorarioAdapter(List<String> horarios, String cancha) {
        this.horarios = horarios;
        this.cancha = cancha;
    }

    @NonNull
    @Override
    public HorarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_horario, parent, false);
        return new HorarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorarioViewHolder holder, int position) {
        holder.tvHorario.setText(horarios.get(position));
        holder.btnReservar.setOnClickListener(v -> {
            // Por ahora, no hace nada
        });
    }

    @Override
    public int getItemCount() {
        return horarios.size();
    }

    static class HorarioViewHolder extends RecyclerView.ViewHolder {
        TextView tvHorario;
        Button btnReservar;

        HorarioViewHolder(View itemView) {
            super(itemView);
            tvHorario = itemView.findViewById(R.id.tvHorario);
            btnReservar = itemView.findViewById(R.id.btnReservar);
        }
    }
}
