package multithreading.priority;

class PriorityThreadDemo extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(" Priority Thread Demo ");
        }
    }
}
public class ThreadPriorityDemo2 {
    public static void main(String[] args){
        PriorityThreadDemo priorityThreadDemo = new PriorityThreadDemo();
        priorityThreadDemo.setPriority(10);
        priorityThreadDemo.start();

        for(int i=0;i<10;i++){
            System.out.println(" ThreadPriorityDemo2 ");
        }

    }
}
