package com.example.michus.quiniela;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ClasificacionFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private ClasificacionCursorAdapter adapter;


    public ClasificacionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clasificacion, container, false);
        ListView lvclasificacion= (ListView) view.findViewById(R.id.Lvclasificacion);
        adapter=new ClasificacionCursorAdapter(getContext(),Equipo.class);

        lvclasificacion.setAdapter(adapter);
        getLoaderManager().initLoader(0, null, this);
        return view;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return Datamanager.getCursorLoaderequipo(getContext());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }
}
