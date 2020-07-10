package com.health.WekayaApp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.health.WekayaApp.R;

import java.util.Timer;
import java.util.TimerTask;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splashscreen.this , MainActivity.class) ;
                startActivity(intent);
                finish();
            }
        };
        new Timer().schedule(timerTask , 1500);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
