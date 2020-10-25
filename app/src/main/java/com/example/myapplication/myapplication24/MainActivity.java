package com.example.myapplication.myapplication24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ServiceConnection {
    private static final String TAG = "ACOS";
    ComponentName componentName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickBtnUn(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void onClickBtnDeux(View view) {
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, this, BIND_AUTO_CREATE);
    }

    public void onClickBtnTrois(View view) {
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, this, BIND_AUTO_CREATE);
    }

    public void onClickDeconnexion(View view) {
        Intent intent = new Intent(this, MyService.class);
        unbindService(this);
    }

    public void onClickLogLigne(View view) {
        Log.i(TAG,"-----------------------------------------");
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        componentName = name;
        Log.i(TAG, "Il y a eu une connexion au service" + name);
        MyService leService = ((MyService.MonBinder)service).getService();
        String resultat = leService.actionService();
        Log.i(TAG, "\t=>Info donnée par le service:" +resultat);


    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.i(TAG, "Il y a eu une deconnexion au service" + name);

    }
}