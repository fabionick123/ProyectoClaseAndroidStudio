package com.fabionick123.application;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    TextInputLayout registerName;
    TextInputLayout registerLastName;
    TextInputLayout registerEmail;
    TextInputLayout registerPassword;
    TextInputLayout registerPasswordConfirm;
    Button registerButton;

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

        registerName = findViewById(R.id.nombreRegister);
        registerLastName = findViewById(R.id.apellidosRegister);
        registerEmail = findViewById(R.id.emailRegister);
        registerPassword = findViewById(R.id.contrasenaRegister);
        registerPasswordConfirm = findViewById(R.id.confirmarContrasenaRegister);
        registerButton = findViewById(R.id.registerButton);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        registerButton.setOnClickListener(v -> {

            boolean comprobarNombre = emptyVerify(registerName);
            boolean comprobarApellido = emptyVerify(registerLastName);
            boolean comprobarCorreo = emptyVerify(registerEmail) && emailVerify(registerEmail);
            boolean comprobarContrasenia = passwordsVerify(registerPassword, registerPasswordConfirm);

            boolean continuar = comprobarNombre && comprobarApellido && comprobarCorreo && comprobarContrasenia;

            if (continuar) {

                editor.putString("nombre", getValue(registerName));
                editor.putString("apellido", getValue(registerLastName));
                editor.putString("correo", getValue(registerEmail));
                editor.putString("password", getValue(registerPassword));
                editor.apply();

                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }

    private String getValue(TextInputLayout til) {
        return til.getEditText().getText().toString();
    }

    public static boolean emptyVerify(TextInputLayout til) {
        String text = til.getEditText().getText().toString();
        if (text.isEmpty()) {
            til.setErrorEnabled(true);
            til.setError("Este campo no puede estar vacío.");
            return false;
        } else {
            til.setErrorEnabled(false);
            return true;
        }
    }

    public static boolean emailVerify(TextInputLayout til) {
        String email = til.getEditText().getText().toString();
        if (!email.endsWith("@gmail.com")) {
            til.setErrorEnabled(true);
            til.setError("Correo inválido (usa @gmail.com).");
            return false;
        } else {
            til.setErrorEnabled(false);
            return true;
        }
    }

    public static boolean passwordsVerify(TextInputLayout passTIL, TextInputLayout confirmTIL) {
        String pass = passTIL.getEditText().getText().toString();
        String passConfirm = confirmTIL.getEditText().getText().toString();

        if (pass.isEmpty()) {
            passTIL.setErrorEnabled(true);
            passTIL.setError("Este campo no puede estar vacío.");
            return false;
        }

        if (!pass.equals(passConfirm)) {
            confirmTIL.setErrorEnabled(true);
            confirmTIL.setError("Las contraseñas no coinciden.");
            return false;
        }

        passTIL.setErrorEnabled(false);
        confirmTIL.setErrorEnabled(false);
        return true;
    }
}
