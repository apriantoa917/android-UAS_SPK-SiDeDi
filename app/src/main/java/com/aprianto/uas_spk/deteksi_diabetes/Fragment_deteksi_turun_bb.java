package com.aprianto.uas_spk.deteksi_diabetes;

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

public class Fragment_deteksi_turun_bb extends Fragment {
    ImageButton btn_prev_question;
    ImageView turun_bb_yes, turun_bb_no, ic_yes, ic_no, icon;
    TextView tv_yes, tv_no, tv_question;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_deteksi_diabetes_yesno, container, false);

        tv_question = view.findViewById(R.id.pertanyaan);
        tv_question.setText("Apa anda merasa turun berat badan ekstrem ?");

        btn_prev_question = view.findViewById(R.id.btn_prev);
        btn_prev_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_deteksi_banyak_kencing()).commit();
            }
        });

        icon = view.findViewById(R.id.icon);
        icon.setBackground(getResources().getDrawable(R.drawable.ic_turun_bb));

        turun_bb_yes = view.findViewById(R.id.attribute_yes);
        turun_bb_no = view.findViewById(R.id.attribute_no);

        ic_yes = view.findViewById(R.id.icon_yes);
        ic_no = view.findViewById(R.id.icon_no);

        tv_yes = view.findViewById(R.id.label_yes);
        tv_no = view.findViewById(R.id.label_no);

        turun_bb_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next_question("turun_bb", "ya");
            }
        });
        turun_bb_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next_question("turun_bb", "tidak");
            }
        });
        setStateButton();
        return view;
    }
    
    void next_question(String var, String val) {
        ((DeteksiDiabetes) getActivity()).setVariabelValue(var, val);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_deteksi_luka_sukar()).commit();
    }


    void setStateButton() {
        String val = ((DeteksiDiabetes) getActivity()).getVariabelValue("turun_bb");
        if (val.isEmpty()) {
            // button belum dipilih
            setClickedButton(turun_bb_yes, ic_yes, tv_yes, "yes", "unclicked");
            setClickedButton(turun_bb_no, ic_no, tv_no, "no", "unclicked");
        } else if (val.equalsIgnoreCase("ya")) {
            setClickedButton(turun_bb_yes, ic_yes, tv_yes, "yes", "clicked");
        } else if (val.equalsIgnoreCase("tidak")) {
            setClickedButton(turun_bb_no, ic_no, tv_no, "no", "clicked");
        }
    }

    void setClickedButton(ImageView button, ImageView icon, TextView tv, String value, String state) {
        if (state.equalsIgnoreCase("clicked")) {
            button.setBackground(getResources().getDrawable(R.drawable.custom_button_clicked));
            tv.setTextColor(getResources().getColor(R.color.white));
            if (value.equalsIgnoreCase("yes")) {
                icon.setBackground(getResources().getDrawable(R.drawable.ic_yes_clicked));
            } else {
                icon.setBackground(getResources().getDrawable(R.drawable.ic_no_clicked));
            }
        } else if (state.equalsIgnoreCase("unclicked")) {
            button.setBackground(getResources().getDrawable(R.drawable.custom_button));
            tv.setTextColor(getResources().getColor(R.color.colorAccent));
            if (value.equalsIgnoreCase("yes")) {
                icon.setBackground(getResources().getDrawable(R.drawable.ic_yes));
            } else {
                icon.setBackground(getResources().getDrawable(R.drawable.ic_no));
            }
        }
    }
}
