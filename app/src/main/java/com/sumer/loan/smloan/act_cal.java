package com.sumer.loan.smloan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

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
        String[] main_mem=intent.getStringArrayExtra("list_mem");

        cal_cnt_txtv.setText("몇차 수 : "+main_cnt);
        cal_mem_txtv.setText("맴버 수 : "+main_mem.length);

        ArrayList<Bean_stage> stageList=new ArrayList<>();
        for(int i=0;i<main_cnt;i++){

            ArrayList<Bean_person> personList=new ArrayList<>();
            for(int j=0;j<main_mem.length;j++){
                Bean_person bean_person=new Bean_person(main_mem[j]);
                personList.add(bean_person);
            }
            Bean_stage bean_stage=new Bean_stage("","",0,personList);
            stageList.add(bean_stage);
        }


        ListView listView=(ListView)findViewById(R.id.cal_listv);
        listView.setAdapter(new MyAdapter(stageList));

    }
}
