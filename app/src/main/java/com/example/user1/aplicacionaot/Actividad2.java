package com.example.user1.aplicacionaot;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Actividad2 extends AppCompatActivity {

    private TextView txtTlfno;
    private String tlfno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        //Localizar los controles
        txtTlfno = (TextView)findViewById(R.id.txtTlfno);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        tlfno = bundle.getString("TLFNO");
        txtTlfno.setText("Telefono introducido: " + tlfno);

        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("tlfno", tlfno);
        editor.commit();
    }
}
