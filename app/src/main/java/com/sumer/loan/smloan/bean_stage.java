package com.sumer.loan.smloan;

import java.util.ArrayList;

/**
 * Created by kjb on 2016-11-24.
 */

public class Bean_stage {
    String place;
    String payer;
    int bill;
    ArrayList<Bean_person> personList;

    public Bean_stage(String place, String payer, int bill, ArrayList<Bean_person> personList){
        this.place=place;
        this.payer=payer;
        this.bill=bill;
        this.personList=personList;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public ArrayList<Bean_person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Bean_person> personList) {
        this.personList = personList;
    }
}
