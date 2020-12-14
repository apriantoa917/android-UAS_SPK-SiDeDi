package com.aprianto.uas_spk.deteksi_diabetes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aprianto.uas_spk.R;

public class DeteksiDiabetes extends AppCompatActivity {

    String val_usia, val_jkel;
    ImageView btn_back;
    TextView test;
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
        test = findViewById(R.id.texttest);
        val_usia = "20-40"; val_jkel = "pria";

    }

    public void setText(String text){
        test.setText(text);
    }

    String testDialog(){
        return "Hasil \n Usia anda : "+val_usia+"\n Jkel anda : "+val_jkel;
    }

    void setVar(String variabel,String value){
        switch (variabel){
            case "usia" :
                val_usia = value;
                break;
            case "jkel" :
                val_jkel = value;
                break;
        }
    }
}
