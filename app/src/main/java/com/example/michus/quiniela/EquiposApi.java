package com.example.michus.quiniela;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by MICHUS on 31/12/2016.
 */

public class EquiposApi {

    public  EquiposApi(){

    }
    private static String urltable="http://api.football-data.org/v1/competitions/436/leagueTable";

    public ArrayList<Equipo> Getequipos() {
        ArrayList<Equipo> Aequipos = new ArrayList<>();
        Uri buildUritable = Uri.parse(urltable)
                .buildUpon()
                .build();
        String urlstable = buildUritable.toString();
        try {

            String JsonResponsetable = HttpUtils.get(urlstable);
            JSONObject jsontable = new JSONObject(JsonResponsetable);
            JSONArray jsonrestable = jsontable.getJSONArray("standing");
            for (int i = 0; i < jsonrestable.length(); i++) {
                JSONObject object = jsonrestable.getJSONObject(i);
                String position = object.getString("position");
                String teamName = object.getString("teamName");
                //String matchday = object.getString("matchday");
                String matchday="17";
                JSONObject home = object.getJSONObject("home");
                String winshome = home.getString("wins");
                String drawshome = home.getString("draws");
                String losseshome = home.getString("losses");

                JSONObject away = object.getJSONObject("home");
                String winsawya = away.getString("wins");
                String drawsaway = away.getString("draws");
                String lossesaway = away.getString("losses");
                Equipo equipo = new Equipo(teamName, matchday, position, winshome, drawshome, losseshome, winsawya, drawsaway, lossesaway);
                Aequipos.add(equipo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Aequipos;
    }
}
