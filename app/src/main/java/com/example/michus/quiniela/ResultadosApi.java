package com.example.michus.quiniela;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by MICHUS on 11/12/2016.
 */

public class ResultadosApi {

    public ResultadosApi() {

    }

    //private static String url = "http://api.football-data.org/v1/competitions/436/fixtures?";


    public static ArrayList<Resultados> Getresultados(String jornada,String jornada2, ArrayList<Equipo> Aequipos) throws IOException, JSONException {

        Log.d("----jornada----", jornada);
        ArrayList<Resultados> Aresultados = new ArrayList<>();
        int num=436;
        while(num<438) {
            String url = "http://api.football-data.org/v1/competitions/" + num + "/fixtures?";
            Uri builtUri = null;
            if (num == 436) {
                builtUri = Uri.parse(url)
                        .buildUpon()
                        .appendQueryParameter("matchday", jornada)
                        .build();
            }
            else{
                builtUri = Uri.parse(url)
                        .buildUpon()
                        .appendQueryParameter("matchday", jornada2)
                        .build();
            }
            String urls = builtUri.toString();
            String JsonResponse = HttpUtils.get(urls);
            JSONObject json = new JSONObject(JsonResponse);
            //creamos un array de cada elemento que forma parte de la estrucutra del objeto json ,guiandonos por el elemento que
            //envueleve toda la estructura que es
            JSONArray jsonres = json.getJSONArray("fixtures");
            for (int i = 0; i < jsonres.length(); i++) {
                JSONObject object = jsonres.getJSONObject(i);
                String local = object.getString("homeTeamName");
                Log.d("----LOCAL----", local);
                String visitante = object.getString("awayTeamName");
                Log.d("----VISITANTE----", visitante);
                String fecha = object.getString("date");
                String status = object.getString("status");
                Log.d("----STATUS----", String.valueOf(status));
                JSONObject goles = object.getJSONObject("result");
                String gollocal = goles.getString("goalsHomeTeam");
                //Log.d("----GOLLOCAL----", String.valueOf(gollocal));
                String golvisit = goles.getString("goalsAwayTeam");
                //Log.d("----GOLVISIT----", String.valueOf(golvisit));
                Resultados resultado = new Resultados(status, fecha, gollocal, golvisit);
                Aresultados.add(llenarresultado(Aequipos, local, visitante, resultado));
            }
            num++;
        }
        return Aresultados;
    }

    private static Resultados llenarresultado(ArrayList<Equipo> aequipos, String local, String visitante, Resultados resultado) {
        boolean check=true;
        boolean check2=true;
        for (int i = 0; i < aequipos.size()&&check==true; i++) {
            Equipo equipo = aequipos.get(i);
            if (equipo.getNombre().equalsIgnoreCase(visitante)) {
                resultado.setEquipo2(equipo.getNombre());
                resultado.setPos_equipo2(equipo.getPosliga());
                resultado.setPg2(equipo.getAwaywin());
                resultado.setPe2(equipo.getAwayempate());
                resultado.setPp2(equipo.getAwaylose());
                check=false;
            }
        }
        for (int j = 0; j < aequipos.size()&&check2==true; j++) {
            Equipo equipo = aequipos.get(j);
            if (equipo.getNombre().equalsIgnoreCase(local)) {
                resultado.setEquipo1(equipo.getNombre());
                resultado.setPos_equipo1(equipo.getPosliga());
                resultado.setPg1(equipo.getHomewin());
                resultado.setPe1(equipo.getHomeempate());
                resultado.setPp1(equipo.getHomelose());
                check2=false;
            }
        }


    return resultado;
    }




}