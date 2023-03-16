package com.trial;

import java.util.ArrayList;

public class squareRoot {
    public static void main(String[] args){
        int i = 144;
        ArrayList<Integer> list = new ArrayList<>();
        while(i%2 != 0){
            i=i/2;
            list.add(i);
        }

        System.out.println(list);
    }
}
