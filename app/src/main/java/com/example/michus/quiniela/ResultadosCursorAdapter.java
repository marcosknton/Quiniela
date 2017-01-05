package com.example.michus.quiniela;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MICHUS on 04/01/2017.
 */

public class ResultadosCursorAdapter extends CupboardCursorAdapter <Resultados> {

    public ResultadosCursorAdapter(Context context, Class<Resultados> entityClass) {
        super(context, entityClass);
    }

    @Override
    public View newView(Context context, Resultados model, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View convertView = inflater.inflate(R.layout.fragment_inforesultados, parent, false);
        return convertView;
    }

    @Override
    public void bindView(View view, Context context, Resultados resultado) {
        int gollocal=0;
        int golvisitante=0;

        TextView local=(TextView) view.findViewById(R.id.Tvlocal);
        TextView visitante=(TextView) view.findViewById(R.id.Tvvisitante);
        ImageView uno=(ImageView) view.findViewById(R.id.Ivuno);
        ImageView equis=(ImageView) view.findViewById(R.id.Ivequis);
        ImageView dos=(ImageView) view.findViewById(R.id.Ivdos);


        local.setText(resultado.Equipo1);
        visitante.setText(resultado.Equipo2);

        if (resultado.getStatus().equals("SCHEDULED")||resultado.getStatus().equals("POSTPONED")) {
            uno.setImageResource(R.drawable.uno_sin_tachar);
            dos.setImageResource(R.drawable.dos_sin_tachar);
            equis.setImageResource(R.drawable.equis_sin_tachar);
        }
        else {
            gollocal = Integer.parseInt(resultado.getGollocal());
            golvisitante = Integer.parseInt(resultado.getGolvisit());


            if (gollocal > golvisitante) {
                uno.setImageResource(R.drawable.uno_tachado);
                Log.d("local", "uno");
                Log.d("----STATUS-----", String.valueOf(resultado.getStatus()));
            } else uno.setImageResource(R.drawable.uno_sin_tachar);
            if (gollocal < golvisitante) {
                dos.setImageResource(R.drawable.dos_tachado);
                Log.d("local", "dos");
                Log.d("----STATUS----", String.valueOf(resultado.getStatus()));
            } else dos.setImageResource(R.drawable.dos_sin_tachar);
            if (gollocal == golvisitante) {
                equis.setImageResource(R.drawable.equis_tachado);
                Log.d("local", "equis");
                Log.d("----STATUS----", String.valueOf(resultado.getStatus()));
            } else equis.setImageResource(R.drawable.equis_sin_tachar);
        }
    }
}
