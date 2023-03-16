package multithreading.priority;
class MyThread extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(" MyThread ");
        }
    }
}
public class ThreadPriorityDemo {
    public static void main(String[] args){

        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(9);
        MyThread myThread = new MyThread();
        System.out.println(Thread.currentThread().getPriority());

    }
}
