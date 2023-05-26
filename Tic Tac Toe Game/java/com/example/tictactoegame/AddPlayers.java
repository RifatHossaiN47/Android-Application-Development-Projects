package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddPlayers extends AppCompatActivity {
TextInputEditText et,ett;
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);
        et=findViewById(R.id.fp);
        ett=findViewById(R.id.sp);
        bt=findViewById(R.id.bb);
        Intent intent=new Intent(AddPlayers.this,MainActivity.class);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                String ss=ett.getText().toString();
                Log.d("gg", "hello");
                if(s.isEmpty() || ss.isEmpty()){
                    Toast.makeText(AddPlayers.this,"Please input players name!",Toast.LENGTH_SHORT).show();
                }else {
                    intent.putExtra("fp", s);
                    intent.putExtra("sp",ss);
                    startActivity(intent);
                }
            }
        });
    }
}