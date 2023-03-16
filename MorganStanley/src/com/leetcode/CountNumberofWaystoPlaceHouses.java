package com.leetcode;

public class CountNumberofWaystoPlaceHouses {

    public int countHousePlacements(int n) {
        int a = 1, b = 1, c = 2, mod = 1000000007;
        for (int i = 0; i < n; ++i) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return (int)((long) b * b % mod);
    }


    public static void main(String[] args){

       System.out.println( new CountNumberofWaystoPlaceHouses().countHousePlacements(2) );

    }
}
