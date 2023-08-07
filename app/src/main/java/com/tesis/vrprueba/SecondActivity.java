package com.tesis.vrprueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText etNombreUsuario;
    private EditText etPin;
    private Button btnIniciarSesion;
    private Button btnRegistro;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        databaseHelper = new DatabaseHelper(this);

        etNombreUsuario = findViewById(R.id.etNombreUsuario);
        etPin = findViewById(R.id.etPin);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnRegistro = findViewById(R.id.btnregistro);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = etNombreUsuario.getText().toString().trim();
                String pinStr = etPin.getText().toString().trim();

                if (!nombreUsuario.isEmpty() && !pinStr.isEmpty()) {
                    int pin = Integer.parseInt(pinStr);
                    boolean usuarioValido = databaseHelper.validarUsuario(nombreUsuario, pin);

                    if (usuarioValido) {
                        // Iniciar la actividad BienvenidoActivity
                        Intent intent = new Intent(SecondActivity.this, BienvenidoActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SecondActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SecondActivity.this, "Por favor, ingresa el nombre de usuario y el PIN", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}


