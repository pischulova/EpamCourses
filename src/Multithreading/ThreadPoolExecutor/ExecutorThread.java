package Multithreading.ThreadPoolExecutor;

import java.util.concurrent.BlockingQueue;

/**
 * Created by А on 27.11.14.
 */
public class ExecutorThread extends Thread {
    Runnable task;
    BlockingQueue queue;
    volatile int completedTasks;
    private boolean isCurrentTaskDone = false;

    public ExecutorThread(BlockingQueue queue) {
        this.queue = queue;
        completedTasks = 0;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                task = (Runnable)queue.take();
                isCurrentTaskDone = false;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            task.run();
            isCurrentTaskDone = true;
            completedTasks++;
        }
    }

    public boolean isCurrentTaskDone() {
        return isCurrentTaskDone;
    }
}
