package org.agaray.pmdm.t5.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int num1;
    private int num2;
    private String operacion;
    private boolean estadoIntroduciendoNumero1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    private void inicializar() {
        this.num1=0;
        this.num2=0;
        this.estadoIntroduciendoNumero1=true;
        borrarPantalla();
    }

    private void borrarPantalla() {
        TextView pantalla = (TextView) findViewById(R.id.tvPantalla);
        pantalla.setText("0");
    }

    public void numero(View v){
        Button boton = (Button)v;
        String numeroString = boton.getText().toString();
        int numeroInt = Integer.parseInt(numeroString);
        actualizarPantalla(numeroString);
        actualizarNumero(numeroInt);
    }

    private void actualizarNumero(int numeroInt) {
        if (estadoIntroduciendoNumero1) {
            this.num1 = this.num1*10 + numeroInt;
        }
        else {
            this.num2 = this.num2*10 + numeroInt;
        }
    }

    private void actualizarPantalla(String numeroString) {
        TextView pantalla = (TextView) findViewById(R.id.tvPantalla);
        String textoAntiguo = pantalla.getText().toString();
        String textoNuevo = this.estadoIntroduciendoNumero1 && this.num1==0 ? numeroString : textoAntiguo + numeroString;
        pantalla.setText(textoNuevo);
    }

    public void operar(View v){
        Button operacionBoton = (Button) v;
        String operacionString = operacionBoton.getText().toString();
        this.estadoIntroduciendoNumero1 = false;
        this.operacion = operacionString;
        actualizarPantalla(operacionString);
    }
    public void solucion(View v){
        int solucion = operar();
        cambiarPantalla(Integer.toString(solucion));
        this.num1 = solucion;
        this.num2=0;
        this.estadoIntroduciendoNumero1=true;
    }

    private void cambiarPantalla(String pantallaFinal) {
        TextView pantalla = (TextView) findViewById(R.id.tvPantalla);
        pantalla.setText(pantallaFinal);
    }

    private int operar() {
        int solucion = 0;
        switch ( this.operacion ) {
            case "+":solucion = this.num1 + this.num2;break;
            case "-":solucion = this.num1 - this.num2;break;
            case "X":solucion = this.num1 * this.num2;break;
            case "/":solucion = this.num1 / this.num2;break;
        }
        return solucion;
    }

    public void borrar(View v){
        inicializar();
    }

}