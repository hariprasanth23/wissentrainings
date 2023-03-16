package com.others;

import java.util.ArrayDeque;
import java.util.Queue;

public class lru {
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>();
        int queueSize = 4;
        int[] arr = {1,2,3,1,4,5};

        for(int i =0;i<arr.length;i++){

            queue.add(arr[i]);

            if(!queue.contains(arr[i])){
                if(queue.size() == queueSize){
                    queue.remove(0);
                }

            }

        }

        System.out.println(queue);

    }
}
