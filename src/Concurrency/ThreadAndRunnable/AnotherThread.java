package Concurrency.ThreadAndRunnable;

import static Concurrency.ThreadAndRunnable.ThreadColor.ANSI_CYAN;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_CYAN + "Hello from " + currentThread().getName());
        try {

            Thread.sleep(3000);
        } catch (InterruptedException e) {

            System.out.println(ANSI_CYAN + "Another thread woke me up.");
            return;
        }

        System.out.println(ANSI_CYAN + "Three seconds have passed and I am awake.");
    }
}
