package com.example.otakufourever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(accueil.this, game_page.class));
                finish();
            }
        };
        new Handler().postDelayed(runnable, 3000);
    }

}