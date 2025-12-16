class MyThread implements Runnable{
    @Override
    public void run(){
          for (int i = 0; i < 5; i++) {
                System.out.println("Runnable " + Thread.currentThread().getId() + " is running: " + i);
                try {
                    Thread.sleep(500); // Pause execution for 500 milliseconds
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
         }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Runnable runnable1 = new MyThread();
        

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable1);

        thread1.start();
        thread2.start();
    }
}
