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

public class FormLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_login);

        Button btnLogin = findViewById(R.id.btn_hitung);
        ImageButton btnBack = findViewById(R.id.btn_back);

        btnLogin.setOnClickListener(v -> {
            login(v);
        });
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(FormLogin.this, MainActivity.class));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void login(View view) {
        EditText txtUser = findViewById(R.id.txt_user);
        EditText txtPass = findViewById(R.id.txt_pass);

        String username, password;
        username = txtUser.getText().toString();
        password = txtPass.getText().toString();

        if(username.trim().isEmpty() || password.trim().isEmpty()){
            Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Intent intent = new Intent(FormLogin.this, Gaji.class);
            intent.putExtra("username", txtUser.getText().toString());
            startActivity(intent);
        }
    }
}