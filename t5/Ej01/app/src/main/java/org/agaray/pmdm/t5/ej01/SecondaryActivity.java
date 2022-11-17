package org.agaray.pmdm.t5.ej01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.agaray.pmdm.t5.ej01.domain.Persona;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Persona persona = (Persona)(getIntent().getSerializableExtra("persona"));

        TextView tv = (TextView)findViewById(R.id.banner);
        tv.setText("HOLA "+persona);
    }
}