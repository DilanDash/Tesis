package com.tesis.vrprueba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AplicacionVR.db";
    private static final int DATABASE_VERSION = 1;
    public static final String COLUMN_NAME = "Nombre";
    public static final String COLUMN_PIN = "Pin";
    public static final String TABLE_NAME = "usuarios";

    // Tabla y columnas
    private static final String COLUMN_ID = "id";

    // Consulta para crear la tabla
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_PIN + " NUMERIC)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Gestión de actualizaciones de la base de datos
        // Aquí puedes implementar la lógica para actualizar la estructura de la base de datos si es necesario
    }

    // Métodos CRUD aquí...
    public boolean validarUsuario(String nombre, int pin) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_NAME + " = ? AND " + COLUMN_PIN + " = ?";

        String[] selectionArgs = {nombre, String.valueOf(pin)};

        Cursor cursor = null;
        try {
            cursor = db.rawQuery(query, selectionArgs);
            boolean usuarioValido = cursor.moveToFirst();
            return usuarioValido;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }
}

