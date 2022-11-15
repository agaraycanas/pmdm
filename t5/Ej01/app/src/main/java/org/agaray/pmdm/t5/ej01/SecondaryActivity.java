package org.agaray.pmdm.t5.ej01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        String nombre = getIntent().getStringExtra("extraNombre");
        TextView tv = (TextView)findViewById(R.id.banner);
        tv.setText("HOLA "+nombre);

        //int edad = getIntent().getIntExtra("edad");
        int edad = 18;

        Toast.makeText(this, "HOLA "+nombre+" tu edad dentro de dos años es "+(edad+2), Toast.LENGTH_SHORT).show();
    }
}