package com.example.michus.quiniela;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alexvasilkov.events.Events;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayList<Resultados> items;
    private Resultadosadapter adapter;
    String sjornada;

    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_main, container, false);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView lvresultados=(ListView)view.findViewById(R.id.lvresultados);
        items =new ArrayList<>();
        adapter= new Resultadosadapter(getContext(),R.layout.fragment_inforesultados,items);
        lvresultados.setAdapter(adapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }
    private void refresh(){
        RefreshDataTask task=new RefreshDataTask();
        task.execute();
    }


    private class RefreshDataTask extends AsyncTask<Void,Void,ArrayList<Resultados>>{
        @Override
        protected ArrayList<Resultados> doInBackground(Void... voids) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            sjornada=preferences.getString("matchday","");
            //creamos un evento y enviamos el parametro a traves del bus
            Events.create("traspaso_jornada").param(sjornada).post();
            ResultadosApi api=new ResultadosApi();
            ArrayList<Resultados> result=api.Getresultados(sjornada);

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Resultados> result) {
            adapter.clear();
            for(Resultados resultado: result){
                adapter.add(resultado);

            }

        }
    }




}
