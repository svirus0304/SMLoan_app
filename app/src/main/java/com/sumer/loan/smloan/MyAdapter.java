package com.sumer.loan.smloan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by kjb on 2016-11-24.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Bean_stage> al;

    public MyAdapter(ArrayList<Bean_stage> al){
        this.al=al;
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context=parent.getContext();

        if (convertView==null) {
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lay_cal,parent,false);
        }
        /*
        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
        TextView tvName = (TextView)convertView.findViewById(R.id.textView1);
        TextView tvInfo = (TextView)convertView.findViewById(R.id.textView2);

        Song m = al.get(position);
        iv.setImageResource(m.img);
        tvName.setText(m.title);
        tvInfo.setText(m.artist);
        */

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
