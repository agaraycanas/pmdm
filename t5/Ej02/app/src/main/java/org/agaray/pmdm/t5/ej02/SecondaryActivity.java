package org.agaray.pmdm.t5.ej02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        mostrarMensaje();
    }

    private void mostrarMensaje() {
        String mensaje = getIntent().getStringExtra("mensaje");
        Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show();
    }

    public void contestar(View v) {
        String mensajeDeContestacion = ((EditText)(findViewById(R.id.mensajeContestacion))).getText().toString();
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("contestacion",mensajeDeContestacion);
        setResult(RESULT_OK,i);
        finish();
    }
}