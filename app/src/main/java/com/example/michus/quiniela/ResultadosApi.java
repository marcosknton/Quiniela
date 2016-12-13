package com.example.michus.quiniela;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by MICHUS on 11/12/2016.
 */

public class ResultadosApi {

    public  ResultadosApi(){

    }

    private static String url="http://api.football-data.org/v1/competitions/436/fixtures?";

    public ArrayList<Resultados> Getresultados(String jornada){
        ArrayList <Resultados> Aresultados=new ArrayList<>();
        Uri builtUri = Uri.parse(url)
                .buildUpon()
                .appendQueryParameter("matchday",jornada)
                .build();
        String urls = builtUri.toString();
        try{
            String JsonResponse=HttpUtils.get(urls);
            JSONObject json = new JSONObject(JsonResponse);
            //creamos un array de cada elemento que forma parte de la estrucutra del objeto json ,guiandonos por el elemento que
            //envueleve toda la estructura que es
            JSONArray jsonres = json.getJSONArray("fixtures");
            for (int i = 0; i <jsonres.length() ; i++) {
                JSONObject object = jsonres.getJSONObject(i);
                String local=object.getString("homeTeamName");
                String visitante=object.getString("awayTeamName");
                JSONObject goles =object.getJSONObject("result");
                int gollocal=goles.getInt("goalsHomeTeam");
                int golvisit=goles.getInt("goalsAwayTeam");
                Resultados resultado=new Resultados(local,visitante,gollocal,golvisit);
                Aresultados.add(resultado);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Aresultados;
    }
}
