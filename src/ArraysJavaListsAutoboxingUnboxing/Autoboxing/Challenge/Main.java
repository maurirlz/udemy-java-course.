package ArraysJavaListsAutoboxingUnboxing.Autoboxing.Challenge;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public class Main {

    // You job is to create a simple banking application.
    // There should be a Bank class
    // It should have an arraylist of Branches
    // Each Branch should have an arraylist of Customers
    // The Customer class should have an arraylist of Doubles (transactions)
    // Customer:
    // Name, and the ArrayList of doubles.
    // Branch:
    // Need to be able to add a new customer and initial transaction amount.
    // Also needs to add additional transactions for that customer/branch
    // Bank:
    // Add a new branch
    // Add a customer to that branch with initial transaction
    // Add a transaction for an existing customer for that branch
    // Show a list of customers for a particular branch and optionally a list
    // of their transactions
    // Demonstration autoboxing and unboxing in your code
    // Hint: Transactions
    // Add data validation.
    // e.g. check if exists, or does not exist, etc.
    // Think about where you are adding the code to perform certain actions

    private static Scanner stringScanner = new Scanner(System.in);
    private static Scanner numericScanner = new Scanner(System.in);

    public static void main(String[] args) {
        // just use bank instances, not customer or branch. aka bank have to call all the methods of the different classes.

        Bank supervielle = new Bank("Supervielle");
        boolean quit = false;
        byte option;

        System.out.println(printInstructions());

        while (!quit) {
            System.out.println("Enter your choice: ");
            option = numericScanner.nextByte();

            switch (option) {
                case 0:
                    System.out.println(printInstructions());
                    break;
                case 1:
                    createBranch(supervielle);
                    break;
                case 2:
                    addCustomerToBranch(supervielle);
                    break;
                case 3:
                    addTransactionToCustomer(supervielle);
                    break;
                case 4:

                    boolean showTransactions;
                    System.out.println("It's needed to show all transactions? if it's needed, type true, else, type false.");
                    showTransactions = numericScanner.nextBoolean();
                    showListOfCustomersInBranch(supervielle, showTransactions);

                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }

    @NotNull
    private static String printInstructions() {

        final StringBuilder sb;
        sb = new StringBuilder();
        sb.append("\nPress: \n")
                .append("\n\t 0 - To print choice options.")
                .append("\n\t 1 - To create a new branch on this bank.")
                .append("\n\t 2 - To add a customer to an existing branch.")
                .append("\n\t 3 - To add a transaction to an existing customer.")
                .append("\n\t 4 - To show a list of all customers with or without their respective transactions.")
                .append("\n\t 5 - To quit the application.\n");

        return sb.toString();
    }

    private static void createBranch(@NotNull Bank bank) {

        String branchName = askForBranchName();

        if (bank.createBranch(branchName)) {

            bank.createBranch(branchName);
            System.out.println("Branch successfully created.");
        } else {
            System.out.println(" ERROR - Couldn't create the branch with the desired name.");
        }
    }

    private static void addCustomerToBranch(@NotNull Bank bank) {

        boolean firstTransaction = true;

        String desiredBranchName = askForBranchName();
        String customerName = askForCustomerName();
        double initialTransaction = askForDouble(firstTransaction);

        if (bank.addCustomerToBranch(desiredBranchName, customerName, initialTransaction)) {

            bank.addCustomerToBranch(desiredBranchName, customerName, initialTransaction);
            System.out.println("Customer sucessfully added to desired branch.");
        } else {
            System.out.println("ERROR - Couldn't add the desired customer, to the desired branch with the desired amount. (Check values)");
        }
    }

    private static void addTransactionToCustomer(@NotNull Bank bank) {

        String branchName = askForBranchName();
        String customerName = askForCustomerName();
        double amount = askForDouble(false);
        boolean transaction = bank.addTransactionToExistingCustomer(branchName, customerName, amount);

        if (transaction) {
            System.out.println("Transaction added successfully.");
        } else {
            System.out.println("ERROR - Couldn't add desired transaction to customer. (Check values)");
        }
    }

    private static void showListOfCustomersInBranch(@NotNull Bank bank, boolean showTransactions) {

        String branchName = askForBranchName();
        bank.listCustomers(branchName, showTransactions);
    }

    private static String askForBranchName() {

        System.out.println("Please, enter the desired branch name: ");
        return stringScanner.nextLine();
    }

    private static String askForCustomerName() {

        System.out.println("Please, enter the name of the customer: ");
        return stringScanner.nextLine();
    }

    private static double askForDouble(boolean initialTransaction) {
        if (initialTransaction) {

            System.out.println("Please, enter the amount of the initial transaction: ");
            return numericScanner.nextDouble();
        }
        System.out.println("Please, enter the amount of the transaction: ");
        return numericScanner.nextDouble();
    }
}
