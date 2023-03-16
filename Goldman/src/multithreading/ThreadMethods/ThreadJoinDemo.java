package multithreading.ThreadMethods;
class ThreadJoin extends Thread{
    public void run(){
        for( int i =0;i<5;i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(" Thread Join ");
        }
    }
}
public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
        threadJoin.start();
        threadJoin.join();
        for( int i =0;i<5;i++){
            System.out.println(" Thread Join Demo");
        }
    }
}
