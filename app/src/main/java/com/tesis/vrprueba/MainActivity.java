package com.tesis.vrprueba;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnMostrarVentana;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMostrarVentana = findViewById(R.id.btnMostrarVentana);

        btnMostrarVentana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarVentanaEmergente();
            }
        });
    }

    private void mostrarVentanaEmergente() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AVISO DE PRIVACIDAD");
        builder.setMessage("En nuestra aplicación móvil de realidad virtual, dedicada al entrenamiento en el uso de extintores, la privacidad de nuestros usuarios es una prioridad. Este aviso de privacidad tiene como objetivo informarle sobre cómo recopilamos, utilizamos, almacenamos y protegemos la información personal que usted proporciona al utilizar nuestra aplicación.\n" +
                "\n" +
                "Recopilación de información:\n" +
                "Cuando utiliza nuestra aplicación móvil de realidad virtual para entrenamiento en el uso de extintores, podemos recopilar cierta información personal, como su nombre, dirección de correo electrónico y datos de contacto. Esta información se recopila con el fin de proporcionarle una experiencia personalizada y realizar un seguimiento de su progreso en el entrenamiento.\n" +
                "\n" +
                "Uso de la información:\n" +
                "La información personal que recopilamos se utiliza para los siguientes fines:\n" +
                "\n" +
                "1. Personalización: Utilizamos su información para personalizar su experiencia de entrenamiento en la aplicación y brindarle contenido relevante.\n" +
                "\n" +
                "2. Comunicación: Podemos utilizar su dirección de correo electrónico u otros datos de contacto para enviarle actualizaciones sobre la aplicación, recordatorios de entrenamiento y otras comunicaciones relacionadas con su uso de la misma.\n" +
                "\n" +
                "3. Mejora de la aplicación: La información que recopilamos nos ayuda a comprender cómo se utiliza la aplicación y nos permite realizar mejoras para ofrecer una experiencia más efectiva y satisfactoria.\n" +
                "\n" +
                "Protección de la información:\n" +
                "Nos comprometemos a proteger la seguridad de su información personal. Implementamos medidas de seguridad técnicas y organizativas adecuadas para proteger sus datos contra accesos no autorizados, divulgación o destrucción.\n" +
                "\n" +
                "Compartir información:\n" +
                "No compartimos su información personal con terceros sin su consentimiento, excepto en los siguientes casos:\n" +
                "\n" +
                "1. Proveedores de servicios: Podemos utilizar proveedores de servicios externos para facilitar el funcionamiento de nuestra aplicación y mejorar su rendimiento. Estos proveedores de servicios tienen acceso a su información personal solo en la medida necesaria para realizar sus funciones y están obligados a mantener la confidencialidad de dicha información.\n" +
                "\n" +
                "2. Cumplimiento legal: Podemos divulgar su información personal si así lo exige la ley o si consideramos de buena fe que dicha acción es necesaria para cumplir con un proceso legal en curso, proteger nuestros derechos legales o responder a una solicitud legal de las autoridades competentes.\n" +
                "\n" +
                "Sus derechos:\n" +
                "Usted tiene ciertos derechos en relación con su información personal, incluido el derecho a acceder, corregir, eliminar o limitar el uso de sus datos personales. Puede ejercer estos derechos poniéndose en contacto con nosotros a través de los canales de soporte proporcionados en la aplicación.\n" +
                "\n" +
                "Cambios en la política de privacidad:\n" +
                "Nos reservamos el derecho de actualizar o modificar este aviso de privacidad en cualquier momento. Cualquier cambio importante se le notificará a través de la aplicación o por otros medios de comunicación.\n" +
                "\n" +
                "Al utilizar nuestra aplicación móvil de realidad virtual para el entrenamiento en el uso de extintores, usted acepta las prácticas de privacidad descritas en este aviso. Le recomendamos que revise este aviso de privacidad periódicamente para mantenerse informado sobre cómo protegemos su información personal.");


        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Iniciar la nueva actividad
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Denegar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Salir de la aplicación al hacer clic en el botón "Denegar"
                finish();
            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();
    }
}





