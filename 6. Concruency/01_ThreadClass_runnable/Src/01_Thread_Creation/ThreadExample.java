

class MyThread extends Thread {
    
    @Override
    public void run(){
        for(int i=0;i<5;i++){
             System.out.println("Thread " + Thread.currentThread().getId() + " is running: " + i);
            try {
                Thread.sleep(500); // Pause execution for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}


public class ThreadExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread(); // Create thread instance
        MyThread thread2 = new MyThread(); // Create another thread instance

        thread1.start(); // Start the first thread
        thread2.start(); // Start the second thread
    }
}