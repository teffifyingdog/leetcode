import java.util.concurrent.*;

public class ThreadTest implements Callable<String>{
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask<>(new ThreadTest());
        ExecutorService service = Executors.newCachedThreadPool();
        ExecutorService service1 = Executors.newFixedThreadPool(1);
        ExecutorService service2 = Executors.newSingleThreadExecutor();
        ExecutorService service3 = Executors.newScheduledThreadPool(1);

        Future<String> submit = service.submit(new ThreadTest());
        try {
            submit.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }
}
