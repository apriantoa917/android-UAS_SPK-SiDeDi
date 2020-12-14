package com.aprianto.uas_spk.deteksi_diabetes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aprianto.uas_spk.R;

public class Fragment_deteksi_usia extends Fragment {
    Button btn_20_40, btn_40_50, btn_50_60;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_deteksi_diabetes_usia,container,false);

        btn_20_40 = view.findViewById(R.id.usia_20_40);
        btn_40_50 = view.findViewById(R.id.usia_40_50);
        btn_50_60 = view.findViewById(R.id.usia_50_60);

        btn_20_40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
                ((DeteksiDiabetes)getActivity()).setVar("usia","20-40");
            }
        });
        btn_40_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
                ((DeteksiDiabetes)getActivity()).setVar("usia","40-50");
            }
        });
        btn_50_60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
                ((DeteksiDiabetes)getActivity()).setVar("usia","50-60");
            }
        });

        return view;

    }

    void next(){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment_deteksi_jkel()).commit();
        ((DeteksiDiabetes)getActivity()).setText("maju");
    }
}
