package com.example.michus.quiniela;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

import com.alexvasilkov.events.Events;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by MICHUS on 04/01/2017.
 */

public class RefreshDataTask extends AsyncTask<Void,Void,Void> {
    Context context;
    String sjornada;


   public  RefreshDataTask(Context context){
        this.context=context;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Events.post("start");
    }

    @Override
    protected Void doInBackground(Void... voids) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        sjornada = preferences.getString("matchday", "");
        ArrayList<Equipo> Aequipo=EquiposApi.Getequipos();
        ArrayList<Resultados> result = null;
        try {
            result = ResultadosApi.Getresultados(sjornada, Aequipo);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Datamanager.borraresultados(context);
        Datamanager.guardaresultados(result, context);
        //Datamanager.borrarequipo(context);
        //Datamanager.guardarequipo(Aequipo,context);

        int tamaño=Aequipo.size();
        String nombre=Aequipo.get(0).getNombre();

        Log.d("----EQUIPO-----", String.valueOf(tamaño));
        Log.d("---EQUIPO---",nombre);


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //creamos un evento y enviamos el parametro a traves del bus
        Events.create("traspaso_jornada").param(sjornada).post();
        Events.post("finish");
    }
}
