package com.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class MergeSort {

    public static void main(String[] args){

        int[] inputArray = new int[10];
        for(int i=0;i<inputArray.length;i++){
            inputArray[i] = new Random().nextInt(1000);
        }

        System.out.println("Before Sorting");
        System.out.println(Arrays.stream(inputArray).boxed().collect(Collectors.toList()));

        mergeSort(inputArray);

        System.out.println("After Sorting");
        System.out.println(Arrays.stream(inputArray).boxed().collect(Collectors.toList()));
    }

    public static void mergeSort(int[] inputArray){
        int inputLength = inputArray.length;

        if(inputLength<2){
            return;
        }

        int mid = inputLength / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[inputLength - mid];

        for(int i=0;i<mid;i++){
            leftHalf[i] = inputArray[i];
        }

        for(int i=mid ; i<inputLength ; i++){
            rightHalf[i-mid] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray,leftHalf,rightHalf);

    }

    public static void merge(int[] inputArray,int[] leftHalf,int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i=0,j=0,k=0;

        while(i<leftSize && j<rightSize){
            if(leftHalf[i]<=rightHalf[j]){
               inputArray[k]=leftHalf[i];
               i++;
            }else{
                inputArray[k]=rightHalf[j];
                j++;
            }
            k++;
        }

        while(i<leftSize){
            inputArray[k]=leftHalf[i];
            i++;
            k++;
        }

        while(j<rightSize){
            inputArray[k]=rightHalf[j];
            j++;
            k++;
        }


    }



}
