package com.example.mark1.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onAdd(View v){
        Intent i = new Intent();
        i.setClass(this, Main2Activity.class);
        startActivity(i);
    }
    public void onAccount(View v){
        Intent i = new Intent();
        i.setClass(this, Main4Activity.class);
        startActivity(i);
    }
    public void onDelete(View v){
        Intent i = new Intent();
        i.setClass(this, Main5Activity.class);
        startActivity(i);
    }
}
