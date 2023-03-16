package com.other;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lexographicalString {
    public static void main(String[] args){
        String str = "abaacbac";
        char[] ch = str.toCharArray();
        int begin = ch.length-1;
        int end = 1;
        boolean lexoGrahp = false;

        for(int i=0;i<ch.length;i++){
            System.out.print(ch[i]);
        }
        System.out.println();

        for(int i=begin;i>=end;i--){
            int c1 = ch[i];
            int c2 = ch[i-1];
            if(c1<c2){
                char ch1 = ch[i];
                ch[i] = ch[i-1];
                ch[i-1] = ch1;
                System.out.print("i--->"+i+"   ");
            }

            for(int j=0;j<ch.length;j++){
                System.out.print(ch[j]);
            }
            System.out.println();
        }

        for(int i=0;i<ch.length;i++){
            System.out.print(ch[i]);
        }
        System.out.println();

    }
}
