package com.example.konstantinosgs.crossnode1;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.example.konstantinosgs.crossnode1.R.id.textView;

public class home extends AppCompatActivity {

    public Button button;

    public void init(){

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent toy = new Intent(home.this,profile.class);
                startActivity(toy);

            }
        });
    }

    public ImageButton imageButton;

    public void init1(){

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v1)
            {
                Intent toy1 = new Intent(home.this,crono.class);
                startActivity(toy1);

            }
        });
    }

    public Button wodid;

    public void init2(){

        wodid = (Button)findViewById(R.id.wodid);
        wodid.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent toy = new Intent(home.this,wod.class);
                startActivity(toy);

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        init1();
        init2();
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



}
