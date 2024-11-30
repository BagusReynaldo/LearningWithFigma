package com.example.learningwithfigma;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Gaji extends AppCompatActivity {

    private EditText editNama;
    private CheckBox checkMenikah;
    private RadioButton radioGol1, radioGol2;
    private TextView txtGajiPokok, txtGajiTunjangan, txtPajak, txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gaji);

        editNama = findViewById(R.id.txt_nama);
        checkMenikah = findViewById(R.id.checkMenikah);
        radioGol1 = findViewById(R.id.radioGol1);
        radioGol2 = findViewById(R.id.radioGol2);
        txtGajiPokok = findViewById(R.id.txt_gajiPokok);
        txtGajiTunjangan = findViewById(R.id.txt_gajiTunjangan);
        txtPajak = findViewById(R.id.txt_pajak);
        txtTotal = findViewById(R.id.txt_total);
        Button btnHitung = findViewById(R.id.btn_hitung);

        TextView username = findViewById(R.id.txt_nama);
        username.setText(getIntent().getStringExtra("username"));

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungGaji();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void hitungGaji() {
        // Mendefinisikan gaji pokok berdasarkan golongan
        double gajiPokok;
        if (radioGol1.isChecked()) {
            gajiPokok = 5000000;
        } else if (radioGol2.isChecked()) {
            gajiPokok = 7000000;
        } else {
            gajiPokok = 0; // Jika tidak ada golongan yang dipilih
        }

        // Menghitung tunjangan jika menikah
        double tunjangan = checkMenikah.isChecked() ? gajiPokok * 0.1 : 0;

        // Menghitung pajak (5% dari gaji pokok + tunjangan)
        double pajak = (gajiPokok + tunjangan) * 0.05;

        // Menghitung total gaji
        double totalGaji = gajiPokok + tunjangan - pajak;

        // Menampilkan hasil perhitungan
        txtGajiPokok.setText(String.format("Rp %,d", (int) gajiPokok));
        txtGajiTunjangan.setText(String.format("Rp %,d", (int) tunjangan));
        txtPajak.setText(String.format("Rp %,d", (int) pajak));
        txtTotal.setText(String.format("Rp %,d", (int) totalGaji));
    }

}