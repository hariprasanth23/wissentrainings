package com.others;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1){
            return nums;
        }

        int n=nums.length;
        int[] result = new int[n-k+1];
        for(int i=0;i<result.length;i++){
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList()).subList(i,i+k)
                    .stream().sorted().collect(Collectors.toList());

            result[i]=list.get(list.size()-1);
        }
        return result;
    }

    public static void main(String[] args){
         new SlidingWindowMaximum().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);

         String str = "aleetcode";
         for(int i=0;i<str.length();i++){
             int ch = str.charAt(i)-'a';
             System.out.println(ch);
         }

    }
}
