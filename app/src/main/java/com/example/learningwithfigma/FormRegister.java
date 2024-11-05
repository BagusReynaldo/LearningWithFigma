package com.example.learningwithfigma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_register);

        Button btnRegister = findViewById(R.id.btn_regis);
        ImageButton btnBack = findViewById(R.id.btn_back);

        btnRegister.setOnClickListener(v -> {
            register(v);
        });
        btnBack.setOnClickListener(v -> {
            onBackPressed();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void register(View view) {
        EditText txtUser = findViewById(R.id.txt_user);
        EditText txtPass = findViewById(R.id.txt_pass);
        EditText txtEmail = findViewById(R.id.email);

        String email, username, password, verif;
        email = txtEmail.getText().toString();
        username = txtUser.getText().toString();
        password = txtPass.getText().toString();
        verif = "Anda sudah membuat akun, silahkan Login kembali !!";

        if(email.trim().isEmpty() || username.trim().isEmpty() || password.trim().isEmpty()){
            Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Intent intent = new Intent(FormRegister.this, MainActivity.class);
            intent.putExtra("verifikasi", verif);
            startActivity(intent);
        }
    }
}