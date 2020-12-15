package com.aprianto.uas_spk.deteksi_diabetes;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aprianto.uas_spk.R;

public class Fragment_deteksi_jkel extends Fragment {
    ImageButton btn_prev_question;
    ImageView jkel_pria, jkel_wanita, ic_jkel_pria, ic_jkel_wanita;
    TextView tv_jkel_pria, tv_jkel_wanita;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_deteksi_diabetes_jkel,container,false);

        btn_prev_question = view.findViewById(R.id.btn_prev);
        btn_prev_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment_deteksi_usia()).commit();
            }
        });
        jkel_pria = view.findViewById(R.id.jkel_pria);
        ic_jkel_pria = view.findViewById(R.id.icon_jkel_pria);
        tv_jkel_pria = view.findViewById(R.id.tv_jkel_pria);

        jkel_wanita = view.findViewById(R.id.jkel_wanita);
        ic_jkel_wanita = view.findViewById(R.id.icon_jkel_wanita);
        tv_jkel_wanita = view.findViewById(R.id.tv_jkel_wanita);

        jkel_pria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next_question("jkel","pria");
            }
        });
        jkel_wanita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next_question("jkel","wanita");
            }
        });

        setStateButton();



        return view;


    }

    void next_question(String var, String val){
        ((DeteksiDiabetes)getActivity()).setVariabelValue(var,val);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment_deteksi_keturunan()).commit();
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

    void setStateButton(){
        String val = ((DeteksiDiabetes)getActivity()).getVariabelValue("jkel");
        if(val.isEmpty()){
//            button belum dipilih
            setClickedButton(jkel_pria, ic_jkel_pria,tv_jkel_pria,"pria", "unclicked");
            setClickedButton(jkel_wanita,ic_jkel_wanita,tv_jkel_wanita,"wanita","unclicked");
        }else if(val.equalsIgnoreCase("pria")){
            setClickedButton(jkel_pria,ic_jkel_pria,tv_jkel_pria,"pria","clicked");
        }
        else if(val.equalsIgnoreCase("wanita")){
            setClickedButton(jkel_wanita,ic_jkel_wanita,tv_jkel_wanita,"wanita","clicked");
        }
    }

    void setClickedButton(ImageView button, ImageView icon, TextView tv, String jkel, String state){
        if(state.equalsIgnoreCase("clicked")){
            button.setBackground(getResources().getDrawable(R.drawable.custom_button_clicked));
            tv.setTextColor(getResources().getColor(R.color.white));
            if(jkel.equalsIgnoreCase("pria")){
                icon.setBackground(getResources().getDrawable(R.drawable.ic_jkel_pria_clicked));
            }else{
                icon.setBackground(getResources().getDrawable(R.drawable.ic_jkel_wanita_clicked));
            }
        }else if(state.equalsIgnoreCase("unclicked")){
            button.setBackground(getResources().getDrawable(R.drawable.custom_button));
            tv.setTextColor(getResources().getColor(R.color.colorAccent));
            if(jkel.equalsIgnoreCase("pria")){
                icon.setBackground(getResources().getDrawable(R.drawable.ic_jkel_pria));
            }else{
                icon.setBackground(getResources().getDrawable(R.drawable.ic_jkel_wanita));
            }
        }

    }
}
