package com.main;

import java.util.Arrays;

public class test {

    public static int[] modifyData(int[]tab){
        tab = new int[]{3, 2, 1};
        return tab;
    }
    public static int otherMethod(int [] tab){
        return 3;
    }

    public static void main(String[] args) {
        int [] test = {4, 5};
        System.out.println(Arrays.toString(test));
        System.out.println(otherMethod(modifyData(test)));
        System.out.println(Arrays.toString(test));

    }
}
