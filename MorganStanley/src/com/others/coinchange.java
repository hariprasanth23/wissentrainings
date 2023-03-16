package com.others;

import java.util.Arrays;

public class coinchange {

    public int coinChange(int[] coins, int amount) {

        if(amount ==0){
            return 0;
        }

        if(coins == null || coins.length==0 || amount<0){
            return -1;
        }

        int[] dp = new int[amount];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int c:coins){
            for(int i=c;i<=amount;i++){
                if(dp[i-c] != Integer.MAX_VALUE){
                    dp[i]= Math.min(dp[i],dp[i-c]+1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args){

        System.out.println(new coinchange().coinChange(new int[]{1,2,5},11));
    }
}
