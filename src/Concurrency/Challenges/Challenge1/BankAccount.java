package Concurrency.Challenges.Challenge1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private ReentrantLock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {

        boolean status = false;

        try {

            if (lock.tryLock(1000L, TimeUnit.MILLISECONDS)) {

                try {

                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {

                System.out.println("Couldn't get the lock.");
            }
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println("Status: " + status);
    }

    public void withdraw(double amount) {

        boolean status = false;
        try {

            if (lock.tryLock(1000L, TimeUnit.MILLISECONDS)) {

                try {
                    balance -= amount;
                    status = true;
                } finally {

                    lock.unlock();
                }
            } else {

                System.out.println("Couldn't get the lock.");
            }
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println("Status: " + status);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {


        System.out.println("Account number: " + accountNumber);
    }
}
