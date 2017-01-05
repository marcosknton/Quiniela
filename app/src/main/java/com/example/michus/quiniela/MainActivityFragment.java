package com.example.michus.quiniela;

import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.*;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alexvasilkov.events.Events;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{


    private ResultadosCursorAdapter adapter;


    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_main, container, false);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView lvresultados = (ListView) view.findViewById(R.id.lvresultados);


        adapter=new ResultadosCursorAdapter(getContext(),Resultados.class);
        lvresultados.setAdapter(adapter);

        lvresultados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Resultados resultados = (Resultados) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("resultado", resultados);

                startActivity(intent);
            }
        });
        getLoaderManager().initLoader(0, null, this);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    private void refresh() {
        RefreshDataTask task = new RefreshDataTask(getActivity().getApplicationContext());
        task.execute();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return Datamanager.getCursorLoader(getContext());
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