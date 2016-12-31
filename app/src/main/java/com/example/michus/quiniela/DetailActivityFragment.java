package com.example.michus.quiniela;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private View view;
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

    private TextView Tvresultadolocal1;
    private TextView Tvresultadovisitante1;

    private ImageView Ivvistante;
    private ImageView Ivlocal;


    public DetailActivityFragment() {
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

        Tvresultadolocal1=(TextView)view.findViewById(R.id.Tvresultadolocal1);
        Tvresultadovisitante1=(TextView)view.findViewById(R.id.Tvresultadovisitante1);


        Ivvistante=(ImageView) view.findViewById(R.id.Ivvistante);
        Ivlocal=(ImageView)view.findViewById(R.id.Ivlocal);



        Tvresultadolocal1.setText(resultado.gollocal);
        Tvposlocal.setText("pos: "+resultado.getLocal().getPosliga());
        Tvlocalname.setText(resultado.getLocal().getNombre());
        Tvhomewin.setText("victorias locales: "+resultado.getLocal().getHomewin());
        Tvhomeempate.setText("empates locales "+resultado.getLocal().getHomeempate());
        Tvhomelose.setText("derrotas locales "+resultado.getLocal().getHomelose());
        Glide.with(getContext()).load(resultado.getLocal().getImagen()).into(Ivlocal);


        Tvresultadovisitante1.setText(resultado.golvisit);
        Tvposvisitante.setText("pos: "+resultado.getVisitante().getPosliga());
        Tvawaywin.setText("victorias como visitante: "+resultado.getVisitante().getAwaywin());
        Tvawayname.setText(resultado.getVisitante().getNombre());
        Tvawayempate.setText("empates como visitante: "+resultado.getVisitante().getAwayempate());
        Tvawaylose.setText("derrotas como visitante: "+resultado.getVisitante().getAwaylose());
        Glide.with(getContext()).load(resultado.getVisitante().getImagen()).into(Ivvistante);



    }
}
