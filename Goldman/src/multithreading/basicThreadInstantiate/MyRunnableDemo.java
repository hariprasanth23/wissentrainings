package multithreading.basicThreadInstantiate;


class MyRunnable implements Runnable{

    public void run() {
        for(int i =0 ; i<5;i++){
            System.out.println(" MyRunnable ");
        }
    }
}
public class MyRunnableDemo {
    public static void main(String[] args){

        MyRunnable r = new MyRunnable();
        Thread thread = new Thread(r);
        thread.start();

        for(int i=0;i<5;i++){
            System.out.println("My Runnable Demo ");
        }
    }
}


