package com.sumer.loan.smloan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by kjb on 2016-11-23.
 */

public class act_cal extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_cal);

        //cal_cnt_txtv, cal_mem_txtv

        TextView cal_cnt_txtv=(TextView)findViewById(R.id.cal_cnt_txtv);
        TextView cal_mem_txtv=(TextView)findViewById(R.id.cal_mem_txtv);

        Intent intent=getIntent();
        String main_cnt=intent.getStringExtra("main_cnt");
        String main_mem=intent.getStringExtra("main_mem");

        cal_cnt_txtv.setText(main_cnt);
        cal_mem_txtv.setText(main_mem);
    }
}
