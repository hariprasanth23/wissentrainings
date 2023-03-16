package gfg;

import java.util.Arrays;

public class EqualNumberofvalues {
    public static void main(String[] args){
        String str="102100211";

        int count = 0;

        for(int i=0;i<str.length()-2;i++){
            String temp =str.substring(i,i+3);
            int Zero = (int) Arrays.stream(temp.split("")).filter(j->j.equals("0")).count();
            int One = (int) Arrays.stream(temp.split("")).filter(j->j.equals("1")).count();
            int Two = (int) Arrays.stream(temp.split("")).filter(j->j.equals("2")).count();

            if(Zero == One && One == Two){
                count++;
            }

//            if()

        }

        System.out.println(count);
    }
}
