package com.sumer.loan.smloan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by kjb on 2016-11-29.
 */

public class MyAdapter_person extends BaseAdapter {
    ArrayList<Bean_person> personList;

    public MyAdapter_person(ArrayList<Bean_person> personList){
        this.personList=personList;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int finalPosition=position;
        final View finalConvertView=convertView;

        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.lay_person,parent,false);
        }

        TextView person_name=(TextView)convertView.findViewById(R.id.person_name);
        final CheckBox person_attendYN=(CheckBox)convertView.findViewById(R.id.person_attendYN);
        Spinner person_deductYN=(Spinner)convertView.findViewById(R.id.person_deductYN);
        EditText person_deductAmt=(EditText)convertView.findViewById(R.id.person_deductAmt);
        TextView person_payAmt=(TextView)convertView.findViewById(R.id.person_payAmt);

        person_name.setText(personList.get(position).getName());
        //참석 이벤트
        person_attendYN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(person_attendYN.isChecked()){//참석시
                    personList.get(finalPosition).setAttendYN(true);
                    Toast.makeText(finalConvertView.getContext(),"personList.attendYN : "+personList.get(finalPosition).isAttendYN(),Toast.LENGTH_SHORT);
                }else{
                    personList.get(finalPosition).setAttendYN(false);
                }
            }
        });

        //공제 스피너, 이벤트


        return convertView;
    }



}
