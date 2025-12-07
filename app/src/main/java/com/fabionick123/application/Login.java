package com.fabionick123.application;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputLayout loginUsuario;
    TextInputLayout loginContra;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginUsuario = findViewById(R.id.loginTILusername);
        loginContra = findViewById(R.id.loginTILpassword);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> login());
        TextView loginTVRegister = findViewById(R.id.loginTVRegister);
        loginTVRegister.setOnClickListener(v -> {

            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        });
    }


    private void login() {
        String usuarioInput = loginUsuario.getEditText().getText().toString();
        String contraInput = loginContra.getEditText().getText().toString();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String usuarioGuardado = prefs.getString("nombre", null);
        String contraGuardada = prefs.getString("password", null);

        if (usuarioGuardado == null) {
            Toast.makeText(this, "No hay usuarios registrados. Crea una cuenta.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        if (usuarioInput.equals(usuarioGuardado) && contraInput.equals(contraGuardada)) {
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

}
