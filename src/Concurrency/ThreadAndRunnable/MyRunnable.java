package Concurrency.ThreadAndRunnable;

public class MyRunnable implements Runnable {


    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_GREEN + "Hello from MyRunnable's implementation of run()");
    }
}
