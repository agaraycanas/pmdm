package org.agaray.pmdm.t6.ej01a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg = findViewById(R.id.rgEstados);
        //rg.setOnCheckedChangeListener((rgr,id)->recordarEstado());
        actualizarEstado();
    }

    private void actualizarEstado() {
        try {
            SharedPreferences p = getSharedPreferences("estado", Context.MODE_PRIVATE);
            int estadoDeAnimo = p.getInt("animo",-1);
            if (estadoDeAnimo!=-1) {
                RadioButton rb = findViewById(estadoDeAnimo);
                rb.setChecked(true);
            }
        }
        catch (Exception e) {

        }
    }

    private void recordarEstado() {
        SharedPreferences p = getSharedPreferences("estado", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = p.edit();
        RadioGroup rg = findViewById(R.id.rgEstados);
        editor.putInt("animo", rg.getCheckedRadioButtonId());
        //editor.putInt("animo", id);
        editor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    recordarEstado();
    }
}