package com.example.myapplication.myapplication24;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;

public class MyService extends Service{
    private String statut = "";
    private MonBinder binder = new MonBinder();
    private static final String TAG = "ACOS";

    public MyService(){
        Log.i(TAG, "===> MyService - Constructeur");
    }

    private void arreterService(){
        stopSelf();
    }

    public class MonBinder extends Binder {
        MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public void onCreate(){
        Log.i(TAG, "===> onCreate" + statut);
        Date date = new Date();
        statut = "Je suis une service crée le" +date.toString();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "===> onStartCommand: \n\t\t" + statut);
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     *
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent){
        Log.i(TAG, "===>onBind:" + statut);
        return (IBinder) binder;
    }
    /**
     *
     * @param intent
     * @return
     */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "===>onUnBind:" + statut);
        return super.onUnbind(intent);
    }



    @Override
    public void onDestroy(){
        Log.i(TAG, "===> onDestroy:" + statut);
        super.onDestroy();
    }

    public String actionService(){
        Log.i(TAG, "===> actionService:" + statut);
        Date date = new Date();
        return "Voici un timestamp:" + date.getTime();
    }




}
