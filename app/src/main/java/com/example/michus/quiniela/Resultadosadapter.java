package com.example.michus.quiniela;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MICHUS on 16/12/2016.
 */

public class Resultadosadapter extends ArrayAdapter<Resultados> {

    public Resultadosadapter(Context context, int resource, List<Resultados> objects) {
        super(context, resource, objects);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Resultados resultado=getItem(position);

        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.fragment_inforesultados,parent,false);
        }
        TextView local=(TextView) convertView.findViewById(R.id.Tvlocal);
        TextView visitante=(TextView) convertView.findViewById(R.id.Tvvisitante);
        ImageView uno=(ImageView) convertView.findViewById(R.id.Ivuno);
        ImageView equis=(ImageView) convertView.findViewById(R.id.Ivequis);
        ImageView dos=(ImageView) convertView.findViewById(R.id.Ivdos);


        local.setText(resultado.getLocal());
        visitante.setText(resultado.getVisitante());
        if (resultado.getGollocal()>resultado.getGolvisit()){
            uno.setImageResource(R.drawable.uno_tachado);
            Log.d("local", "uno");
        }else uno.setImageResource(R.drawable.uno_sin_tachar);
        if (resultado.getGollocal()<resultado.getGolvisit()){
            dos.setImageResource(R.drawable.dos_tachado);
            Log.d("local", "dos");
        }else dos.setImageResource(R.drawable.dos_sin_tachar);
        if (resultado.getGollocal()==resultado.getGolvisit()){
            equis.setImageResource(R.drawable.equis_tachado);
            Log.d("local", "equis");
        }else equis.setImageResource(R.drawable.equis_sin_tachar);

        return  convertView;


    }
}
