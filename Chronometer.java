package com.example.konstantinosgs.crossnode1;

import android.content.Context;

/**
 * Created by konstantinosGs on 11/10/2016.
 */

public class Chronometer implements  Runnable {

    public static final long MILLIS_TO_MINUTES = 60000;
    public static  final long MILLIS_TO_HOURS = 3600000;
    private Context mContext;
    private long StarTime;
    private boolean IsRunning;

    public Chronometer(Context context){
        mContext = context;
    }

    public void start(){
        StarTime = System.currentTimeMillis();
        IsRunning=true;
    }
    public void stop(){
        IsRunning=false;
    }

    public void run(){
        while (IsRunning){
            long since = System.currentTimeMillis() - StarTime;
            int seconds = (int) ((since/1000) % 60);
            int minutes = (int) ((since/MILLIS_TO_MINUTES) % 60);
            int hours= (int) ((since/MILLIS_TO_HOURS) % 24);
            int millis= (int) since % 1000;

            ((crono)mContext).updateTimeText(String.format("%02d:%02d:%02d", hours,minutes,seconds));
        }
    }
}
