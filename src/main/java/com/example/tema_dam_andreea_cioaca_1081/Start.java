package com.example.tema_dam_andreea_cioaca_1081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Start extends AppCompatActivity {

    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnLogin = findViewById(R.id.login_button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Start.this, "Log in!", Toast.LENGTH_LONG).show();
                Intent newWindow = new Intent(Start.this, Login.class);
                startActivity(newWindow);
            }
        });

        btnRegister = findViewById(R.id.register_button);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Start.this, "Register here!", Toast.LENGTH_LONG).show();
                Intent newWindow = new Intent(Start.this, Register.class);
                startActivity(newWindow);
            }
        });
    }
}


