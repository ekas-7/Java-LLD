import java.util.concurrent.*;


public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i=1;i<=5;i++){
            executorService.submit(new WorkerThread(i));
        }

        executorService.shutdown();
    }
}
