package com.example.michus.quiniela;

import java.io.Serializable;

/**
 * Created by MICHUS on 31/12/2016.
 */

public class Equipo implements Serializable{

    String homewin;
    String homeempate;
    String homelose;
    String nombre;
    String matchday;
    String posliga;
    String awaywin;
    String awayempate;
    String awaylose;

    public Equipo(String nombre, String matchday, String posliga, String homewin, String homeempate, String homelose, String awaywin, String awayempate, String awaylose) {
        this.homewin = homewin;
        this.homeempate = homeempate;
        this.homelose = homelose;
        this.nombre = nombre;
        this.matchday = matchday;
        this.posliga = posliga;
        this.awaywin = awaywin;
        this.awayempate = awayempate;
        this.awaylose = awaylose;
    }

    public String getHomewin() {
        return homewin;
    }

    public String getHomeempate() {
        return homeempate;
    }

    public String getHomelose() {
        return homelose;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatchday() {
        return matchday;
    }

    public String getPosliga() {
        return posliga;
    }

    public String getAwaywin() {
        return awaywin;
    }

    public String getAwayempate() {
        return awayempate;
    }

    public String getAwaylose() {
        return awaylose;
    }
}
