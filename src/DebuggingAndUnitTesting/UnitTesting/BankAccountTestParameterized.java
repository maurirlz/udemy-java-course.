package DebuggingAndUnitTesting.UnitTesting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private static BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @BeforeAll
    public static void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {

        return Arrays.asList(new Object[][] {
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.114, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}
        });
    }

    @Test
    public void deposit() throws Exception {
        account.deposit(amount, branch);

        assertEquals(expected, account.getBalance(), 0);
    }
}
