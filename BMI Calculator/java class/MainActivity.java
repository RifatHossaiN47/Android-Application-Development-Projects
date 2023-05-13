package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
AppCompatButton bn;
TextView height,weight,age,heightinch;
ImageView winc,wdec,ainc,adec;
SeekBar bar,barinch;
RelativeLayout male,female;
int heightv=5,inchv=5;
int weightv=55;
int agev=18;
String gender="0";
String heightvString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();

        bn=findViewById(R.id.btn);
        height=findViewById(R.id.height);
        winc=findViewById(R.id.winc);
        weight=findViewById(R.id.weight);
        age=findViewById(R.id.age);
        wdec=findViewById(R.id.wdec);
        ainc=findViewById(R.id.ainc);
        adec=findViewById(R.id.adec);
        bar=findViewById(R.id.seek);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        heightinch=findViewById(R.id.heightinch);
        barinch=findViewById(R.id.seekinch);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemaleselect));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.cardbackground));
                gender="Male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemaleselect));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.cardbackground));
                gender="Female";
            }
        });
        bar.setMax(9);
        bar.setProgress(5);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                heightv=progress;
                heightvString=String.valueOf(heightv);
                height.setText(heightvString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        barinch.setMax(11);
        barinch.setProgress(5);
        barinch.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                inchv=progress;
                heightinch.setText(String.valueOf(inchv));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        winc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightv=weightv+1;
                weight.setText(String.valueOf(weightv));
            }
        });
        wdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightv=weightv-1;
                weight.setText(String.valueOf(weightv));
            }
        });
        ainc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agev=agev+1;
                age.setText(String.valueOf(agev));
            }
        });
        adec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agev=agev-1;
                age.setText(String.valueOf(agev));
            }
        });
Intent intent=new Intent(MainActivity.this,result.class);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gender.equals("0")){
                    Toast.makeText(getApplicationContext(),"Please select a gender.",Toast.LENGTH_SHORT).show();
                }else if(heightv==0){
                    Toast.makeText(getApplicationContext(),"Please input your height.",Toast.LENGTH_SHORT).show();
                }else if(weightv==0 || weightv<0){
                    Toast.makeText(getApplicationContext(),"Your weight is not valid.",Toast.LENGTH_SHORT).show();
                }else if(agev==0 || agev<0){
                    Toast.makeText(getApplicationContext(),"Your age is not valid.",Toast.LENGTH_SHORT).show();
                }else {

                    intent.putExtra("h",heightv);
                    intent.putExtra("g",gender);
                    intent.putExtra("w",weightv);
                    intent.putExtra("a",agev);
                    intent.putExtra("i",inchv);
                startActivity(intent);
                }
            }
        });

    }
}