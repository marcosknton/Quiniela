package com.example.michus.quiniela;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexvasilkov.events.Events;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private View view;
    private TextView Tvfecha;
    private TextView Tvresultado;
    private TextView Tvposvisitante;
    private TextView Tvposlocal;

    private TextView Tvlocalname;
    private TextView Tvawayname;

    private TextView Tvhomewin;
    private TextView Tvawaywin;

    private TextView Tvhomeempate;
    private TextView Tvawayempate;

    private TextView Tvhomelose;
    private TextView Tvawaylose;

    private ImageView Ivvistante;
    private ImageView Ivlocal;


    public DetailActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        Events.register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_detail, container, false);
        Intent i=getActivity().getIntent();
    if (i!=null){
        Resultados resultado=(Resultados) i.getSerializableExtra("resultado");
        if (resultado!=null){
            updateUi(resultado);
        }
    }

        return view;
    }

    private void updateUi(Resultados resultado) {

        Tvfecha= (TextView) view.findViewById(R.id.Tvhorario);
        Tvresultado = (TextView) view.findViewById(R.id.Tvresultado);

        Tvposvisitante=(TextView)view.findViewById(R.id.Tvposvisitante);
        Tvposlocal=(TextView)view.findViewById(R.id.Tvposlocal);

        Tvlocalname=(TextView)view.findViewById(R.id.Tvlocalname);
        Tvawayname=(TextView)view.findViewById(R.id.Tvawayname);

        Tvhomewin=(TextView)view.findViewById(R.id.Tvhomewin);
        Tvawaywin=(TextView)view.findViewById(R.id.Tvawaywin);

        Tvhomeempate=(TextView)view.findViewById(R.id.Tvhomeempate);
        Tvawayempate=(TextView)view.findViewById(R.id.Tvawayempate);

        Tvhomelose=(TextView)view.findViewById(R.id.Tvhomelose);
        Tvawaylose=(TextView)view.findViewById(R.id.Tvawaylose);



        Ivvistante=(ImageView) view.findViewById(R.id.Ivvistante);
        Ivlocal=(ImageView)view.findViewById(R.id.Ivlocal);

        String nomlocal=resultado.getEquipo1();
        String nomvisitante=resultado.getEquipo2();
        String horario=resultado.getStatus();
        String[] fecha=resultado.getFecha().split("T");

        switch ( horario ) {
            case "SCHEDULED":
                Tvfecha.setText(fecha[0]+"\n"+fecha[1].substring(0,5) );
                Tvresultado.setText(" ");
                break;
            case "TIMED":
                Tvfecha.setText(fecha[0]+"\n"+fecha[1].substring(0,5) );
                Tvresultado.setText(" ");
                break;
            case "POSTPONED":
                Tvfecha.setText("APLAZADO");
                Tvresultado.setText(" ");
                break;
            case "FINISHED":
                Tvfecha.setText("FIN");
                Tvresultado.setText(resultado.gollocal+"-"+resultado.golvisit);

                break;
            case "IN_PLAY":
                Tvfecha.setText("EN JUEGO");
                Tvresultado.setText(resultado.gollocal+"-"+resultado.golvisit);
                break;
            default:
                System.out.println("error" );
                break;
        }


        Tvposlocal.setText("posición liga: "+resultado.getPos_equipo1());
        Tvlocalname.setText(nomlocal);
        Tvhomewin.setText("victorias en casa "+resultado.getPg1());
        Tvhomeempate.setText("empates en casa "+resultado.getPe1());
        Tvhomelose.setText("derrotas en casa "+resultado.getPp1());
        switch ( nomlocal ) {
            case "Real Madrid CF":
                Ivlocal.setImageResource(R.drawable.realmadrid);
                break;
            case "FC Barcelona":
                Ivlocal.setImageResource(R.drawable.barsa);
                break;
            case "Sevilla FC":
                Ivlocal.setImageResource(R.drawable.sevilla);
                break;
            case "Villarreal CF":
                Ivlocal.setImageResource(R.drawable.villareal);
                break;
            case "Real Sociedad de Fútbol":
                Ivlocal.setImageResource(R.drawable.realsociedad);
                break;
            case "Club Atlético de Madrid":
                Ivlocal.setImageResource(R.drawable.atletico);
                break;
            case "Athletic Club":
                Ivlocal.setImageResource(R.drawable.atleti);
                break;
            case "SD Eibar":
                Ivlocal.setImageResource(R.drawable.eibar);
                break;
            case "RCD Espanyol":
                Ivlocal.setImageResource(R.drawable.espanyol);
                break;
            case "UD Las Palmas":
                Ivlocal.setImageResource(R.drawable.palmas);
                break;
            case "Málaga CF":
                Ivlocal.setImageResource(R.drawable.malaga);
                break;
            case "Deportivo Alavés":
                Ivlocal.setImageResource(R.drawable.alaves);
                break;
            case "RC Celta de Vigo":
                Ivlocal.setImageResource(R.drawable.celta);
                break;
            case "Real Betis":
                Ivlocal.setImageResource(R.drawable.betis);
                break;
            case "RC Deportivo La Coruna":
                Ivlocal.setImageResource(R.drawable.depor);
                break;
            case "CD Leganes":
                Ivlocal.setImageResource(R.drawable.leganes);
                break;
            case "Valencia CF":
                Ivlocal.setImageResource(R.drawable.valencia);
                break;
            case "Sporting Gijón":
                Ivlocal.setImageResource(R.drawable.sporting);
                break;
            case "Granada CF":
                Ivlocal.setImageResource(R.drawable.granada);
                break;
            case "CA Osasuna":
                Ivlocal.setImageResource(R.drawable.osasuna);
                break;

            case "Levante UD":
                Ivlocal.setImageResource(R.drawable.levante);
                break;
            case "Girona FC":
                Ivlocal.setImageResource(R.drawable.girona);
                break;
            case "Cádiz CF":
                Ivlocal.setImageResource(R.drawable.cadiz);
                break;
            case "Getafe CF":
                Ivlocal.setImageResource(R.drawable.getafe);
                break;
            case "Real Valladolid":
                Ivlocal.setImageResource(R.drawable.valladolid);
                break;
            case "CD Tenerife":
                Ivlocal.setImageResource(R.drawable.tenerife);
                break;
            case "CD Lugo":
                Ivlocal.setImageResource(R.drawable.lugo);
                break;
            case "CF Reus Deportiu":
                Ivlocal.setImageResource(R.drawable.reus);
                break;
            case "Sevilla II":
                Ivlocal.setImageResource(R.drawable.sevilla);
                break;
            case "Real Oviedo":
                Ivlocal.setImageResource(R.drawable.oviedo);
                break;
            case "CD Numancia de Soria":
                Ivlocal.setImageResource(R.drawable.numancia);
                break;
            case "Elche FC":
                Ivlocal.setImageResource(R.drawable.elche);
                break;
            case "Huesca":
                Ivlocal.setImageResource(R.drawable.huesca);
                break;
            case "AD Alcorcón":
                Ivlocal.setImageResource(R.drawable.alcorcon);
                break;
            case "Córdoba CF":
                Ivlocal.setImageResource(R.drawable.cordoba);
                break;
            case "Rayo Vallecano de Madrid":
                Ivlocal.setImageResource(R.drawable.rayo);
                break;
            case "RCD Mallorca":
                Ivlocal.setImageResource(R.drawable.mallorca);
                break;
            case "UD Almería":
                Ivlocal.setImageResource(R.drawable.almeria);
                break;
            case "UCAM Murcia":
                Ivlocal.setImageResource(R.drawable.murcia);
                break;
            case "CD mirandes":
                Ivlocal.setImageResource(R.drawable.mirandes);
                break;
            case "Gimnàstic de Tarragona":
                Ivlocal.setImageResource(R.drawable.tarragona);
                break;
            case "Real Zaragoza":
                Ivlocal.setImageResource(R.drawable.zaragoza);
                break;


            default:
                System.out.println("error" );
                break;
        }

        Tvposvisitante.setText("posición liga: "+resultado.getPos_equipo2());
        Tvawaywin.setText("victorias fuera: "+resultado.getPg2());
        Tvawayname.setText(nomvisitante);
        Tvawayempate.setText("empates fuera: "+resultado.getPe2());
        Tvawaylose.setText("derrotas fuera: "+resultado.getPp2());
        switch ( nomvisitante ) {
            case "Real Madrid CF":
                Ivvistante.setImageResource(R.drawable.realmadrid);
                break;
            case "FC Barcelona":
                Ivvistante.setImageResource(R.drawable.barsa);
                break;
            case "Sevilla FC":
                Ivvistante.setImageResource(R.drawable.sevilla);
                break;
            case "Villarreal CF":
                Ivvistante.setImageResource(R.drawable.villareal);
                break;
            case "Real Sociedad de Fútbol":
                Ivvistante.setImageResource(R.drawable.realsociedad);
                break;
            case "Club Atlético de Madrid":
                Ivvistante.setImageResource(R.drawable.atletico);
                break;
            case "Athletic Club":
                Ivvistante.setImageResource(R.drawable.atleti);
                break;
            case "SD Eibar":
                Ivvistante.setImageResource(R.drawable.eibar);
                break;
            case "RCD Espanyol":
                Ivvistante.setImageResource(R.drawable.espanyol);
                break;
            case "UD Las Palmas":
                Ivvistante.setImageResource(R.drawable.palmas);
                break;
            case "Málaga CF":
                Ivvistante.setImageResource(R.drawable.malaga);
                break;
            case "Deportivo Alavés":
                Ivvistante.setImageResource(R.drawable.alaves);
                break;
            case "RC Celta de Vigo":
                Ivvistante.setImageResource(R.drawable.celta);
                break;
            case "Real Betis":
                Ivvistante.setImageResource(R.drawable.betis);
                break;
            case "RC Deportivo La Coruna":
                Ivvistante.setImageResource(R.drawable.depor);
                break;
            case "CD Leganes":
                Ivvistante.setImageResource(R.drawable.leganes);
                break;
            case "Valencia CF":
                Ivvistante.setImageResource(R.drawable.valencia);
                break;
            case "Sporting Gijón":
                Ivvistante.setImageResource(R.drawable.sporting);
                break;
            case "Granada CF":
                Ivvistante.setImageResource(R.drawable.granada);
                break;
            case "CA Osasuna":
                Ivvistante.setImageResource(R.drawable.osasuna);
                break;
            case "Levante UD":
                Ivvistante.setImageResource(R.drawable.levante);
                break;
            case "Girona FC":
                Ivvistante.setImageResource(R.drawable.girona);
                break;
            case "Cádiz CF":
                Ivvistante.setImageResource(R.drawable.cadiz);
                break;
            case "Getafe CF":
                Ivvistante.setImageResource(R.drawable.getafe);
                break;
            case "Real Valladolid":
                Ivvistante.setImageResource(R.drawable.valladolid);
                break;
            case "CD Tenerife":
                Ivvistante.setImageResource(R.drawable.tenerife);
                break;
            case "CD Lugo":
                Ivvistante.setImageResource(R.drawable.lugo);
                break;
            case "CF Reus Deportiu":
                Ivvistante.setImageResource(R.drawable.reus);
                break;
            case "Sevilla II":
                Ivvistante.setImageResource(R.drawable.sevilla);
                break;
            case "Real Oviedo":
                Ivvistante.setImageResource(R.drawable.oviedo);
                break;
            case "CD Numancia de Soria":
                Ivvistante.setImageResource(R.drawable.numancia);
                break;
            case "Elche FC":
                Ivvistante.setImageResource(R.drawable.elche);
                break;
            case "Huesca":
                Ivvistante.setImageResource(R.drawable.huesca);
                break;
            case "AD Alcorcón":
                Ivvistante.setImageResource(R.drawable.alcorcon);
                break;
            case "Córdoba CF":
                Ivvistante.setImageResource(R.drawable.cordoba);
                break;
            case "Rayo Vallecano de Madrid":
                Ivvistante.setImageResource(R.drawable.rayo);
                break;
            case "RCD Mallorca":
                Ivvistante.setImageResource(R.drawable.mallorca);
                break;
            case "UD Almería":
                Ivvistante.setImageResource(R.drawable.almeria);
                break;
            case "UCAM Murcia":
                Ivvistante.setImageResource(R.drawable.murcia);
                break;
            case "CD mirandes":
                Ivvistante.setImageResource(R.drawable.mirandes);
                break;
            case "Gimnàstic de Tarragona":
                Ivvistante.setImageResource(R.drawable.tarragona);
                break;
            case "Real Zaragoza":
                Ivvistante.setImageResource(R.drawable.zaragoza);
                break;

            default:
                System.out.println("error" );
                break;
        }





    }
}
