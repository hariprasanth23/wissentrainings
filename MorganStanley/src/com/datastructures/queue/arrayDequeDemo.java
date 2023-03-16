package com.datastructures.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class arrayDequeDemo {

    public static void main(String[] args){

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.clear();
        deque.addLast(30);
        deque.addLast(40);

        System.out.println(deque);

        deque.removeFirst();
        deque.addFirst(10);
        deque.addFirst(10);
        deque.addFirst(10);
        deque.removeFirstOccurrence(10);

        System.out.println(deque);


    }
}
