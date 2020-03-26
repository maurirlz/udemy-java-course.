package Concurrency.ConcurrentPackage;

import Concurrency.ThreadAndRunnable.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static final String EOF = "EOF";

    public static void main(String[] args) {

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(() -> {

            System.out.println(ThreadColor.ANSI_RED + "I'm being printed from the Callable class.");
            return "This is the callable result";
        });

        try {

            System.out.println(future.get());
        } catch (ExecutionException e) {

            System.out.println("Execution exception in main.");
        } catch (InterruptedException e) {

            System.out.println("Thread running the task was interrupted.");
        }

        executorService.shutdown();
    }
}
