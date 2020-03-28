package Concurrency.Challenges.Challenge1;

import Concurrency.ThreadAndRunnable.ThreadColor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        BankAccount jointAccount = new BankAccount("12345", 1000.00);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable thread1 = new Thread(() -> {

            jointAccount.deposit(300.00);
            System.out.println(ThreadColor.ANSI_RED + "Thread 1 deposited 300.00");
            jointAccount.withdraw(50.00);
            System.out.println(ThreadColor.ANSI_RED + "Thread 1 withdrawed 50.00");
        });

        Runnable thread2 = new Thread(() -> {

            jointAccount.deposit(203.75);
            System.out.println(ThreadColor.ANSI_GREEN + "Thread 2 deposited 203.75");
            jointAccount.withdraw(100.00);
            System.out.println(ThreadColor.ANSI_GREEN + "Thread 2 withdrawed 100.00");
        });

        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.shutdown();

        StringBuilder sb = new StringBuilder().append("Bank account balance: ").append(jointAccount.getBalance());

        System.out.println(sb.toString());
    }
}
