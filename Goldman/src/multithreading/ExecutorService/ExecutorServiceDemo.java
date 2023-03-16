package multithreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ExecutorServiceDemo {
    static class Task implements Runnable{
        public void run(){ }
    }
    public static void main(String[] args){
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(10);

        //task to run after 10 second delay ( only once )
        scheduledExecutorService.schedule(new Task(),10,SECONDS);

        //task to run repeatedly every 10 seconds
        scheduledExecutorService.scheduleAtFixedRate(new Task(),15,10,SECONDS);

        //task to run repeatedly 10 seconds after the previous task completes
        scheduledExecutorService.scheduleWithFixedDelay(new Task(),15,10, SECONDS);
    }
}
