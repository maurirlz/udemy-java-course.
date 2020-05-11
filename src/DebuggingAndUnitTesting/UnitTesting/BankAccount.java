package DebuggingAndUnitTesting.UnitTesting;

public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public BankAccount(String firstName, String lastName, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    // branch argument is true if the customer is performing the transaction
    // at a branch, with a teller
    // it is false if the customer is performing the t ransaction at an ATM.

    public double deposit(double amount, boolean branch) {

        balance += amount;
        return balance;
    }

    // branch argument is true if the customer is performing the transaction
    // at a branch, with a teller
    // it is false if the customer is performing the t ransaction at an ATM.

    public double withdraw(double amount, boolean branch) {

        if (!branch && amount > 500.00) {
            throw new IllegalArgumentException();
        }

        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    // more methods that use firstName, lastName, and perform other functions.

    public boolean isChecking() {

        return accountType == CHECKING;
    }

    public boolean isSavings() {

        return accountType == SAVINGS;
    }
}
