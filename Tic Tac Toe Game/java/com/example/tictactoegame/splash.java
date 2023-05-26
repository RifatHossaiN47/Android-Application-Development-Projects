package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    ImageView img;
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        img=findViewById(R.id.img);
        tx=findViewById(R.id.tx);
        Animation m= AnimationUtils.loadAnimation(this,R.anim.splashanim);
        Animation mm=AnimationUtils.loadAnimation(this,R.anim.text);
        Intent intent=new Intent(splash.this,AddPlayers.class);
        img.startAnimation(m);
        tx.startAnimation(mm);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            startActivity(intent);
            finish();
            }
        },3000);

    }
}