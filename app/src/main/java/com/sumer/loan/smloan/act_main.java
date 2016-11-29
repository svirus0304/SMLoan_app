package com.sumer.loan.smloan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class Act_main extends AppCompatActivity {
    NumberPicker main_cnt_numpicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_main);

        main_cnt_numpicker=(NumberPicker)findViewById(R.id.main_cnt_numpicker);
        main_cnt_numpicker.setMinValue(1);
        main_cnt_numpicker.setMaxValue(10);
        main_cnt_numpicker.setWrapSelectorWheel(false);

        Button main_btn_ok=(Button)findViewById(R.id.main_btn_ok);
        main_btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int main_cnt=main_cnt_numpicker.getValue();

                EditText main_mem_txt=(EditText)findViewById(R.id.main_mem_txt);
                String main_mem=main_mem_txt.getText().toString();

                String[] list_mem=main_mem.split(" ");

                Intent intent=new Intent(Act_main.this,Act_cal.class);
                intent.putExtra("main_cnt",main_cnt);
                intent.putExtra("list_mem",list_mem);
                startActivity(intent);

            }
        });
    }
}
