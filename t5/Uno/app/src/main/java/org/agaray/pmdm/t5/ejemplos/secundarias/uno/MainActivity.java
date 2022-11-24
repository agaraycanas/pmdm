package org.agaray.pmdm.t5.ejemplos.secundarias.uno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void lanzarDosInterna(View v) {
        Intent i = new Intent(this,DosInterna.class);
        startActivity(i);
    }

    public void lanzarDosExterna(View v) {
        Intent i = new Intent();
        i.setClassName(
                "org.agaray.pmdm.t5.ejemplos.secundarias.dosexterna",
                "org.agaray.pmdm.t5.ejemplos.secundarias.dosexterna.MainActivity");
        startActivity(i);
    }
}