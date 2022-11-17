package org.agaray.pmdm.t5.ej02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirSecundaria(View v) {
        Intent i = new Intent(this,SecondaryActivity.class);
        //startActivity(i); // Si quisiéramos abrirla sin esperar resultado
        i.putExtra("mensaje",((EditText)(findViewById(R.id.mensajeOrigen))).getText().toString());
        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String mensajeContestacion = data.getStringExtra("contestacion");
        Toast.makeText(this, mensajeContestacion, Toast.LENGTH_SHORT).show();
    }
}