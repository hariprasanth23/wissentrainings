package multithreading.semaphore.ProducerConsumerProblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Item{

}


public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);

        final Runnable Producer = () ->{
//            while(true){
//                try {
//                    queue.put(createItem());
//
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//          }
//           }
        };

        new Thread(Producer).start();
        new Thread(Producer).start();

        final Runnable Consumer = () ->{
          while(true){
              Item i;
              try {
                  i = queue.take();
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
            //  process(i);
          }
        };

        new Thread(Consumer).start();
        new Thread(Consumer).start();

        Thread.sleep(1000);
    }
}
