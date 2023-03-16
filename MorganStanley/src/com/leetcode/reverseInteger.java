package com.leetcode;

public class reverseInteger {
    public int reveseInt(int num){
        long r = 0;
        while(num != 0){
            r=  r*10  +  num%10;
            num=num/10;
        }
        if(r >= Integer.MIN_VALUE && r<= Integer.MAX_VALUE){
            return (int)r;
        }else{
            return 0;
        }
    }

    public static void main(String[] args){
        System.out.println(new reverseInteger().reveseInt(123));
    }
}
