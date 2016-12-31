package com.example.michus.quiniela;

import java.io.Serializable;

/**
 * Created by MICHUS on 11/12/2016.
 */

public class Resultados implements Serializable{


    Equipo local;
    Equipo visitante;
    String status;
    String gollocal;
    String golvisit;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Resultados(Equipo local, Equipo visitante, String gollocal, String golvisit, String status) {

        this.local = local;
        this.visitante = visitante;
        this.gollocal = gollocal;
        this.golvisit = golvisit;
        this.status=status;

    }



    public Equipo getLocal() {
        return local;
    }




    public String getGollocal() {
        return gollocal;
    }


    public String getGolvisit() {
        return golvisit;
    }





    public Equipo getVisitante() {
        return visitante;
    }




}
