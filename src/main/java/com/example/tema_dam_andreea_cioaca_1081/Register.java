package com.example.tema_dam_andreea_cioaca_1081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private Button btnBack;
    private Button btnContinue;
    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    private Switch switchTermsOfService;
    private Switch switchPrivacyPolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnBack = findViewById(R.id.back_register);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Register.this, "", Toast.LENGTH_SHORT).show();
                Intent newWindow = new Intent(Register.this, Start.class);
                startActivity(newWindow);
            }
        });

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        switchTermsOfService = findViewById(R.id.switchTermsOfService);
        switchPrivacyPolicy = findViewById(R.id.switchPrivacyPolicy);

        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    User user = new User();
                    String email = etEmail.getText().toString();
                    String password = etPassword.getText().toString();
                    user.setName(etName.getText().toString());
                    user.setEmail(email);
                    user.setPassword(password);
                    Intent intent = new Intent(Register.this, Login.class);
                    intent.putExtra("email",email);
                    intent.putExtra("password",password);
                    setResult(RESULT_OK,intent);
                    startActivity(intent);
                }
            }
        });
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValid() {
        if (etName.getText().toString().isEmpty()) {
            Toast.makeText(Register.this, "Completati numele!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etEmail.getText().toString().isEmpty()) {
            Toast.makeText(Register.this, "Completati adresa de email!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(isEmailValid(etEmail.getText().toString()))) {
            Toast.makeText(Register.this, "Email invalid!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etPassword.getText().toString().isEmpty()) {
            Toast.makeText(Register.this, "Completati parola!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!switchTermsOfService.isChecked()) {
            Toast.makeText(Register.this, "Trebuie sa acceptati termenii si conditiile!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!switchPrivacyPolicy.isChecked()) {
            Toast.makeText(Register.this, "Trebuie sa acceptati politica de confidentialitate!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}