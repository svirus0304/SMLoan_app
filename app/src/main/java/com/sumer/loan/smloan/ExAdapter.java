package com.sumer.loan.smloan;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kjb on 2016-12-02.
 */

public class ExAdapter extends BaseExpandableListAdapter {
    ArrayList<Bean_stage> stageList;
    ArrayList<Bean_person> personList;
    ViewHolder viewHolder;
    ViewHolderPerson viewHolderPerson;

    public ExAdapter(ArrayList<Bean_stage> stageList){
        this.stageList=stageList;
    }

    @Override
    public int getGroupCount() {
        return stageList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return stageList.get(groupPosition).getPersonList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return stageList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return stageList.get(groupPosition).getPersonList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View v=convertView;
        if(v==null){
            LayoutInflater inflater=(LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.lay_stage,parent,false);

            viewHolder=new ViewHolder();
            viewHolder.stage_idx=(TextView)v.findViewById(R.id.stage_idx);
            viewHolder.stage_name=(EditText)v.findViewById(R.id.stage_name);
            viewHolder.stage_payer=(Spinner)v.findViewById(R.id.stage_payer);
            viewHolder.stage_treatYN=(Switch)v.findViewById(R.id.stage_treatYN);
            //getter, setter 안하는 이유는, 속도를 더 높이기 위해.
            v.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)v.getTag();
        }
        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View v=convertView;
        if(v==null){
            LayoutInflater inflater=(LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.lay_person,parent,false);

            viewHolderPerson=new ViewHolderPerson();
            viewHolderPerson.person_name=(TextView)convertView.findViewById(R.id.person_name);
            viewHolderPerson.person_attendYN=(CheckBox)convertView.findViewById(R.id.person_attendYN);
            viewHolderPerson.person_deductYN=(Spinner)convertView.findViewById(R.id.person_deductYN);
            viewHolderPerson.person_deductAmt=(EditText)convertView.findViewById(R.id.person_deductAmt);
            viewHolderPerson.person_payAmt=(TextView)convertView.findViewById(R.id.person_payAmt);
            v.setTag(viewHolderPerson);
        }else{
            viewHolderPerson=(ViewHolderPerson)v.getTag();
        }

        viewHolderPerson.person_name.setText(stageList.get(groupPosition).getPersonList().get(childPosition).getName());

        return v;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ViewHolder{
        TextView stage_idx;
        EditText stage_name;
        Spinner stage_payer;
        Switch stage_treatYN;
    }
    class ViewHolderPerson{
        TextView person_name;
        CheckBox person_attendYN;
        Spinner person_deductYN;
        EditText person_deductAmt;
        TextView person_payAmt;
    }
}

