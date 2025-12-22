public class Main{
    public static void main(String[] args) {
        System.out.println("Demonstrating notifyAll():");
        WaitNotifyDemo demoAll = new WaitNotifyDemo();
        Thread waiter1 = new Thread(() -> demoAll.doWait(), "Waiter-1");
        Thread waiter2 = new Thread(() -> demoAll.doWait(), "Waiter-2");
        Thread waiter3 = new Thread(() -> demoAll.doWait(), "Waiter-3");
        waiter1.start();
        waiter2.start();
        waiter3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Thread notifierAll = new Thread(() -> demoAll.doNotifyAll(), "Notifier-All");
        notifierAll.start();
        try {
            waiter1.join();
            waiter2.join();
            waiter3.join();
            notifierAll.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        
    }
}