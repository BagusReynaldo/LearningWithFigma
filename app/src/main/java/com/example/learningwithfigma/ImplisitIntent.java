package com.example.learningwithfigma;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImplisitIntent extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_implisit_intent);

        TextView username = findViewById(R.id.txt_nama2);

        username.setText(getIntent().getStringExtra("username"));

        Button addNumber = findViewById(R.id.add_btn);
        addNumber.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClick(View v) {
        if (v.getId() == R.id.add_btn) {
            TextView nomorHP = findViewById(R.id.txt_phoneNumber);
            String value = nomorHP.getText().toString();
            Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + value));
            startActivity(dialIntent);
        }
    }
}