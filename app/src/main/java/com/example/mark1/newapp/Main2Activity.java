package com.example.mark1.newapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button btn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db=openOrCreateDatabase("testdb2", Context.MODE_PRIVATE,null);
        String createTable="CREATE TABLE IF NOT EXISTS "+"test2"+"("
                + "list_id VARCHAR(32), "
                +"money VARCHAR(16), "
                +"name VARCHAR(64),"
                +"note VARCHAR(64),"
                +"datestart VARCHAR(16)"
                + ")";
        db.execSQL(createTable);
        Cursor c=db.rawQuery("SELECT * FROM "+"test2",null);
        String idd=""+c.getCount();
      //  Toast.makeText(this,""+c.getCount(),Toast.LENGTH_SHORT).show();
    }
    public void goback(View V){
        finish();
    }
    public void add(View v){
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
        Intent i = new Intent();
        i.setClass(this,Main3Activity.class);
        i.putExtra("edit_event",event);
        startActivity(i);
        finish();
    }
    private void addData(String list_id,String money,String name,String note,String datestart){
        ContentValues cv=new ContentValues(5);
        cv.put("list_id",list_id);
        cv.put("money",money);
        cv.put("name",name);
        cv.put("note",note);
        cv.put("datestart",datestart);
        db.insert("test2",null,cv) ;
    }

}