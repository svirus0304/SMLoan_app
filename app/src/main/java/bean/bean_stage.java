package bean;

import java.util.ArrayList;

/**
 * Created by kjb on 2016-11-24.
 */

public class bean_stage {
    String place;
    String payer;
    int bill;
    ArrayList<bean_person> personList;

    public bean_stage(String place,String payer,int bill,ArrayList<bean_person> personList){
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

    public ArrayList<bean_person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<bean_person> personList) {
        this.personList = personList;
    }
}
