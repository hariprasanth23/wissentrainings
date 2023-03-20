package com.singletonDesignPattern;

import java.util.Arrays;
import java.util.List;

public class farthestfromzero {
    public static void main(String[] args){

        int[] A= new int[]{2,4,5,3,1,6};
        int N=3;
        int[][] Arr= new int[][]{{1,6},{2,4},{3,3}};
        for(int i=0;i<Arr.length;i++){
            System.out.println(""+Arr[i][0]+"---"+Arr[i][1]);
            solve(N,A,Arr[i][0],Arr[i][1]);
        }

    }

    static int solve(int N,int[] A,int L,int R){
        List<Integer> arrayList =
                Arrays.stream(A).boxed().toList();
        List<Integer> subList = arrayList.subList(L-1,R).stream()
                .sorted().toList();
        int median ;
        if(subList.size() % 2 ==0)
        {
            median = subList.get(subList.size()/2 -1 ) +  subList.get(subList.size()/2 );
            median = median /2;
        }else{
            median = subList.get(subList.size()/2);
        }
        return median;
    }
}
