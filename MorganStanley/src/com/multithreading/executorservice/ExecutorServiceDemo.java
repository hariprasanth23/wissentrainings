package com.multithreading.executorservice;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    static class Task implements Runnable{
        int i;
        Task(int i){
            this.i=i;
        }
        public void run(){
            System.out.println(" Thread from Task class"+ i);
        }
    }

    public static void normalMethodCall(){
        for(int i=0;i<10;i++){
            Thread thread = new Thread(new Task(i));
            thread.start();
        }
    }

    public static void executorMethod(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            executorService.submit(new Task(i));
        }
    }


    public static void main(String[] args){

        //normalMethodCall();
        executorMethod();

    }
}
