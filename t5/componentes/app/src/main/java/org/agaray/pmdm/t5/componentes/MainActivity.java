package org.agaray.pmdm.t5.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configurarDinamicamenteRecepcionDeMensajesDelSistema();
    }

    private void configurarDinamicamenteRecepcionDeMensajesDelSistema() {
            BroadcastReceiver br = new ReceptorDeMensajes();
            IntentFilter filter =
                    new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            filter.addAction(Intent.ACTION_POWER_CONNECTED);
            filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
            this.registerReceiver(br, filter);
        }

}