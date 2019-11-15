package ArraysJavaListsAutoboxingUnboxing.Autoboxing.Challenge;

import java.util.ArrayList;
import java.util.Objects;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {

        this.name = name;
        this.branches = new ArrayList<>();
    }

    boolean createBranch(String branchName) {

        if (findBranch(branchName) == null) {

            this.branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    boolean addCustomerToBranch(String branchName, String customerName, double initialAmount) {

        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {

            return existingBranch.addCustomer(customerName, initialAmount);
        }

        return false;
    }

    boolean addTransactionToExistingCustomer(String branchName, String customerName, double amount) {

        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {

            return existingBranch.addCustomerTransaction(customerName, amount);
        }

        return false;
    }

    boolean listCustomers(String branchName, boolean transactions) {

        Branch desiredBranch = findBranch(branchName);
        if (desiredBranch != null) {

            int count = 1;
            ArrayList<Customer> customersInBranch = desiredBranch.getCustomers();

            System.out.println("Customer details for Branch: " + desiredBranch.getName());
            for (Customer branchCustomer : customersInBranch) {

                System.out.println("Customer name: "+ "[" + count + "]" + branchCustomer.getName());
                if (transactions) {

                    ArrayList<Double> customerTransactions = branchCustomer.getTransactions();
                    int transactionCount = 1;

                    System.out.println("All transactions: ");
                    for (Double customerTransaction : customerTransactions) {

                        System.out.println("["+ transactionCount + "] with an amount of: " + customerTransaction);
                        transactionCount++;
                    }
                }
                count++;
            }
        }

        return false;
    }

    private Branch findBranch(String branchName) {

        for (Branch existingBranch : this.branches) {

            if (existingBranch.getName().equals(branchName)) {

                return existingBranch;
            }
        }

        return null;
    }

    @Deprecated
    private Branch findBranch(Branch desiredBranch) {

        String desiredBranchName = desiredBranch.getName();
        if (desiredBranchName != null) {

            return findBranch(desiredBranchName);
        }

        return null;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return name.equals(bank.name) &&
                branches.equals(bank.branches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, branches);
    }
}
