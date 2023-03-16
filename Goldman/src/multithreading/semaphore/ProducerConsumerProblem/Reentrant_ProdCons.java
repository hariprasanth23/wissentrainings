package multithreading.semaphore.ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Reentrant_ProdCons {

    public static void main(String[] args) {

        Queue<Integer> queue=new LinkedList<>();
        ReentrantLock lock=new ReentrantLock();
        Condition con=lock.newCondition();
        final int size = 5;

        new Producer(lock, con, queue, size).start();
        new Consumer(lock, con, queue).start();

    }

}


class Producer extends Thread{

    ReentrantLock  lock;
    Condition con;
    Queue<Integer> queue;
    int size;

    public Producer(ReentrantLock lock, Condition con, Queue<Integer> queue, int size) {
        this.lock = lock;
        this.con = con;
        this.queue = queue;
        this.size=size;
    }


    @Override
    public void run(){
        for(int i=0;i<10;i++){
            lock.lock();
            while(queue.size()==size){
                try {
                    con.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            queue.add(i);
            System.out.println("Produced : "+i);
            con.signal();
            lock.unlock();
        }
    }

}

class Consumer extends Thread{


    ReentrantLock lock;
    Condition con;
    Queue<Integer> queue;


    public Consumer(ReentrantLock lock, Condition con, Queue<Integer> queue) {
        this.lock = lock;
        this.con = con;
        this.queue = queue;
    }

    public void run(){
        for(int i=0;i<10;i++){
            lock.lock();
            while(queue.size()<1){
                try {
                    con.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Consumed : "+queue.remove());
            con.signal();
            lock.unlock();
        }
    }
}


