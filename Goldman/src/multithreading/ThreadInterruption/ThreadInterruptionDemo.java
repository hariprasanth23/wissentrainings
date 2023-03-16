package multithreading.ThreadInterruption;

class ThreadInterrupt extends Thread{
    public void run(){
        try{
            for(int i=0;i<5;i++){
                System.out.println(" ThreadInterrupt " + i);
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            System.out.println(" I got interrupted ");
        }
    }
}
public class ThreadInterruptionDemo {
    public static void main(String[] args){

        ThreadInterrupt threadInterrupt = new ThreadInterrupt();
        threadInterrupt.start();
        threadInterrupt.interrupt();
        System.out.println(" End of Main Thread");
    }
}
