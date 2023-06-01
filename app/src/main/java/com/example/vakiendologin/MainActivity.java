package com.example.vakiendologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonOK = findViewById(R.id.buttonlogin1);

        spinner = (Spinner)findViewById(R.id. spinnerlogin1);
        String [] respuestas = {"Grado uno", "Grado 2"," Grado 3"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, respuestas);
        spinner.setAdapter(adapter);
        buttonOK.setOnClickListener(l->enviarDatos(l));

    }
    public void enviarDatos(View view) {
        Intent intent = new Intent(this, SegundoActivity.class);

        EditText editTextMensaje = findViewById(R.id.editTextTextEmailAddress);
        String mensaje = editTextMensaje.getText().toString();

        EditText editTextNumero = findViewById(R.id.editTextPasswordlogin1);
        String numeroStr = editTextNumero.getText().toString();

        Spinner spinnerGrado = findViewById(R.id.spinnerlogin1);
        String gradoSeleccionado = spinnerGrado.getSelectedItem().toString();

        // Obtener la fecha actual
        Date fecha = new Date();

        // Formatear la fecha al formato "dd/mm/yyyy"
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = dateFormat.format(fecha);

        // Verificar si los datos son válidos antes de enviarlos
        if (!mensaje.isEmpty() && !numeroStr.isEmpty()) {
            int numero = Integer.parseInt(numeroStr);

            intent.putExtra("mensa", mensaje);
            intent.putExtra("numero", numero);
            intent.putExtra("fecha", fechaFormateada);
            intent.putExtra("grado", gradoSeleccionado);
            startActivity(intent); // Iniciar SegundoActivity
        }
    }

}







