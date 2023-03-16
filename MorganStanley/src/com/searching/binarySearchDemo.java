package com.searching;

public class binarySearchDemo {
    public static void main(String[] args){

        int[] arr = {1,2,4,5,7,9,11};
        System.out.println( binarySearch(arr,9));


    }

    public static int binarySearch(int[] arr, int numberToFind){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int midposition = ( low + high ) / 2;
            int midvalue = arr[midposition];

            if(midvalue == numberToFind){
                return midposition;
            }

            if(numberToFind < midvalue){
                high = midposition - 1;
            }else{
                low = midposition + 1;
            }

        }

        return -1;
    }
}
