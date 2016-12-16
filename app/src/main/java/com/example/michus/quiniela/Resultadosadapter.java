package com.example.michus.quiniela;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
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
            convertView=inflater.inflate(R.layout.fragment_main,parent,false);
        }
        TextView Tvlocal=(TextView) convertView.findViewById(R.id.Tvlocal);
        TextView Tvvisitante=(TextView) convertView.findViewById(R.id.Tvvisitante);
        ImageView Ivuno=(ImageView) convertView.findViewById(R.id.Ivuno);
        ImageView Ivequis=(ImageView) convertView.findViewById(R.id.Ivequis);
        ImageView Ivdos=(ImageView) convertView.findViewById(R.id.Ivdos);

        Tvlocal.setText(resultado.getLocal());
        Tvvisitante.setText(resultado.getVisitante());
        if (resultado.gollocal>resultado.getGolvisit()){
            Ivuno.getResources().getDrawable(R.drawable.uno_tachado,null);
        }
        if (resultado.getGollocal()<resultado.getGolvisit()){
            Ivequis.getResources().getDrawable(R.drawable.dos_tachado,null);
        }
        if (resultado.getGollocal()==resultado.getGolvisit()){
            Ivdos.getResources().getDrawable(R.drawable.equis_tachado,null);
        }

        return  convertView;
    }
}
