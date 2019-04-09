package com.example.mark1.newapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    CheckBox cb1;
    SQLiteDatabase db;
    ArrayList<CompoundButton> lis=new ArrayList<>();
    ArrayList<CheckBox> chb=new ArrayList<>();
    String nn;
    int[] chk_id;
    private void addData(String list_id,String money,String name,String note,String datestart){
        ContentValues cv=new ContentValues(5);
        cv.put("list_id",list_id);
        cv.put("money",money);
        cv.put("note",note);
        cv.put("name",name);
        cv.put("datestart",datestart);
        db.insert("test2",null,cv) ;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        TextView txv = (TextView)findViewById(R.id.eventD);
        Intent it = this.getIntent();
        //取得傳遞過來的資料
        String name = it.getStringExtra("edit_event");
        nn=name;
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
        int f=0;
        ArrayList<String> st1=new ArrayList<String>();
        ArrayList<String> st2=new ArrayList<String >();
     //   Toast.makeText(this,""+name,Toast.LENGTH_SHORT).show();
        if(c.moveToFirst()) {
            do {
                  if (c.getString(2).equals(name)){
                    st1.add( c.getString(1));
                     st2.add( c.getString(3));
                      f++;}
            } while (c.moveToNext());
        }
        int val = f;
       chk_id = new int[val-1];
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.viewObj);
        boolean tf=false;
        for(int i = 1; i < f ; i++) {
            tf=true;
            cb1 = new CheckBox(this);
           cb1.setText("NOTE:    "+st2.get(i)+"COST:    "+st1.get(i)+"");//st2.get(i)+","+st1.get(i));
           cb1.setId(i);
           chb.add(cb1);
          //  Toast.makeText(this,""+cb1.getId(i),Toast.LENGTH_SHORT).show();
            int a=cb1.getId();
            chk_id[i-1]=a;
            linearLayout.addView(cb1);
       }
       if(tf==true) {
           for (int id : chk_id) {
               CheckBox chk = (CheckBox) findViewById(id);
               chk.setOnCheckedChangeListener(this);
           }
       }

        /*LinearLayout ll = (LinearLayout)findViewById(R.id.viewObj);

        //定义一个RelativeLayout组件
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.RIGHT;

        TextView tv = new TextView(this);
        tv.setText("Hello World");
        tv.setLayoutParams(lp);
        ll.addView( tv );*/
    }
    public void onDelete(View v){
    //   Toast.makeText(this,lis.size()+" data",Toast.LENGTH_SHORT).show();
        if(lis.size()==0)return;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.viewObj);
        db=openOrCreateDatabase("testdb2", Context.MODE_PRIVATE,null);
        String createTable="CREATE TABLE IF NOT EXISTS "+"test2"+"("
                + "list_id VARCHAR(32), "
                +"money VARCHAR(16), "
                +"name VARCHAR(64),"
                +"note VARCHAR(64),"
                +"datestart VARCHAR(16)"
                + ")";
        db.execSQL(createTable);
        ArrayList<String> strr=new ArrayList<String>();//1 3 5
        ArrayList<String> stri=new ArrayList<String>();//all breakfast id
        ArrayList<String> strmon=new ArrayList<String>();
        Cursor c=db.rawQuery("SELECT * FROM "+"test2",null);
        if(c.moveToFirst()) {
            do {
                if (c.getString(2).equals(nn)){
                    stri.add(c.getString(0));
                    strmon.add(c.getString(1));
                }
            } while (c.moveToNext());
        }
       for(int i=0;i<lis.size();i++){
         //Toast.makeText(this,""+lis.get(i).getText()+"asd",Toast.LENGTH_SHORT).show();
        //   Toast.makeText(this,""+lis+"asq",Toast.LENGTH_SHORT).show();
           strr.add(lis.get(i).getId()+"");
         //  db.delete("test2", "list_id" + "= " + lis.get(i).getId(), null);
           linearLayout.removeView(lis.get(i));
       }
       for(int i=0,j=0;i<stri.size();i++){
            if(strr.get(j).equals(i+"")){j++;  db.delete("test2", "list_id" + "= " + stri.get(j), null);}
       }
        //LinearLayout linearLayout = (LinearLayout) findViewById(R.id.viewObj);
        /*int[] id;
        for(int i:){
            if(cb1.isChecked())
                linearLayout.removeView(cb1);
        }*/
    }
    public void goHome(View v){
        finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    if(isChecked)  {lis.add(buttonView);


      //  Toast.makeText(this,"sdf",Toast.LENGTH_SHORT).show();
         }
        else lis.remove(buttonView);
    }
}
