package ArraysJavaListsAutoboxingUnboxing.Autoboxing.Challenge;

import java.util.ArrayList;
import java.util.Objects;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {

        this.name = name;
        this.customers = new ArrayList<>();
    }

    boolean addCustomer(String custumerName, double amount) {

        if (findCustomer(custumerName) == null) {

            customers.add(new Customer(custumerName,amount));
            return true;
        }

        return false;
    }

    boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);

        if (existingCustomer != null) {

            existingCustomer.addTransaction(amount);
            return true;
        }

        return false;
    }

    private Customer findCustomer(String customerName) {

        for (Customer existingCustomer : customers) {

            if (existingCustomer.getName().equals(customerName)) {

                return existingCustomer;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    ArrayList<Customer> getCustomers() {
        return customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return name.equals(branch.name) &&
                Objects.equals(customers, branch.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customers);
    }
}
