package Multithreading.ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Создать свой собственный ThreadPoolExecutor
 *
 * Created by А on 27.11.14.
 */
public class MyThreadPool {
    private BlockingQueue<Runnable> tasksQueue;
    private List<ExecutorThread> threadList;
    private int threadsMaxNumber;
    private int queueSize;
    private boolean isShutDown = false;
    private boolean allTasksDone = false;

    public MyThreadPool(int threadsNumber, int queueSize) {
        if (threadsNumber <= 0 || queueSize <= 0)
            throw new IllegalArgumentException();
        this.threadsMaxNumber = threadsNumber;
        this.queueSize = queueSize;

        threadList = new ArrayList<>(threadsNumber);
        tasksQueue = new ArrayBlockingQueue<>(queueSize);
    }

    public Future<?> submit(Runnable task){
        if (task == null)
            throw new NullPointerException();
        RunnableFuture<Void> futureTask = newTaskFor(task, null);
        execute(futureTask);
        return futureTask;
    }

    public <T> Future<T> submit(Callable<T> task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<T> futureTask = newTaskFor(task);
        execute(futureTask);
        return futureTask;
    }

    private <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new FutureTask<T>(runnable, value);
    }

    private <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new FutureTask<T>(callable);
    }

    public void execute(Runnable command) {
        if (tasksQueue.size() < queueSize){
            if (!isShutDown()) {
                tasksQueue.add(command);
                if (threadList.size() < threadsMaxNumber) {
                    createNewThread();
                }
                System.out.println("Queue size: " + tasksQueue.size());
                System.out.println("Thread list size: "+ threadList.size());
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private void createNewThread() {
        ExecutorThread thread = new ExecutorThread(tasksQueue);
        threadList.add(thread);
        thread.start();
    }

    public boolean isShutDown() {
        return isShutDown;
    }

    /** Shuts down ThreadPool immediately after all tasks are done
     */
    public void shutdown() {
        int totalTasks = 0;
        for (ExecutorThread thread : threadList) {
            if (!thread.isInterrupted()) {
                totalTasks += thread.completedTasks;
                thread.interrupt();
            }
        }
        isShutDown = true;
        System.out.println("The pool is shut down. Total tasks executed: " + totalTasks);
    }

    /** Shuts down ThreadPool if all tasks are done or after waiting specified time (timeLimit)
     * whichever happens first
     */
    public void awaitTermination(long timeLimit) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis()-startTime)< timeLimit) {
            if (tasksQueue.isEmpty()) {
                allTasksDone = true;
                for (ExecutorThread thread : threadList) {
                    if (!thread.isCurrentTaskDone()) {
                        allTasksDone = false;
                        break;
                    }
                }
                if (allTasksDone) {
                    shutdown();
                    return;
                }
            }
        } shutdown();
    }
}
