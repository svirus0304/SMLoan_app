package com.sumer.loan.smloan;

import java.util.ArrayList;

/**
 * Created by kjb on 2016-11-24.
 */

public class Bean_stage {
    String place;
    String payer;
    int bill;
    boolean treatYN;
    ArrayList<Bean_person> personList;

    public Bean_stage(ArrayList<Bean_person> personList){
        this.place="";
        this.payer=null;
        this.bill=0;
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

    public boolean isTreatYN() {
        return treatYN;
    }

    public void setTreatYN(boolean treatYN) {
        this.treatYN = treatYN;
    }

    public ArrayList<Bean_person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Bean_person> personList) {
        this.personList = personList;
    }


}
