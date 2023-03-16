package multithreading.CompletableFuture;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableFutureDemo {

    static class Task implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }

    public static void main(String[] args){

    }
}
