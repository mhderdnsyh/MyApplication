package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etPanjang, etLebar, etTinggi;
    private Button btnhitung;
    private TextView tvHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volumebalok);

        etPanjang = findViewById(R.id.etPanjang);
        etLebar = findViewById(R.id.etLebar);
        etTinggi = findViewById(R.id.etTinggi);
        btnhitung = findViewById(R.id.btnHitung);
        tvHasil = findViewById(R.id.tvHasil);

        btnhitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnHitung) {
            //calculate
            String panjang = etPanjang.getText().toString().trim();
            String lebar = etLebar.getText().toString().trim();
            String tinggi = etTinggi.getText().toString().trim();

            //check isian
            boolean isiankosong = false;

            if (TextUtils.isEmpty(panjang)) {
                isiankosong = true;
                etPanjang.setError("Isian panjang tidak boleh kosong");
            }

            if (TextUtils.isEmpty(lebar)) {
                isiankosong = true;
                etLebar.setError("Isian lebar tidak boleh kosong");
            }

            if (TextUtils.isEmpty(tinggi)) {
                isiankosong = true;
                etTinggi.setError("Isian tinggi tidak boleh kosong");
            }


            if (!isiankosong) {
                double volume = Double.valueOf(panjang) * Double.valueOf(lebar) * Double.valueOf(tinggi);
                tvHasil.setText(String.valueOf(volume));
            }

        }
    }
}