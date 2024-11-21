package thread.executor.reject;

import thread.executor.RunnableTask;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectMainV3 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

        executor.submit(new RunnableTask("task1")); // 0초
        executor.submit(new RunnableTask("task2")); // 1초
        executor.submit(new RunnableTask("task3")); // 1초
        executor.submit(new RunnableTask("task4")); // 0초

        executor.close();
    }
}
