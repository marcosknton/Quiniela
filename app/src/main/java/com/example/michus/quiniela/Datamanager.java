package com.example.michus.quiniela;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import java.util.ArrayList;

import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by MICHUS on 04/01/2017.
 */

public class Datamanager {

    private static UriHelper URI_HELPER=UriHelper.with(ContentProvider.AUTHORITY);
    //dirección uri de la clase resultado
    private static Uri RESULTADO_URI = URI_HELPER.getUri(Resultados.class);



    static void guardaresultados(ArrayList<Resultados> resultados, Context context){
        cupboard().withContext(context).put(RESULTADO_URI,Resultados.class,resultados);
    }

    static void borraresultados(Context context){
        cupboard().withContext(context).delete(RESULTADO_URI,"_id > ?","0");
    }
    static CursorLoader getCursorLoader(Context context) {
        return new CursorLoader(context, RESULTADO_URI, null, null, null, null);
    }
}
