package Concurrency.ThreadAndRunnable;

public class Main {

    public static void main(String[] args) {

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread!");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("anotherThread");
        anotherThread.start();

        new Thread(() -> System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class thread.")).start();

        Thread myRunnableThread = new Thread(new MyRunnable() {

            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class's implementation of run()");

                try {

                    anotherThread.join(4000); // This makes it that MyRunnableThread will wait for anotherThread to die.
                    System.out.println(ThreadColor.ANSI_GREEN + "AnotherThread terminated or timed out., so I'm running again.");
                } catch (InterruptedException e) {

                    System.out.println(ThreadColor.ANSI_GREEN + "I couldn't wait after all, I was interrupted,.");
                }
            }
        });

        myRunnableThread.start();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again, from the main thread.");
    }
}
