package ArraysJavaListsAutoboxingUnboxing.Autoboxing.Challenge;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {

        this.name = name;
        this.transactions = new ArrayList<>();

        if (addTransaction(initialAmount)) {

            System.out.println("Initial transaction successfully added.");
        }
    }

    public Customer(String name) {
        this(name, 0.0d);
    }

    boolean addTransaction(double amount) {

        if (amount > 0.0d) {

            this.transactions.add(amount);
            return true;
        }

        System.out.println("Couldn't add declared amount, must be greater than 0.");
        return false;
    }

    public String getName() {
        return name;
    }

    ArrayList<Double> getTransactions() {
        return transactions;
    }
}
