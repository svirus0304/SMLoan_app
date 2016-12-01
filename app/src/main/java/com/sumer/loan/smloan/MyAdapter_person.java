package com.sumer.loan.smloan;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

        /*for(int i=0;i<personList.size();i++){
            Toast.makeText(convertView.getContext(),personList.get(i).getName(),Toast.LENGTH_SHORT).show();
        }*/

        TextView person_name=(TextView)convertView.findViewById(R.id.person_name);
        CheckBox person_attendYN=(CheckBox)convertView.findViewById(R.id.person_attendYN);
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
                    //Toast.makeText(finalConvertView.getContext(),"personList.attendYN : "+personList.get(finalPosition).isAttendYN(),Toast.LENGTH_SHORT).show();
                    Log.i("personList.get(finalPosition).isAttendYN();", personList.get(finalPosition).isAttendYN()+"");
                }else{
                    personList.get(finalPosition).setAttendYN(false);
                    Log.i("personList.get(finalPosition).isAttendYN();", personList.get(finalPosition).isAttendYN()+"");
                }
            }
        });

        //공제 스피너, 이벤트
        ArrayList<String> deductList=new ArrayList<String>(Arrays.asList("공제없음","택시비공제","백수공제"));
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(convertView.getContext(),android.R.layout.simple_spinner_dropdown_item,deductList);
        person_deductYN.setAdapter(arrayAdapter);
        person_deductYN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    personList.get(finalPosition).setDeductYN(false);
                    Log.i("personList.get(finalPosition).isDeductYN();", personList.get(finalPosition).isDeductYN()+"");
                }else{
                    personList.get(finalPosition).setDeductYN(true);
                    Log.i("personList.get(finalPosition).isDeductYN();", personList.get(finalPosition).isDeductYN()+"");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //personList.get(finalPosition).setDeductYN(false);
            }
        });

        return convertView;
    }



}
