package Concurrency.MultipleThreadsAndSynchronization;

public class Main {

    public static void main(String[] args) {

        Countdown cd = new Countdown();

        CountdownThread t1 = new CountdownThread(cd);
        t1.setName("Thread 1");

        CountdownThread t2 = new CountdownThread(cd);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
