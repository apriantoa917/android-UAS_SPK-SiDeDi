package com.aprianto.uas_spk.deteksi_diabetes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aprianto.uas_spk.R;

public class DeteksiDiabetes extends AppCompatActivity {

    String val_usia, val_jkel, val_keturunan, val_banyak_kencing, val_turun_bb, val_luka_sukar, val_kesemutan, val_lemas, val_kulit_gatal ;
    ImageView btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deteksi_diabetes);
        getSupportActionBar().hide();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new Fragment_deteksi_usia()).commit();
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        val_usia = "";
        val_jkel = "";
        val_keturunan="";
        val_banyak_kencing = "";
        val_turun_bb = "";
        val_luka_sukar = "";
        val_kesemutan = "";
        val_lemas = "";
        val_kulit_gatal = "";

    }

    String testDialog(){
        return "Hasil \n " +"\n " +
                "------------------ \n"+
                "Usia anda : "+val_usia+"\n " +
                "Jkel anda : "+val_jkel+"\n " +
                "Keturunan : "+val_keturunan+"\n " +
                "Banyak kencing : "+val_banyak_kencing+"\n " +
                "Turun Berat Badan : "+val_turun_bb+"\n " +
                "Luka Sukar Sembuh : "+val_luka_sukar+"\n " +
                "Kesemutan : "+val_kesemutan+"\n " +
                "Lemas : "+val_lemas+"\n " +
                "Kulit Gatal : "+val_kulit_gatal;
    }

    void setVariabelValue(String variabel, String value){
        switch (variabel){
            case "usia" :
                val_usia = value;
                break;
            case "jkel" :
                val_jkel = value;
                break;
            case "keturunan":
                val_keturunan = value;
                break;
            case "turun_bb":
                val_turun_bb = value;
                break;
            case "luka_sukar":
                val_luka_sukar = value;
                break;
            case "kesemutan":
                val_kesemutan = value;
                break;
            case "lemas":
                val_lemas = value;
                break;
            case "banyak_kencing":
                val_banyak_kencing = value;
                break;
            case "kulit_gatal":
                val_kulit_gatal = value;
                break;
        }
    }

    String getVariabelValue(String  variabel){
        String val = null;
        switch (variabel){
            case "usia":
                val =  val_usia;
                break;
            case "jkel":
                val = val_jkel;
                break;
            case "keturunan":
                val = val_keturunan;
                break;
            case "banyak_kencing":
                val = val_banyak_kencing;
                break;
            case "turun_bb":
                val = val_turun_bb;
                break;
            case "luka_sukar":
                val = val_luka_sukar;
                break;
            case "kesemutan":
                val = val_kesemutan;
                break;
            case "lemas":
                val = val_lemas;
                break;
            case "kulit_gatal":
                val = val_kulit_gatal;
                break;
        }
        return val;
    }
}
