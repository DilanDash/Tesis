package com.tesis.vrprueba;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class RegistroActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPin;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        editTextName = findViewById(R.id.editTextName);
        editTextPin = findViewById(R.id.editTextPin);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String pin = editTextPin.getText().toString();

                // Insertar los datos en la base de datos
                DatabaseHelper databaseHelper = new DatabaseHelper(RegistroActivity.this);
                SQLiteDatabase db = databaseHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(DatabaseHelper.COLUMN_NAME, name);
                values.put(DatabaseHelper.COLUMN_PIN, pin);

                long newRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values);

                if (newRowId != -1) {
                    Toast.makeText(RegistroActivity.this, "Registro exitoso:\nNombre: " + name + "\nPIN: " + pin, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistroActivity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                }

                db.close();
            }
        });
    }
}
