package com.datastructures.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class bubbleSortDemo {

    public void bubbleSort(int arr[]){

        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));

    }

    public static void main(String[] args){

        bubbleSortDemo bubbleSortDemo = new bubbleSortDemo();
        bubbleSortDemo.bubbleSort(new int[]{5, 1, 4, 2, 8});

    }
}
