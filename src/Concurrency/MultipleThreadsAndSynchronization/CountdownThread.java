package Concurrency.MultipleThreadsAndSynchronization;

public class CountdownThread extends Thread {

    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {

        threadCountdown = countdown;
    }

    @Override
    public void run() {

        threadCountdown.doCountdown();
    }
}
