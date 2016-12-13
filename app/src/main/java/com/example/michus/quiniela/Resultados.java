package com.example.michus.quiniela;

/**
 * Created by MICHUS on 11/12/2016.
 */

public class Resultados {

    String local;
    String visitante;
    int gollocal;
    int golvisit;



    public Resultados(String local, String visitante, int gollocal, int golvisit) {

        this.local = local;
        this.visitante = visitante;
        this.gollocal = gollocal;
        this.golvisit = golvisit;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getGollocal() {
        return gollocal;
    }

    public void setGollocal(int gollocal) {
        this.gollocal = gollocal;
    }

    public int getGolvisit() {
        return golvisit;
    }

    public void setGolvisit(int golvisit) {
        this.golvisit = golvisit;
    }



    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }


}
