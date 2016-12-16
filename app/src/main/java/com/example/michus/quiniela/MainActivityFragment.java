package com.example.michus.quiniela;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayList<Resultados> items;
    private Resultadosadapter adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_main, container, false);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView lvresultados=(ListView)view.findViewById(R.id.lvresultados);
        items =new ArrayList<>();
        adapter= new Resultadosadapter(getContext(),R.layout.fragment_main,items);
        lvresultados.setAdapter(adapter);
        return view;
    }


    private class RefreshDataTask extends AsyncTask<Void,Void,ArrayList<Resultados>>{
        @Override
        protected ArrayList<Resultados> doInBackground(Void... voids) {

            ResultadosApi api=new ResultadosApi();
            ArrayList<Resultados> result=api.Getresultados("14");
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Resultados> resultadoses) {
            adapter.clear();
            for(Resultados resultado: resultadoses){
                adapter.add(resultado);
            }

        }
    }

}
