package com.main;

public class Number {
    public boolean isHide;
    public int val;

    public Number(boolean isHide, int val) {
        this.isHide = isHide;
        this.val = val;
    }

    public char getCharVal(){
        int REDIX=10;//redix 10 is for decimal number, for hexa use redix 16
        return Character.forDigit(val, REDIX);
    }
}
