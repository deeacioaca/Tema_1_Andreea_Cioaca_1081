package com.example.tema_dam_andreea_cioaca_1081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button btnBack;
    private EditText etEmailLogin;
    private EditText etPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmailLogin = findViewById(R.id.etEmailLogin);
        etPasswordLogin = findViewById(R.id.etPasswordLogin);
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        etEmailLogin.setText(email);
        etPasswordLogin.setText(password);

        btnBack = findViewById(R.id.back_login);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "", Toast.LENGTH_SHORT).show();
                Intent newWindow = new Intent(Login.this, Start.class);
                startActivity(newWindow);
            }
        });
    }
}