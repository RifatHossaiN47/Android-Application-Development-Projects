package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<int[]> combinationList=new ArrayList<>();
    int[] boxpositions={0,0,0,0,0,0,0,0,0};
    int playerturn=1;
    int totalselectedboxes=1;
    String fps,sps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView fp=findViewById(R.id.fp);
        TextView sp=findViewById(R.id.sp);
        LinearLayout fpb=findViewById(R.id.fpb);
        LinearLayout spb=findViewById(R.id.spb);
        ImageView img1=findViewById(R.id.img1);
        ImageView img2=findViewById(R.id.img2);ImageView img3=findViewById(R.id.img3);ImageView img4=findViewById(R.id.imageView13);
        ImageView img5=findViewById(R.id.imageView14);ImageView img6=findViewById(R.id.imageView19);ImageView img7=findViewById(R.id.img7);
        ImageView img8=findViewById(R.id.img8);ImageView img9=findViewById(R.id.img9);
        combinationList.add(new int[]{0,1,2});
        combinationList.add(new int[]{3,4,5});
        combinationList.add(new int[]{6,7,8});
        combinationList.add(new int[]{0,3,6});
        combinationList.add(new int[]{0,4,8});
        combinationList.add(new int[]{1,4,7});
        combinationList.add(new int[]{2,5,8});
        combinationList.add(new int[]{2,4,6});
         fps=getIntent().getStringExtra("fp");
         sps=getIntent().getStringExtra("sp");
        fp.setText(fps);
        sp.setText(sps);
       playerchange(playerturn,fpb,spb);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(isboxselectable(0)){
                boxpositions[0]=playerturn;
                performaction((ImageView) v);
                playerchange(playerturn,fpb,spb);
            }else{
                Toast.makeText(MainActivity.this,"Already Selected",Toast.LENGTH_SHORT).show();
            }

            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isboxselectable(1)){
                    boxpositions[1]=playerturn;
                    performaction((ImageView) v);
                    playerchange(playerturn,fpb,spb);
                }else{
                    Toast.makeText(MainActivity.this,"Already Selected",Toast.LENGTH_SHORT).show();
                }

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isboxselectable(2)){
                    boxpositions[2]=playerturn;
                    performaction((ImageView) v);
                    playerchange(playerturn,fpb,spb);
                }else{
                    Toast.makeText(MainActivity.this,"Already Selected",Toast.LENGTH_SHORT).show();
                }

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isboxselectable(3)){
                    boxpositions[3]=playerturn;
                    performaction((ImageView) v);
                    playerchange(playerturn,fpb,spb);
                }else{
                    Toast.makeText(MainActivity.this,"Already Selected",Toast.LENGTH_SHORT).show();
                }

            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isboxselectable(4)){
                    boxpositions[4]=playerturn;
                    performaction((ImageView) v);
                    playerchange(playerturn,fpb,spb);
                }else{
                    Toast.makeText(MainActivity.this,"Already Selected",Toast.LENGTH_SHORT).show();
                }

            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isboxselectable(5)){
                    boxpositions[5]=playerturn;
                    performaction((ImageView) v);
                    playerchange(playerturn,fpb,spb);
                }else{
                    Toast.makeText(MainActivity.this,"Already Selected",Toast.LENGTH_SHORT).show();
                }

            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isboxselectable(6)){
                    boxpositions[6]=playerturn;
                    performaction((ImageView) v);
                    playerchange(playerturn,fpb,spb);
                }else{
                    Toast.makeText(MainActivity.this,"Already Selected",Toast.LENGTH_SHORT).show();
                }

            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isboxselectable(7)){
                    boxpositions[7]=playerturn;
                    performaction((ImageView) v);
                    playerchange(playerturn,fpb,spb);
                }else{
                    Toast.makeText(MainActivity.this,"Already Selected",Toast.LENGTH_SHORT).show();
                }

            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isboxselectable(8)){
                    boxpositions[8]=playerturn;
                    performaction((ImageView) v);
                    playerchange(playerturn,fpb,spb);
                }else{
                    Toast.makeText(MainActivity.this,"Already Selected",Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
    void playerchange(int playerturn,LinearLayout fpb,LinearLayout spb){
            if(playerturn==1){
                fpb.setBackgroundResource(R.drawable.bboxchange);
                spb.setBackgroundResource(R.drawable.bbox);
            }else{
                spb.setBackgroundResource(R.drawable.bboxchange);
                fpb.setBackgroundResource(R.drawable.bbox);
            }
    }
    boolean checkwin(int playerturn){
        for(int i=0;i<combinationList.size();i++){
            int[] v=combinationList.get(i);
            if(playerturn==boxpositions[v[0]] && playerturn==boxpositions[v[1]] && playerturn==boxpositions[v[2]]){
                return true;
            }
        }
        return false;
    }
    void performaction(ImageView imageView){
            if(checkwin(playerturn)){
                Dialog d=new Dialog(this);
                d.setContentView(R.layout.win);
                TextView textView=d.findViewById(R.id.textView2);
                if(playerturn==1) textView.setText("WINNER: "+fps);
                else textView.setText("WINNER: " +sps);
                Button bt1=d.findViewById(R.id.button);
                Button bt2=d.findViewById(R.id.button2);
                d.setCancelable(false);
                d.show();
                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        startActivity(getIntent());

                    }
                });
                bt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this,AddPlayers.class);
                        startActivity(intent);
                    }
                });

            }else if(totalselectedboxes==9) {
                Dialog d = new Dialog(this);
                d.setContentView(R.layout.win);
                TextView textView = d.findViewById(R.id.textView2);
                textView.setText("DRAW!!!");
                Button bt1 = d.findViewById(R.id.button);
                Button bt2 = d.findViewById(R.id.button2);
                d.setCancelable(false);
                d.show();
                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        startActivity(getIntent());

                    }
                });
                bt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, AddPlayers.class);
                        startActivity(intent);
                    }
                });
            }else{
                if(playerturn==1){
                imageView.setImageResource(R.drawable.cancel);
                totalselectedboxes++;
                playerturn=2;
            } else{
                imageView.setImageResource(R.drawable.dfd);
                totalselectedboxes++;
                playerturn=1;
            }
        }

    }
    boolean isboxselectable(int position){
        boolean response=false;
        if(boxpositions[position]==0) {
            response = true;
        }
        return response;
    }
}