package com.aprianto.uas_spk.deteksi_diabetes;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aprianto.uas_spk.R;

import java.util.zip.Inflater;

public class Fragment_deteksi_jkel extends Fragment {
    LinearLayout btn_test;
    ImageView jkel_pria, jkel_wanita;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_deteksi_diabetes_jkel,container,false);

        btn_test = view.findViewById(R.id.test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment_deteksi_usia()).commit();
                ((DeteksiDiabetes)getActivity()).setText("mundur");
            }
        });
        jkel_pria = view.findViewById(R.id.jkel_pria);
        jkel_wanita = view.findViewById(R.id.jkel_wanita);
        jkel_pria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DeteksiDiabetes)getActivity()).setVar("jkel","pria");
                showDialog(getContext());
            }
        });
        jkel_wanita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DeteksiDiabetes)getActivity()).setVar("jkel","wanita");
                showDialog(getContext());
            }
        });



        return view;


    }

    void showDialog(Context context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        // set title dialog
        alertDialogBuilder.setTitle("HASIL TEST DIABETES");
        // set pesan dari dialog
        alertDialogBuilder
                .setMessage(((DeteksiDiabetes)getActivity()).testDialog())
                .setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
