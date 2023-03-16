package multithreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class semaphoreDemo {

    static class Task implements Runnable{

        Semaphore semaphore;
        int i;

        public Task(Semaphore semaphore, int i) {
            this.semaphore=semaphore;
            this.i=i;
        }

        public void run() {
            semaphore.acquireUninterruptibly();
            System.out.println("Semaphore -->"+i);
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException{

        Semaphore semaphore = new Semaphore(3);

        ExecutorService executorService = Executors.newFixedThreadPool(50);
        IntStream.of(1000,20).forEach(i-> executorService.execute(new Task(semaphore,i)));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

    }
}
