package com.datastructures.queue;

import java.util.Stack;

public class queueUsingStack {

    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public void enqueue(int x){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int dequeue(){
        if(s1.isEmpty()){
            System.out.println(" Q is Empty");
            System.exit(0);
        }
        int x = s1.peek();
        s1.pop();
        return x;
    }

    public static void main(String[] args){

        queueUsingStack q = new queueUsingStack();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

    }
}
