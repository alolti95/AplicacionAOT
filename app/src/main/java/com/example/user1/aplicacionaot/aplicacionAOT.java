package com.example.user1.aplicacionaot;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class aplicacionAOT extends AppCompatActivity {

    private EditText txtTlfno;
    private Button btnAceptar;
    private Button VisWebBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacion_aot);

        txtTlfno = (EditText)findViewById(R.id.txtPhone);
        btnAceptar = (Button)findViewById(R.id.btnAceptar);
        VisWebBtn = (Button)findViewById(R.id.VisWebBtn);

        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);

        String nomSharedPrefs = prefs.getString("NOMBRE", "Nombre por defecto");

        //Implementamos el evento click del botón
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(aplicacionAOT.this, Actividad2.class);

                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("TLFNO", txtTlfno.getText().toString());

                //Añadimos la información al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        VisWebBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://web.gencat.cat/"));
                startActivity(intent);
            }
        });
    }
}
