package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        List<Integer> maxArray = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<Integer> maxSumSet = new HashSet<>();

        for(int i=0;i<maxArray.size();i++){
            for(int j=i+1;j<=maxArray.size();j++){
                int maxsum = maxArray.subList(i,j).stream().mapToInt(Integer::valueOf).sum();
                maxSumSet.add(maxsum);
            }
        }

        List<Integer> setToList = maxSumSet.stream().sorted().collect(Collectors.toList());

        return setToList.get(setToList.size()-1);
    }
    public static void main(String[] args){
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
