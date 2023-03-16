package multithreading.CallableAndFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class SumCallable implements Callable<Integer>{

    private int input;

    public SumCallable(int input){
        super();
        this.input=input;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        int sum=0;
        for(int i=0;i<input;i++){
            sum = sum + input;
        }
        return sum;
    }
}

public class CallableAndFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> list = new ArrayList<>();

        for(int i=0;i<20;i++){
            Future<Integer> future = executorService.submit(new SumCallable(i));
            list.add(future);
        }


        for(Future f: list){
            System.out.println(f.get(5,TimeUnit.SECONDS));
        }
    }
}
