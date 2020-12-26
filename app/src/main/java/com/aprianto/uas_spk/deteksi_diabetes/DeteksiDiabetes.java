package com.aprianto.uas_spk.deteksi_diabetes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aprianto.uas_spk.R;

import org.json.JSONException;
import org.json.JSONObject;

public class DeteksiDiabetes extends AppCompatActivity {
    public static final String url = "http://192.168.1.104/uas_spk/deteksi.php";
    String val_usia, val_jkel, val_keturunan, val_banyak_kencing, val_turun_bb, val_luka_sukar, val_kesemutan, val_lemas, val_kulit_gatal ;
    ImageView btn_close;
    RelativeLayout header;
    boolean state_close = false;

    RelativeLayout background_hasil_deteksi;
    ImageView ic_hasil_deteksi;
    TextView greetings_hasil_deteksi, kalimat_hasil_deteksi;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deteksi_diabetes);
        getSupportActionBar().hide();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new Fragment_deteksi_usia()).commit();

        header = findViewById(R.id.header);
        btn_close = findViewById(R.id.btn_close);
        background_hasil_deteksi = findViewById(R.id.background_hasil_deteksi);
        ic_hasil_deteksi = findViewById(R.id.icon_hasil_deteksi);
        greetings_hasil_deteksi = findViewById(R.id.greetings_deteksi);
        kalimat_hasil_deteksi = findViewById(R.id.kalimat_deteksi);

        getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state_close){
                    finish();
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(DeteksiDiabetes.this);
                    builder.setTitle("Batalkan deteksi");
                    builder.setMessage("Apakah anda akan meninggalkan halaman deteksi ?");
                    builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    // Set the alert dialog no button click listener
                    builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.setCancelable(false);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

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
            case "hasil_deteksi":
                val = hasil_deteksi;
                break;
        }
        return val;
    }

    String outputs = "";
    String hasil_deteksi = "";

    public void deteksi() {

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        JSONObject postData = new JSONObject();
        try {
            postData.put("usia", val_usia);
            postData.put("jkel", val_jkel);
            postData.put("keturunan", val_keturunan);
            postData.put("banyak_kencing", val_banyak_kencing);
            postData.put("turun_bb", val_turun_bb);
            postData.put("luka_sukar", val_luka_sukar);
            postData.put("kesemutan", val_kesemutan);
            postData.put("lemas", val_lemas);
            postData.put("kulit_gatal", val_kulit_gatal);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Fragment_deteksi_vonis fragment_deteksi_vonis = new Fragment_deteksi_vonis();
                        Bundle bundle = new Bundle();
                        bundle.putString("vonis",response);
                        fragment_deteksi_vonis.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment_deteksi_vonis).commit();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Fragment_deteksi_vonis fragment_deteksi_vonis = new Fragment_deteksi_vonis();
                Bundle bundle = new Bundle();
                bundle.putString("vonis","eror");
                fragment_deteksi_vonis.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment_deteksi_vonis).commit();
            }
        });
        requestQueue.add(stringRequest);
    }



    void keluar_menu_deteksi(String vonis){
        btn_close.setColorFilter(getResources().getColor(R.color.white));
        switch (vonis){
            case "ya":
                header.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case "tidak":
                header.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                break;
            default:
                header.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;
        }
        state_close = true;
    }


}
