package com.example.michus.quiniela;

import java.io.Serializable;

/**
 * Created by MICHUS on 11/12/2016.
 */

public class Resultados implements Serializable{

    String Equipo1;
    String Equipo2;

    String pos_equipo1;
    String Pos_equipo2;

    String pg1;
    String pg2;

    String pe1;
    String pe2;

    String pp1;
    String pp2;


    String status;
    String fecha;
    String gollocal;
    String golvisit;


    public Resultados( String status, String fecha, String gollocal, String golvisit) {
        this.status = status;
        this.fecha = fecha;
        this.gollocal = gollocal;
        this.golvisit = golvisit;
          }

    public Resultados(){

}





    public String getEquipo1() {
        return Equipo1;
    }

    public void setEquipo1(String equipo1) {
        Equipo1 = equipo1;
    }

    public String getGolvisit() {
        return golvisit;
    }

    public void setGolvisit(String golvisit) {
        this.golvisit = golvisit;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getGollocal() {
        return gollocal;
    }

    public void setGollocal(String gollocal) {
        this.gollocal = gollocal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPp2() {
        return pp2;
    }

    public void setPp2(String pp2) {
        this.pp2 = pp2;
    }

    public String getPp1() {
        return pp1;
    }

    public void setPp1(String pp1) {
        this.pp1 = pp1;
    }

    public String getPe2() {
        return pe2;
    }

    public void setPe2(String pe2) {
        this.pe2 = pe2;
    }

    public String getPg2() {
        return pg2;
    }

    public void setPg2(String pg2) {
        this.pg2 = pg2;
    }

    public String getPe1() {
        return pe1;
    }

    public void setPe1(String pe1) {
        this.pe1 = pe1;
    }

    public String getPg1() {
        return pg1;
    }

    public void setPg1(String pg1) {
        this.pg1 = pg1;
    }

    public String getPos_equipo2() {
        return Pos_equipo2;
    }

    public void setPos_equipo2(String pos_equipo2) {
        Pos_equipo2 = pos_equipo2;
    }

    public String getPos_equipo1() {
        return pos_equipo1;
    }

    public void setPos_equipo1(String pos_equipo1) {
        this.pos_equipo1 = pos_equipo1;
    }

    public String getEquipo2() {
        return Equipo2;
    }

    public void setEquipo2(String equipo2) {
        Equipo2 = equipo2;
    }
}
