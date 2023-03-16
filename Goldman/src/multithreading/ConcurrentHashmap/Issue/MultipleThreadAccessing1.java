package multithreading.ConcurrentHashmap.Issue;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class MultipleThreadAccessing1 {
    private static Map<String, String> map = new HashMap<>();
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();

        latch.countDown();

        Thread.sleep(2000);
        System.out.println(map.get("key 1"));
    }

    private static Runnable t1 = new Runnable() {
        public void run() {
            try {
                latch.await();
                System.out.println("Thread 1 starts at "+ Instant.now());
                map.put("key 1", "value 1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private static Runnable t2 = new Runnable() {
        public void run() {
            try {
                latch.await();
                System.out.println("Thread 2 starts at "+ Instant.now());
                map.put("key 1", "value 2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private static Runnable t3 = new Runnable() {
        public void run() {
            try {
                latch.await();
                System.out.println("Thread 3 starts at "+ Instant.now());
                map.put("key 1", "value 3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private static Runnable t4 = new Runnable() {
        public void run() {
            try {
                latch.await();
                System.out.println("Thread 4 starts at "+ Instant.now());
                map.put("key 1", "value 4");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
