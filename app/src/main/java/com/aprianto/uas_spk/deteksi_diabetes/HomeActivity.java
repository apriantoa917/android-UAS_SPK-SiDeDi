package com.aprianto.uas_spk.deteksi_diabetes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aprianto.uas_spk.R;
import com.aprianto.uas_spk.deteksi_diabetes.konten_berita.model;
import com.aprianto.uas_spk.deteksi_diabetes.konten_berita.rv_adapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    RelativeLayout btn_deteksi;
    ArrayList<com.aprianto.uas_spk.deteksi_diabetes.konten_berita.model> list = new ArrayList<>();
    DatabaseReference db;
    RecyclerView rv;
    ImageView c1,c2,c3,c4;
    ProgressBar progressBar;
    TextView label_greetings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        c1 = findViewById(R.id.card1);
        c2 = findViewById(R.id.card2);
        c3 = findViewById(R.id.card3);
        c4 = findViewById(R.id.card4);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        label_greetings = findViewById(R.id.greetings_home);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=rumah%20sakit");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_deteksi = findViewById(R.id.btn_deteksi);
        btn_deteksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DeteksiDiabetes.class);
                startActivity(intent);
            }
        });
        rv = findViewById(R.id.rv_artikel);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        load_greetings();
        load_rv(rv);
    }

    void load_webview(String url){
        Intent intent = new Intent(this, WebviewActivity.class);
        intent.putExtra("url",url);
        this.startActivity(intent);
    }


    private void load_rv(final RecyclerView rv) {
        list.clear();
        db = FirebaseDatabase.getInstance().getReference("cms");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot data : snapshot.getChildren()) {
                    String judul_berita = data.child("judul_berita").getValue().toString();
                    String url_berita = data.child("url_berita").getValue().toString();
                    String icon_berita = data.child("icon_berita").getValue().toString();
                    String foto_berita = data.child("foto_berita").getValue().toString();
//                    Log.e("APRI",judul_berita);
                    model model = new model();
                    model.setJudul_berita(judul_berita);
                    model.setUrl_berita(url_berita);
                    model.setFoto_berita(foto_berita);
                    model.setIc_berita(icon_berita);
                    list.add(model);
                }
                rv_adapter rv_adapter = new rv_adapter(list);
                rv.setAdapter(rv_adapter);
                progressBar.setVisibility(View.INVISIBLE);
                if (snapshot.exists()) {
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void load_greetings() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String status = "Selamat Datang,";
        int jam = Integer.parseInt(sdf.format(c.getTime()));
        if (jam >= 0 && jam < 11) {
            status = "Selamat Pagi, ";
        } else if (jam >= 11 && jam < 15) {
            status = "Selamat Siang, ";
        } else if (jam >= 15 && jam < 18) {
            status = "Selamat Sore, ";
        } else if (jam >= 18 && jam < 24) {
            status = "Selamat Malam, ";
        }
        label_greetings.setText(status);
    }
}
