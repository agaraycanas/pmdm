package org.agaray.pmdm.t5.componentes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceptorDeMensajes extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent i) {
        if (i.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            android.util.Log.i("BC", "Cargador conectado");
            Toast.makeText(context, "CONECTADO", Toast.LENGTH_SHORT).show();
        } else if (i.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            android.util.Log.i("BC", "Cargador desconectado");
            Toast.makeText(context, "DESCONECTADO", Toast.LENGTH_SHORT).show();
        }

    }
}
