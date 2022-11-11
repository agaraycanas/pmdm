package org.agaray.pmdm.t4.ej13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup menu;
    private RadioButton rbLight;
    private RadioButton rbNormal;
    private RadioButton rbGraso;
    private CheckBox ckBrocoli;
    private CheckBox ckJamonYork;
    private CheckBox ckHamburguesa;
    private CheckBox ckTorreznos;

    private TextView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asociarControles();
        configurarListeners();
    }

    private void asociarControles() {
        this.menu = findViewById(R.id.radioGroup);

        this.rbLight = findViewById(R.id.rbLight);
        this.rbNormal = findViewById(R.id.rbNormal);
        this.rbGraso = findViewById(R.id.rbGraso);

        this.ckBrocoli = findViewById(R.id.ckBrocoli);
        this.ckJamonYork = findViewById(R.id.ckJamonYork);
        this.ckHamburguesa = findViewById(R.id.ckHamburguesa);
        this.ckTorreznos = findViewById(R.id.ckTorreznos);

        this.banner = findViewById(R.id.banner);
    }

    private void configurarListeners() {
        this.menu.setOnCheckedChangeListener( (rg,id)->actualizar() );

        this.ckBrocoli.setOnCheckedChangeListener( (cb,b) -> actualizar() );
        this.ckJamonYork.setOnCheckedChangeListener( (cb,b) -> actualizar() );
        this.ckHamburguesa.setOnCheckedChangeListener( (cb,b) -> actualizar() );
        this.ckTorreznos.setOnCheckedChangeListener( (cb,b) -> actualizar() );
    }

    private void actualizar() {
        int calorias = 0;
        calorias += ckBrocoli.isChecked() ? 100 : 0 ;
        calorias += ckJamonYork.isChecked() ? 500 : 0 ;
        calorias += ckHamburguesa.isChecked() ? 1500 : 0 ;
        calorias += ckTorreznos.isChecked() ? 2000 : 0 ;

        int min=0;
        int max=0;

        switch (menu.getCheckedRadioButtonId()) {
            case R.id.rbLight:min=0;max=1000;break;
            case R.id.rbNormal:min=1000;max=2000;break;
            case R.id.rbGraso:min=2000;max=1000000;break;
        }

        String mensaje =  (calorias >= min && calorias < max ) ? "OK: " : "FATAL: ";
        mensaje += " te estás enchufando %1$d calorías";
        mensaje = String.format(mensaje,calorias);

        this.banner.setText(mensaje);
        tostada(mensaje);

    }

    private void tostada(String mensaje) {
        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_SHORT; // Toast.LENGTH_LONG
        Toast toast = Toast.makeText(	contexto,
                mensaje,
                duracion);
        toast.show();

        //Toast.makeText(	getApplicationContext(), mensaje,Toast.LENGTH_SHORT).show();

    }
}