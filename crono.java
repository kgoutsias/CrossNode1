package com.example.konstantinosgs.crossnode1;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.konstantinosgs.crossnode1.R.id.textView;

public class crono extends AppCompatActivity {

    private TextView TvTime;
    private Button BtnStart;
    private Button BtnStop;

    private Context mContext;
    private com.example.konstantinosgs.crossnode1.Chronometer mChronometer;
    private Thread mThreadChrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crono);

        mContext = this;

        TvTime = (TextView) findViewById(R.id.TvTime1);
        BtnStart = (Button) findViewById(R.id.BtnStart1);
        BtnStop = (Button) findViewById(R.id.BtnStop1);


        BtnStart.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (mChronometer == null) {
                    mChronometer = new com.example.konstantinosgs.crossnode1.Chronometer(mContext);
                    mThreadChrono = new Thread(mChronometer);
                    mThreadChrono.start();
                    mChronometer.start();

                }
            }
        });


        BtnStop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (mChronometer != null) {
                    mChronometer.stop();
                    mThreadChrono.interrupt();
                    mThreadChrono=null;
                    mChronometer=null;

                }
            }
        });

    }

    public void updateTimeText(final String time){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TvTime.setText(time);
            }
        });
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }


    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("my_text",TvTime.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);



        TvTime.setText(savedInstanceState.getString("my_text"));


    }

}
