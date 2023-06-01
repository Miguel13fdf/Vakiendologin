package com.example.vakiendologin;

import static com.example.vakiendologin.R.id.spinnerlogin1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SegundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        Intent intent = getIntent();
        String mensajeR = intent.getStringExtra("mensa");
        TextView textView = findViewById(R.id.editTextTextname1);
        textView.setText(mensajeR);
        int numero = intent.getIntExtra("numero", 0);
        String fechaString = intent.getStringExtra("fecha");

// Convertir la cadena de texto de fecha al formato "dd/mm/yyyy"
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = inputFormat.parse(fechaString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TextView textView2 = findViewById(R.id.editTextTextPassword);
        textView2.setText(String.valueOf(numero));
        TextView textViewFecha = findViewById(R.id.editTextDatereceptor2);
        if (fecha != null) {
            String fechaFormateada = outputFormat.format(fecha);
            textViewFecha.setText(fechaFormateada);
        } else {
            textViewFecha.setText("");
        }

        String gradoSeleccionado = intent.getStringExtra("grado");
        TextView textViewGrado = findViewById(R.id.Receptorrdespinner);
        textViewGrado.setText(gradoSeleccionado);


    }
}