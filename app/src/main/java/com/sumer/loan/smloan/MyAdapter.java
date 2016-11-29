package com.sumer.loan.smloan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kjb on 2016-11-24.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Bean_stage> stageList;

    public MyAdapter(ArrayList<Bean_stage> stageList){
        this.stageList = stageList;
    }

    @Override
    public int getCount() {
        return stageList.size();
    }

    @Override
    public Object getItem(int position) {
        return stageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int finalPosition = position;
        final View finalConvertView = convertView;

        if (convertView==null) {
            LayoutInflater inflater=(LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lay_stage,parent,false);
        }

        TextView stage_idx=(TextView)convertView.findViewById(R.id.stage_idx);
        EditText stage_name=(EditText)convertView.findViewById(R.id.stage_name);
        Spinner stage_payer=(Spinner)convertView.findViewById(R.id.stage_payer);
        final Switch stage_treatYN=(Switch)convertView.findViewById(R.id.stage_treatYN);

        stage_idx.setText((position+1)+"차");
        //switch
        /*
        ArrayList<String> entries =  new ArrayList<String>(Arrays.asList("List Item A", "List Item B"));
        ArrayAdapter<String> arrAdapt = new ArrayAdapter<String>(this, R.layout.list_item, entries);

        arrAdapt.add("List Item C");
        arrAdapt.notifyDataSetChanged();
         */
        ArrayList<String> drinkers=new ArrayList<String>(Arrays.asList("(결제자)"));
        for(int i = 0; i< stageList.get(position).getPersonList().size(); i++){
            drinkers.add(stageList.get(position).getPersonList().get(i).getName());
        }

        /*for(int i=0;i<drinkers.size();i++){
            Toast.makeText(convertView.getContext(), i+" : "+drinkers.get(i),Toast.LENGTH_SHORT).show();
            if(i==10){
                break;
            }
        }*/

        ArrayAdapter<String> arrAdapt=new ArrayAdapter<String>(convertView.getContext(),android.R.layout.simple_spinner_dropdown_item,drinkers);
        stage_payer.setAdapter(arrAdapt);

        stage_treatYN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stage_treatYN.isChecked()){
                    stage_treatYN.setText("쏨");
                    stage_treatYN.setTextSize(15);
                }else{
                    stage_treatYN.setText("안쏨");
                    stage_treatYN.setTextSize(10);
                }
            }
        });

        for(int i=0;i<stageList.size();i++){
            for(int j=0;j<stageList.get(i).getPersonList().size();j++){
                Toast.makeText(convertView.getContext(),i+"-"+j+" stageList.size : "+stageList.size()+" / personList.name : "+stageList.get(i).getPersonList().get(j).getName(),Toast.LENGTH_SHORT).show();
            }
        }

        MyAdapter_person adapter=new MyAdapter_person(stageList.get(position).getPersonList());
        ListView listView=(ListView)convertView.findViewById(R.id.stage_listv);
        listView.setAdapter(adapter);

        return convertView;
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    public void oneStageCalculate(Bean_stage bean_stage){
        ArrayList<Bean_person> personList=bean_stage.getPersonList();
        String payer=bean_stage.getPayer();
        int bill=bean_stage.getBill();
        int attendCNT=0;
        int deductCNT=0;
        int deductAMT=0;

        for(int i=0;i<personList.size();i++){//참석자수, 공제자수,공제금액 구하기
            if(personList.get(i).isAttendYN()){
                attendCNT++;
            }
            if(personList.get(i).isDeductYN()){
                deductCNT++;
                deductAMT+=personList.get(i).getDeduct_amt();
            }
        }

        if(bean_stage.isTreatYN()){//1 쏨일때
            for(int i=0;i<personList.size();i++){
                if(personList.get(i).getName().equals(payer)){//1-1 결제자가 bill원
                    personList.get(i).setPay_amt(bill);
                }else{
                    personList.get(i).setPay_amt(0);//1-2 나머지 0원
                }
            }
        }else{//2 쏨 아닐때
            for(int i=0;i<personList.size();i++){
                if(personList.get(i).isAttendYN()){//2-1 참석시
                    personList.get(i).setPay_amt(bill/attendCNT);//일단 더치페이
                    if(personList.get(i).isDeductYN()){//2-1-1 공제있을시
                        personList.get(i).setPay_amt(personList.get(i).getPay_amt()-personList.get(i).getDeduct_amt());//더치페이-공제금액
                    }else{//2-1-2 공제없을시
                        personList.get(i).setPay_amt(personList.get(i).getPay_amt()+(deductAMT/(attendCNT-deductCNT)));//더치페이+(공제금액/공제없는 참석자수)
                    }
                }else{//2-2 불참시
                    personList.get(i).setPay_amt(0);//2-2-1 0원
                }
            }
        }
    }
}
