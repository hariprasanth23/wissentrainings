package com.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class nextGreaterNode {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,7,4,3,5));
        System.out.println(list);
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); ++i) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i))
            {
                System.out.println("i-->"+i+"<--peek-->"+stack.peek());
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
            System.out.println("i-->"+i+"<--stack-->"+stack.stream().collect(Collectors.toList()));
        }
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
