package com.leetcode;

public class MinimumAddtoMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }

    public static void main(String[] args){

        System.out.println(new MinimumAddtoMakeParenthesesValid().minAddToMakeValid("()))(("));
    }
}
