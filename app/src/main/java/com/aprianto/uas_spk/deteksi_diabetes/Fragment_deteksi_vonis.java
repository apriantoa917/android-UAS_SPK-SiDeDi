package com.aprianto.uas_spk.deteksi_diabetes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aprianto.uas_spk.R;

public class Fragment_deteksi_vonis extends Fragment {

    RelativeLayout bg_hasil_deteksi;
    ImageView ic_hasil_deteksi;
    TextView tv_greetings_deteksi, tv_detail_deteksi;

    TextView
            hasil_usia,
            hasil_jkel,
            hasil_keturunan,
            hasil_banyak_kencing,
            hasil_turun_bb,
            hasil_luka_sukar,
            hasil_lemas,
            hasil_kulit_gatal,
            hasil_kesemutan;

    String vonis;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deteksi_hasil_deteksi, container, false);
        bg_hasil_deteksi = view.findViewById(R.id.background_hasil_deteksi);
        ic_hasil_deteksi = view.findViewById(R.id.icon_hasil_deteksi);
        tv_greetings_deteksi = view.findViewById(R.id.greetings_deteksi);
        tv_detail_deteksi = view.findViewById(R.id.kalimat_deteksi);

        hasil_usia = view.findViewById(R.id.hasil_usia);
        hasil_jkel = view.findViewById(R.id.hasil_jkel);
        hasil_keturunan = view.findViewById(R.id.hasil_keturunan);
        hasil_banyak_kencing = view.findViewById(R.id.hasil_banyak_kencing);
        hasil_turun_bb = view.findViewById(R.id.hasil_turun_bb);
        hasil_luka_sukar = view.findViewById(R.id.hasil_luka_sukar);
        hasil_lemas = view.findViewById(R.id.hasil_lemas);
        hasil_kulit_gatal = view.findViewById(R.id.hasil_kulit_gatal);
        hasil_kesemutan = view.findViewById(R.id.hasil_kesemutan);

        hasil_usia.setText(((DeteksiDiabetes) getActivity()).getVariabelValue("usia"));
        hasil_jkel.setText(((DeteksiDiabetes) getActivity()).getVariabelValue("jkel"));
        hasil_keturunan.setText(((DeteksiDiabetes) getActivity()).getVariabelValue("keturunan"));
        hasil_banyak_kencing.setText(((DeteksiDiabetes) getActivity()).getVariabelValue("banyak_kencing"));
        hasil_turun_bb.setText(((DeteksiDiabetes) getActivity()).getVariabelValue("turun_bb"));
        hasil_luka_sukar.setText(((DeteksiDiabetes) getActivity()).getVariabelValue("luka_sukar"));
        hasil_lemas.setText(((DeteksiDiabetes) getActivity()).getVariabelValue("lemas"));
        hasil_kulit_gatal.setText(((DeteksiDiabetes) getActivity()).getVariabelValue("kulit_gatal"));
        hasil_kesemutan.setText(((DeteksiDiabetes) getActivity()).getVariabelValue("kesemutan"));

        vonis = getArguments().getString("vonis");

        set_layout(vonis);
        return view;
    }

    void set_layout(String vonis){
        switch (vonis){
            case "ya":
                bg_hasil_deteksi.setBackgroundColor(getResources().getColor(R.color.red));
                ic_hasil_deteksi.setBackground(getResources().getDrawable(R.drawable.ic_vonis_ya));
                tv_greetings_deteksi.setText("Waspada !!!");
                tv_detail_deteksi.setText("Anda berpotensi terkena diabetes, segera lakukan tes lebih lanjut kondisi anda !");
                break;
            case "tidak":
                bg_hasil_deteksi.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                ic_hasil_deteksi.setBackground(getResources().getDrawable(R.drawable.ic_vonis_tidak));
                tv_greetings_deteksi.setText("Selamat !!!");
                tv_detail_deteksi.setText("Anda tidak terdeteksi terkena diabetes, selalu jaga kesehatan!");
                break;
            default:
                bg_hasil_deteksi.setBackgroundColor(getResources().getColor(R.color.yellow));
                ic_hasil_deteksi.setBackground(getResources().getDrawable(R.drawable.ic_eror));
                tv_greetings_deteksi.setText("Eror !!!");
                tv_detail_deteksi.setText("Hmm, anda tidak dapat berkomunikasi dengan sistem");
                break;
        }
        ((DeteksiDiabetes) getActivity()).keluar_menu_deteksi(vonis);
    }
}
