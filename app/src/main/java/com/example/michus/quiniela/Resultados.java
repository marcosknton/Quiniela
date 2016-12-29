package com.example.michus.quiniela;

/**
 * Created by MICHUS on 11/12/2016.
 */

public class Resultados {

    String local;
    String visitante;
    String status;
    String gollocal;
    String golvisit;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Resultados(String local, String visitante, String gollocal, String golvisit, String status) {

        this.local = local;
        this.visitante = visitante;
        this.gollocal = gollocal;
        this.golvisit = golvisit;
        this.status=status;

    }



    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getGollocal() {
        return gollocal;
    }

    public void setGollocal(String gollocal) {
        this.gollocal = gollocal;
    }

    public String getGolvisit() {
        return golvisit;
    }

    public void setGolvisit(String golvisit) {
        this.golvisit = golvisit;
    }



    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }


}
