package com.sumer.loan.smloan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import org.w3c.dom.Text;

public class act_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_main);

        Button main_btn_ok=(Button)findViewById(R.id.main_btn_ok);
        main_btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberPicker main_cnt_numpicker=(NumberPicker)findViewById(R.id.main_cnt_numpicker);
                int main_cnt=(int)main_cnt_numpicker.getValue();

                EditText main_mem_txt=(EditText)findViewById(R.id.main_mem_txt);
                String main_mem=main_mem_txt.getText().toString();

                Intent intent=new Intent(act_main.this,act_cal.class);
                intent.putExtra("main_cnt",main_cnt);
                intent.putExtra("main_mem",main_mem);
                startActivity(intent);

            }
        });
    }
}
