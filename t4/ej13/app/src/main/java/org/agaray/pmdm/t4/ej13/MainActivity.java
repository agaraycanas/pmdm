package org.agaray.pmdm.t4.ej13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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
        this.banner.setText("ACTUALIZADO");
    }
}