package com.sumer.loan.smloan;

/**
 * Created by kjb on 2016-11-24.
 */

public class Bean_person {
    private String name;
    private boolean attendYN;
    private boolean deductYN;
    private int deduct_amt;
    private int pay_amt;

    public Bean_person(String name){
        this.name=name;
        attendYN=true;
        deductYN=false;
        deduct_amt=0;
        pay_amt=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAttendYN() {
        return attendYN;
    }

    public void setAttendYN(boolean attendYN) {
        this.attendYN = attendYN;
        if(!this.attendYN){
            setPay_amt(0);
        }
    }

    public boolean isDeductYN() {
        return deductYN;
    }

    public void setDeductYN(boolean deductYN) {
        this.deductYN = deductYN;
        if(!this.deductYN){
            setDeduct_amt(0);
        }
    }

    public int getDeduct_amt() {
        return deduct_amt;
    }

    public void setDeduct_amt(int deduct_amt) {
        this.deduct_amt = deduct_amt;
        if(this.deduct_amt!=0 && !deductYN){
            setDeduct_amt(0);
        }
    }

    public int getPay_amt() {
        return pay_amt;
    }

    public void setPay_amt(int pay_amt) {
        this.pay_amt = pay_amt;
        if(this.pay_amt!=0 && !attendYN){
            setPay_amt(0);
        }
    }
}
