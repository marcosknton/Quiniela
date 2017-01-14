package com.example.michus.quiniela;

import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import static android.R.id.list;

import com.alexvasilkov.events.Events;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ClasificacionFragment extends Fragment {

   ClasificacionAdapter adapter;
    ArrayList <Equipo> items;


    public ClasificacionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clasificacion, container, false);
        ListView lvclasificacion= (ListView) view.findViewById(R.id.Lvclasificacion);

        items=new ArrayList<>();

        adapter=new ClasificacionAdapter(getContext(),R.layout.infoclasificacion,items);

        lvclasificacion.setAdapter(adapter);

        return view;
    }

    public void onStart() {
        super.onStart();
        refreshequipos();

    }

    private void refreshequipos() {
        RefreshDataequipos task = new RefreshDataequipos();
        task.execute();
    }

    class RefreshDataequipos extends AsyncTask <Void,Void,ArrayList<Equipo>>{

        @Override
        protected ArrayList<Equipo> doInBackground(Void... voids) {
            ArrayList<Equipo> Aequipo;
            Aequipo=EquiposApi.Getequipos();
            return Aequipo;
        }

        @Override
        protected void onPostExecute(ArrayList<Equipo> equipos) {
            //adapter.clear();
            for (Equipo equipo : equipos){
                Log.d("--CLASIFICACI onpos---", String.valueOf(equipo.getNombre()));
                adapter.add(equipo);
            }
        }
    }



}
