package com.sumer.loan.smloan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kjb on 2016-11-23.
 */

public class Act_cal extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_cal);

        //cal_cnt_txtv, cal_mem_txtv

        TextView cal_cnt_txtv=(TextView)findViewById(R.id.cal_cnt_txtv);
        TextView cal_mem_txtv=(TextView)findViewById(R.id.cal_mem_txtv);

        Intent intent=getIntent();
        int main_cnt=intent.getIntExtra("main_cnt", -1);
        String[] list_mem=intent.getStringArrayExtra("list_mem");

        cal_cnt_txtv.setText("몇차 수 : "+main_cnt);
        cal_mem_txtv.setText("맴버 수 : "+list_mem.length);

        ArrayList<Bean_stage> stageList=new ArrayList<>();
        ArrayList<Bean_person> personList = null;
        for(int i=0;i<main_cnt;i++){
            personList=new ArrayList<>();
            for(int j=0;j<list_mem.length;j++){
                Bean_person bean_person=new Bean_person(list_mem[j]);
                personList.add(bean_person);
                //Toast.makeText(this,j+""+bean_person.getName(),Toast.LENGTH_SHORT).show();
            }
            Bean_stage bean_stage=new Bean_stage(personList);
            stageList.add(bean_stage);
        }

        /*for(int i=0;i<stageList.size();i++){
            Toast.makeText(Act_cal.this,i+" stageList.size : "+stageList.size()+" / personList.name : "+stageList.get(0).getPersonList().get(i).getName(),Toast.LENGTH_SHORT).show();
        }*/

        /*
        ListView listView=(ListView)findViewById(R.id.cal_listv);
        listView.setAdapter(new MyAdapter(stageList,listViewList));
        Log.i("listView.getHeight ( cal_listv ) ",listView.getHeight()+"");
        Log.i("listView.getDividerHeight() ( cal_listv ) ",listView.getDividerHeight()+"");
        */

        ExpandableListView listView=(ExpandableListView)findViewById(R.id.cal_exListv);
        listView.setAdapter(new ExAdapter(stageList));



    }
}
