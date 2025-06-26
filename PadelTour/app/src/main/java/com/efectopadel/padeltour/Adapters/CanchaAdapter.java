package com.efectopadel.padeltour.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import com.efectopadel.padeltour.Fragments.HorariosFragment;
import com.efectopadel.padeltour.R;

public class CanchaAdapter extends RecyclerView.Adapter<CanchaAdapter.CanchaViewHolder> {

    private List<String> canchaList;

    public CanchaAdapter(List<String> canchaList) {
        this.canchaList = canchaList;
    }

    @NonNull
    @Override
    public CanchaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cancha, parent, false);
        return new CanchaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CanchaViewHolder holder, int position) {
        holder.nombreCancha.setText(canchaList.get(position));
        // Imagen por defecto, podés cambiarla según la cancha
        holder.imgCancha.setImageResource(R.drawable.ic_launcher_foreground);
        // Opcional: click en el cuadrante
        holder.itemView.setOnClickListener(v -> {
            Fragment horariosFragment = HorariosFragment.newInstance(canchaList.get(position));
            ((AppCompatActivity)v.getContext()).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, horariosFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return canchaList.size();
    }

    static class CanchaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCancha;
        TextView nombreCancha;
        public CanchaViewHolder(View itemView) {
            super(itemView);
            imgCancha = itemView.findViewById(R.id.imgCancha);
            nombreCancha = itemView.findViewById(R.id.tvNombreCancha);
        }
    }
}