package com.example.michus.quiniela;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.alexvasilkov.events.Events;

import static com.example.michus.quiniela.R.id.Tvjornada;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // registramos al suscriptor dentro del bus de eventos. Esto se hace pasando la instancia del objeto que contiene el método
        Events.register(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i =new Intent(this,Jornada.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //Los suscriptores son los métodos que serán llamados obteniendo el parámetro del bus y realizando las acciones descritas dentro del método
    @Events.Subscribe("traspaso_jornada")
    private void passjornada(String sjornada) {
        TextView jornada = (TextView) findViewById(Tvjornada);
        jornada.setText("jornada "+sjornada);
    }
}
