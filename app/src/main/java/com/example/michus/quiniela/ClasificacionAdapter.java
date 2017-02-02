package com.example.michus.quiniela;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.color;
import static android.R.attr.resource;

/**
 * _Created by 46453895j on 13/01/17.
 */

public class ClasificacionAdapter extends ArrayAdapter<Equipo> {

    public ClasificacionAdapter(Context context, int resource,List<Equipo> objects) {
        super(context,resource,objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Equipo equipo = getItem(position);

        Log.d("--CLASIFICACION LIGA---", String.valueOf(convertView));

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.infoclasificacion, parent, false);

        }

        TextView nombre = (TextView) convertView.findViewById(R.id.Tvteam);
        TextView posicion = (TextView) convertView.findViewById(R.id.Tvorden);
        ImageView escudo = (ImageView) convertView.findViewById(R.id.Ivlogo);

        String nom = equipo.getNombre();
        String posicio = equipo.getPosliga();

        nombre.setText(nom);
        posicion.setText(posicio);

        switch (nom) {
            case "Real Madrid CF":
                escudo.setImageResource(R.drawable.realmadrid);
                break;
            case "FC Barcelona":
                escudo.setImageResource(R.drawable.barsa);
                break;
            case "Sevilla FC":
                escudo.setImageResource(R.drawable.sevilla);
                break;
            case "Villarreal CF":
                escudo.setImageResource(R.drawable.villareal);
                break;
            case "Real Sociedad de Fútbol":
                escudo.setImageResource(R.drawable.realsociedad);
                break;
            case "Club Atlético de Madrid":
                escudo.setImageResource(R.drawable.atletico);
                break;
            case "Athletic Club":
                escudo.setImageResource(R.drawable.atleti);
                break;
            case "SD Eibar":
                escudo.setImageResource(R.drawable.eibar);
                break;
            case "RCD Espanyol":
                escudo.setImageResource(R.drawable.espanyol);
                break;
            case "UD Las Palmas":
                escudo.setImageResource(R.drawable.palmas);
                break;
            case "Málaga CF":
                escudo.setImageResource(R.drawable.malaga);
                break;
            case "Deportivo Alavés":
                escudo.setImageResource(R.drawable.alaves);
                break;
            case "RC Celta de Vigo":
                escudo.setImageResource(R.drawable.celta);
                break;
            case "Real Betis":
                escudo.setImageResource(R.drawable.betis);
                break;
            case "RC Deportivo La Coruna":
                escudo.setImageResource(R.drawable.depor);
                break;
            case "CD Leganes":
                escudo.setImageResource(R.drawable.leganes);
                break;
            case "Valencia CF":
                escudo.setImageResource(R.drawable.valencia);
                break;
            case "Sporting Gijón":
                escudo.setImageResource(R.drawable.sporting);
                break;
            case "Granada CF":
                escudo.setImageResource(R.drawable.granada);
                break;
            case "CA Osasuna":
                escudo.setImageResource(R.drawable.osasuna);
                break;
            case "Sevilla II":
                escudo.setImageResource(R.drawable.sevilla);
                break;
            case "Levante UD":
                escudo.setImageResource(R.drawable.levante);
                break;
            case "Girona FC":
                escudo.setImageResource(R.drawable.girona);
                break;
            case "Cádiz CF":
                escudo.setImageResource(R.drawable.cadiz);
                break;
            case "Getafe CF":
                escudo.setImageResource(R.drawable.getafe);
                break;
            case "Real Valladolid":
                escudo.setImageResource(R.drawable.valladolid);
                break;
            case "CD Tenerife":
                escudo.setImageResource(R.drawable.tenerife);
                break;
            case "CD Lugo":
                escudo.setImageResource(R.drawable.lugo);
                break;
            case "CF Reus Deportiu":
                escudo.setImageResource(R.drawable.reus);
                break;

            case "Real Oviedo":
                escudo.setImageResource(R.drawable.oviedo);
                break;
            case "CD Numancia de Soria":
                escudo.setImageResource(R.drawable.numancia);
                break;
            case "Elche FC":
                escudo.setImageResource(R.drawable.elche);
                break;
            case "Huesca":
                escudo.setImageResource(R.drawable.huesca);
                break;
            case "AD Alcorcón":
                escudo.setImageResource(R.drawable.alcorcon);
                break;
            case "Córdoba CF":
                escudo.setImageResource(R.drawable.cordoba);
                break;
            case "Rayo Vallecano de Madrid":
                escudo.setImageResource(R.drawable.rayo);
                break;
            case "RCD Mallorca":
                escudo.setImageResource(R.drawable.mallorca);
                break;
            case "UD Almería":
                escudo.setImageResource(R.drawable.almeria);
                break;
            case "UCAM Murcia":
                escudo.setImageResource(R.drawable.murcia);
                break;
            case "CD mirandes":
                escudo.setImageResource(R.drawable.mirandes);
                break;
            case "Gimnàstic de Tarragona":
                escudo.setImageResource(R.drawable.tarragona);
                break;
            case "Real Zaragoza":
                escudo.setImageResource(R.drawable.zaragoza);
                break;

            default:
                System.out.println("error");
                break;
        }
        Log.d("--CLASIFICACION pos---", String.valueOf(convertView));

        return convertView;

    }
}
