

public class WaitNotifyDemo {
    private final Object lock = new Object();

    private boolean conditionMet = false;

    public void doWait(){
        synchronized(lock){
            while(!conditionMet){
                try{
                    System.out.println(Thread.currentThread().getName() + " is waiting.");
                    // Wait releases the lock and suspends the thread until notified
                    lock.wait();
                }
                catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " was interrupted.");
                }
            }
        }
    }

    public void doNotify() {
        synchronized (lock) {
            conditionMet = true;
            System.out.println(Thread.currentThread().getName() + " called notify().");
            lock.notify();  // Wakes up one waiting thread (if any)
        }
    }

    public void doNotifyAll() {
        synchronized (lock) {
            conditionMet = true;
            System.out.println(Thread.currentThread().getName() + " called notifyAll().");
            lock.notifyAll();  // Wakes up all waiting threads
        }
    }
}
