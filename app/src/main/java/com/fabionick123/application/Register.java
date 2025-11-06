package com.fabionick123.application;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextInputLayout registerName = findViewById(R.id.nombreRegister);
        TextInputLayout registerLastName = findViewById(R.id.apellidosRegister);
        TextInputLayout registerEmail = findViewById(R.id.emailRegister);
        TextInputLayout registerPassword = findViewById(R.id.contrasenaRegister);
        TextInputLayout registerPasswordConfirm = findViewById(R.id.confirmarContrasenaRegister);
        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (nameIsEmpty(registerName)){
                registerName.setErrorEnabled(true);
                registerName.setError("Nombre vacío");
                }
            if (!isemailcorect(registerEmail)){
                registerEmail.setErrorEnabled(true);
                registerEmail.setError("Email introducido incorrectamente");
                }
            }
        });

    }
    public boolean nameIsEmpty(TextInputLayout nameRegister){
        String name = String.valueOf(nameRegister.getEditText().getText());
        return name.isEmpty();
    }
    public boolean isemailcorect(TextInputLayout emailRegister){
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern p = Pattern.compile(emailPattern);
        String email = String.valueOf(emailRegister.getEditText().getText());
        Matcher m = p.matcher(email);
        return m.find();
    }
}