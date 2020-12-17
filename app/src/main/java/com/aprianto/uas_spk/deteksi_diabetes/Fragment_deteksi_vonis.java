package com.aprianto.uas_spk.deteksi_diabetes;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aprianto.uas_spk.R;

public class Fragment_deteksi_vonis extends Fragment {


    Bundle data_hasil;


    LinearLayout bottom_sheet;
    String hasil_deteksi;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String a = "-";
        try {
             a= ((DeteksiDiabetes) getActivity()).getIntent().getStringExtra("a");
        }catch (Exception e){
             a = "tidak bisa diakses : "+e.toString();
        }


        View view = inflater.inflate(R.layout.fragment_deteksi_hasil_deteksi, container, false);
        ((DeteksiDiabetes) getActivity()).vonis_exit();



        Toast.makeText(getContext(),"hasil : "+a,Toast.LENGTH_LONG).show();

        return view;
    }

}
