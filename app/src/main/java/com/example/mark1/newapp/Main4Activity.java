package com.example.mark1.newapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Main4Activity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    SQLiteDatabase db;
    SimpleCursorAdapter adapter;
    Cursor cv;
    final String[] FROM=new String[]{"$"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ListView lv=(ListView)findViewById(R.id.dynamic);
    //    lv.setOnItemClickListener(this);

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
      if(c.moveToFirst()){

            String str="";

            int tmp=0;
            int tmp2=0;
            int tmp3=0;
            int tmp4=0;
            int tmp5=0;
            int tmp6=0;
            int tmp7=0;
            do{
                /* <item>Today</item>
        <item>This Month</item>
        <item>Meals</item>
        <item>Clothing</item>
        <item>Traffic</item>
        <item>Entertainment</item>
        <item>Others</item>*/
                Date tmpdate=new Date();
                SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
                String stdate="";
                stdate=simple.format(tmpdate);
                if(c.getString(4).equals(stdate)){
                    str=c.getString(1);
                    int ttmp;
                    ttmp=Integer.parseInt(str);
                    tmp6+=ttmp;
                }
                if(c.getString(2).equals("breakfast")||c.getString(2).equals("lunch")
                        ||c.getString(2).equals("dinner")||c.getString(2).equals("drink")) {

                    str = c.getString(1);
                    int ttmp;
                    ttmp=Integer.parseInt(str);
                    tmp+=ttmp;
                }else if(c.getString(2).equals("clothing")){
                    str = c.getString(1);
                    int ttmp;
                    ttmp=Integer.parseInt(str);
                    tmp2+=ttmp;

                }
                else if(c.getString(2).equals("traffic")){
                    str = c.getString(1);
                    int ttmp;
                    ttmp=Integer.parseInt(str);
                    tmp3+=ttmp;
                }
                else if(c.getString(2).equals("entertainment")){
                    str = c.getString(1);
                    int ttmp;
                    ttmp=Integer.parseInt(str);
                    tmp4+=ttmp;
                }
                else if(c.getString(2).equals("others")||c.getString(2).equals("med")||
                        c.getString(2).equals("livings")||c.getString(2).equals("3c")){
                    str = c.getString(1);
                    int ttmp;
                    ttmp=Integer.parseInt(str);
                    tmp5+=ttmp;
                }
            }while(c.moveToNext());

            TextView txv2=(TextView)findViewById(R.id.btt);////////////////////////////
            txv2.setText(tmp+"");
            TextView txv3= (TextView)findViewById(R.id.btt6);
            txv3.setText(tmp2+"");
            TextView txv4= (TextView)findViewById(R.id.btt5);
            txv4.setText(tmp3+"");
            TextView txv5= (TextView)findViewById(R.id.btt3);
            txv5.setText(tmp4+"");
            TextView txv6= (TextView)findViewById(R.id.btt4);
            txv6.setText(tmp5+"");
            TextView txv7=(TextView)findViewById(R.id.att);
            txv7.setText(tmp6+"");
      }
        cv=requary();
    }
    private Cursor requary(){
        cv=db.rawQuery("SELECT * FROM "+"test2",null);
        return cv;
    }
    public void goback1(View v){

        finish();
    }
ArrayList<String> selected=new ArrayList<>();
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView txv=(TextView) view;
        String item=txv.getText().toString();
        if(selected.contains(item))
            selected.remove(item);
        else selected.add(item);

    }
    private void addData(String list_id,String money,String name,String note,String datestart){
        ContentValues cv=new ContentValues(5);
        cv.put("list_id",list_id);
        cv.put("money",money);
        cv.put("note",note);
        cv.put("name",name);
        cv.put("datestart",datestart);
        db.insert("test2",null,cv) ;
    }
}
