package com.example.mark1.newapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private DatePicker datePicker;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView txv = (TextView)findViewById(R.id.eventD);
        EditText tmp=findViewById(R.id.editCost);
        tmp.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
        Intent i = this.getIntent();
        //取得傳遞過來的資料
        String name = i.getStringExtra("edit_event");
        txv.setText(name);
        db=openOrCreateDatabase("testdb2", Context.MODE_PRIVATE,null);
        String createTable="CREATE TABLE IF NOT EXISTS "+"test2"+"("
                + "list_id VARCHAR(32), "
                +"money VARCHAR(16), "
                +"name VARCHAR(64),"
                +"note VARCHAR(64),"
                +"datestart VARCHAR(16)"
                + ")";
        db.execSQL(createTable);
    }
    public void onSave(View V){
        EditText cost = (EditText) findViewById(R.id.editCost);
        EditText note = (EditText) findViewById(R.id.editNote);
        TextView event = (TextView)findViewById(R.id.eventD);
        String strEvent = event.getText().toString();
        String strCost = cost.getText().toString();
        String strNote = note.getText().toString();
        datePicker = (DatePicker)findViewById(R.id.DatePicker);
        //Bundle bagCost = new Bundle();
        //Bundle bagNote = new Bundle();
        //bagCost.putString("cost",strCost);
        //bagNote.putString("note",strNote);
        int year = datePicker.getYear();
        int month = datePicker.getMonth()+1;
        int day = datePicker.getDayOfMonth();
        String tmp = "10";
        String month2 = month+"";
        if(month<10){
            month2 = "0"+ month;
        }
        String tmp2 = "10";
        String day2 = day+"";
        if(day<10){
            day2 = "0"+ day;
        }
        String date = year +""+ month2 + day2;
      //  Toast.makeText(this,"EVENT"+ strEvent +"COST:"+strCost+" NOTE:"+ strNote+ " DATE:"+date+" ",Toast.LENGTH_SHORT).show();


        //Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();


        Cursor c=db.rawQuery("SELECT * FROM "+"test2",null);
        String idd=""+c.getCount();
        if(c.getCount()==0){ addData(idd,"0","breakfast","","20180101");idd=""+c.getCount();
            addData(idd,"0","lunch","","20180101");idd=""+c.getCount();
            addData(idd,"0","dinner","","20180101");idd=""+c.getCount();
            addData(idd,"0","clothing","","20180101");idd=""+c.getCount();
            addData(idd,"0","traffic","","20180101");idd=""+c.getCount();
            addData(idd,"0","med","","20180101");idd=""+c.getCount();
            addData(idd,"0","drink","","20180101");idd=""+c.getCount();
            addData(idd,"0","livings","","20180101");idd=""+c.getCount();
            addData(idd,"0","entertainment","","20180101");idd=""+c.getCount();
            addData(idd,"0","3c","","20180101");idd=""+c.getCount();
            addData(idd,"0","others","","20180101");idd=""+c.getCount();
        }
        addData(idd,strCost,strEvent,strNote,date); //storing data complete
        //Toast.makeText(this,c.getCount()+" data",Toast.LENGTH_SHORT).show();
        //Intent i = new Intent();




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

