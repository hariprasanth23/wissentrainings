package multithreading.basicThreadInstantiate;

class MyThread extends Thread{

    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(" MyThread Class ");
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args){

        MyThread myThread = new MyThread();
        myThread.start();
        for(int i=0;i<5;i++){
            System.out.println(" Thread Demo ");
        }
    }
}
