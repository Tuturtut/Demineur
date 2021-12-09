package com.main;

import java.util.Arrays;

public class test {


    public static int otherMethod(int [] tab){
        return 3;
    }

    public static void main(String[] args) {
        int [] test = {4, 5};
        int [] test2 = test.clone();
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(test2));
        System.out.println();
        test[1] = 2;
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(test2));


    }
}
