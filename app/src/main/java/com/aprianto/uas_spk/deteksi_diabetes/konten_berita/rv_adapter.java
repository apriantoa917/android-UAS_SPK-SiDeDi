package com.aprianto.uas_spk.deteksi_diabetes.konten_berita;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.aprianto.uas_spk.R;
import com.aprianto.uas_spk.deteksi_diabetes.WebviewActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class rv_adapter extends RecyclerView.Adapter<rv_adapter.Holder> {

    private ArrayList<com.aprianto.uas_spk.deteksi_diabetes.konten_berita.model> list;

    Context context;
    View view;

    public rv_adapter(ArrayList<model> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_rv_berita, parent, false);
        context = parent.getContext();
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        final model model = list.get(position);
        holder.judul_berita.setText(model.getJudul_berita());
        Picasso.get().load(model.getFoto_berita()).into(holder.foto_berita);
        Picasso.get().load(model.getIc_berita()).into(holder.icon_berita);
        holder.buka_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebviewActivity.class);
                intent.putExtra("url",model.url_berita);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView judul_berita;
        RelativeLayout buka_berita;
        ImageView icon_berita, foto_berita;



        public Holder(@NonNull View itemView) {
            super(itemView);
            judul_berita = itemView.findViewById(R.id.judul_berita);
            buka_berita = itemView.findViewById(R.id.buka_berita);
            icon_berita = itemView.findViewById(R.id.ic_berita);
            foto_berita = itemView.findViewById(R.id.foto_berita);
        }


    }
}
