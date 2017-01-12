package com.example.michus.quiniela;

import android.database.sqlite.SQLiteDatabase;

import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by MICHUS on 04/01/2017.
 */

public class ContentProvider extends CupboardContentProvider{

    public static final String AUTHORITY=BuildConfig.APPLICATION_ID + ".provider";
    static{
        cupboard().register(Resultados.class);
        cupboard().register(Equipo.class);
    }
    public ContentProvider(){
        super(AUTHORITY,1);
    }


}
