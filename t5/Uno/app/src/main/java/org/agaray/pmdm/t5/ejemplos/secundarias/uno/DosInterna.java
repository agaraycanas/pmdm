package org.agaray.pmdm.t5.ejemplos.secundarias.uno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class DosInterna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos_interna);
    }

    public void cerrar(View v) {
        finish();
    }
}