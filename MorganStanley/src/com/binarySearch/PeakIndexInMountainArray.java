package com.binarySearch;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1, m;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] < A[m + 1])
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    public static void main(String[] args){
        System.out.println(new PeakIndexInMountainArray().peakIndexInMountainArray(new int[]{0,10,5,2}));
    }


}
