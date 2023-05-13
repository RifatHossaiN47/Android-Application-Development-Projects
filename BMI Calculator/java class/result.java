package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class result extends AppCompatActivity {
AppCompatButton bt;
RelativeLayout ll;
ImageView img;
TextView result,lresult,gender;
Intent in;
String g;
int h,w,a,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //getSupportActionBar().hide(); //action bar hide hoye jay jehetu action bar
        // amneo nai tai uncmmnt korle problem kore
//        getSupportActionBar().show();
//        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"><\font>"));
//        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#FBFCFC"));
//        getSupportActionBar().setTitle("RESULT");
//        getSupportActionBar().setBackgroundDrawable(colorDrawable);

       bt=findViewById(R.id.btn);
        gender=findViewById(R.id.gender);
        ll=findViewById(R.id.ll);
        result=findViewById(R.id.result);
        lresult=findViewById(R.id.lr);
        img=findViewById(R.id.img);
           in=getIntent();
            g=in.getStringExtra("g");
            h=in.getIntExtra("h",0);
            w=in.getIntExtra("w",0);
            a=in.getIntExtra("a",0);
            i=in.getIntExtra("i",0);
        double hh=((h*12)+i)*2.53;
       double ww=w;
        hh=hh/100;
        double rslt=ww/(hh*hh);
        String rs=Double.toString(rslt);
        if(rslt<16){
            lresult.setText("Severe Thinness");
            ll.setBackgroundColor(Color.RED);
            img.setImageResource(R.drawable.crosss);
        }else if(rslt<16.9){
            lresult.setText("Moderate Thinness");
            ll.setBackgroundColor(Color.YELLOW);
            result.setTextColor(Color.BLACK);
            lresult.setTextColor(Color.BLACK);
            gender.setTextColor(Color.BLACK);
            img.setImageResource(R.drawable.warning);
        }else if(rslt<18.4){
            lresult.setText("Mild Thinness");
            ll.setBackgroundColor(Color.YELLOW);
            result.setTextColor(Color.BLACK);
            lresult.setTextColor(Color.BLACK);
            gender.setTextColor(Color.BLACK);
            img.setImageResource(R.drawable.warning);
        }else if(rslt<25){
            lresult.setText("Normal");
            ll.setBackgroundColor(Color.GREEN);
            img.setImageResource(R.drawable.ok);
        }else if(rslt<29.4){
            lresult.setText("Overweight");
            ll.setBackgroundColor(Color.YELLOW);
            result.setTextColor(Color.BLACK);
            lresult.setTextColor(Color.BLACK);
            gender.setTextColor(Color.BLACK);
            img.setImageResource(R.drawable.warning);
        }else{
            lresult.setText("Obese Class I");
            ll.setBackgroundColor(Color.RED);
            img.setImageResource(R.drawable.crosss);
        }
        gender.setText(g);
        result.setText(rs);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(result.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}