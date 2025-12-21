public class WorkerThread implements Runnable {
    private final int taskId;

    public WorkerThread(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is performing task: " + taskId);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Task Interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        System.out.println(Thread.currentThread().getName() + " finished task: " + taskId);
    }
}
