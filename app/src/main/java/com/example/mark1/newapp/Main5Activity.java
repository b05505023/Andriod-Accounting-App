package com.example.mark1.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }
    public void goHome(View V){
        finish();
    }
    public void delete(View v){
        switch (v.getId()){
            case R.id.breakfast:
                btn = (Button)findViewById(R.id.breakfast);
                break;
            case R.id.launch:
                btn = (Button)findViewById(R.id.launch);
                break;
            case R.id.dinner:
                btn = (Button)findViewById(R.id.dinner);
                break;
            case R.id.clothing:
                btn = (Button)findViewById(R.id.clothing);
                break;
            case R.id.traffic:
                btn = (Button)findViewById(R.id.traffic);
                break;
            case R.id.med:
                btn = (Button)findViewById(R.id.med);
                break;
            case R.id.drink:
                btn = (Button)findViewById(R.id.drink);
                break;
            case R.id.livings:
                btn = (Button)findViewById(R.id.livings);
                break;
            case R.id.entertainment:
                btn = (Button)findViewById(R.id.entertainment);
                break;
            case R.id.c3c:
                btn = (Button)findViewById(R.id.c3c);
                break;
            case R.id.others:
                btn = (Button)findViewById(R.id.others);
                break;
        }
        String event = btn.getText().toString();
        Intent it = new Intent();
        it.setClass(this,Main6Activity.class);
        it.putExtra("edit_event",event);
        startActivity(it);
        finish();
    }
}
