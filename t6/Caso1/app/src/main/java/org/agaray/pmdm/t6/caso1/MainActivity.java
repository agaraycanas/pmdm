package org.agaray.pmdm.t6.caso1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private String mensaje;

    @Override
    protected void onCreate(Bundle in) {
        super.onCreate(in);
        setContentView(R.layout.activity_main);
        if (in == null) {
            try {
                SharedPreferences p = getSharedPreferences("estado", Context.MODE_PRIVATE);
                this.mensaje = p.getString("mensajeAlmacenado","INI-alternativo");
            }
            catch (Exception e) {
                this.mensaje = "INI";

            }
        }
        else {
            this.mensaje = in.getString("mensajeFuturo");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle out) {
        super.onSaveInstanceState(out);
        out.putString( "mensajeFuturo", this.mensaje);
    }

    public void memorizar(View v) {
        EditText texto =  findViewById(R.id.texto);
        this.mensaje = texto.getText().toString();
        guardarPersistente(this.mensaje);
    }

    private void guardarPersistente(String mensaje) {
        SharedPreferences p = getSharedPreferences("estado", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = p.edit();
        editor.putString("mensajeAlmacenado",this.mensaje);
        editor.commit();
    }

    public void cargar(View v) {
        InputStream is = getResources().openRawResource(R.raw.miscosas);
        Scanner sc = new Scanner(is);
        sc

    }

    public void mostrar(View v) {
        Toast.makeText(this, this.mensaje, Toast.LENGTH_SHORT).show();
    }

}