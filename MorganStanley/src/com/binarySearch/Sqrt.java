package com.binarySearch;

public class Sqrt {

    public int mySqrt(int x) {
        long low = 1;
        long high = x ;

        while(low <= high ){

            long mid = ( low + high) / 2;
            long midvalue = mid * mid ;

            if( x == midvalue){
                return (int)mid;
            }
            if(x > midvalue){
                low = mid + 1;
            }else{
                high = mid - 1;
            }

        }

        return (int)high;
    }

    public static void main(String[] args){
        System.out.println(new Sqrt().mySqrt(144));
    }
}
