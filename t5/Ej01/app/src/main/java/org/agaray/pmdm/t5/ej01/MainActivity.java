package org.agaray.pmdm.t5.ej01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.agaray.pmdm.t5.ej01.domain.Persona;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirVentana(View view) {
        Intent i = new Intent(this, SecondaryActivity.class);
        EditText et = (EditText) findViewById(R.id.nombre);

        String nombre = !et.getText().toString().equals("") ? et.getText().toString() : "JOHN DOE";
        int edad = (int)((Math.random()*50)+1);

        Persona persona = new Persona(nombre,edad);
        i.putExtra("persona",persona);
        startActivity(i);
    }

}