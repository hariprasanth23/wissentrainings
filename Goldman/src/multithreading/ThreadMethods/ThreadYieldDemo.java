package multithreading.ThreadMethods;
class ThreadYield extends Thread{
    public void run(){
        Thread.yield();
        for( int i =0;i<5;i++){
            System.out.println(" Thread Yield ");
        }
    }
}
public class ThreadYieldDemo {
    public static void main(String[] args){
        ThreadYield threadYield = new ThreadYield();
        threadYield.start();

        for( int i =0;i<5;i++){
            System.out.println(" Thread Yield Demo ");
        }
    }
}
