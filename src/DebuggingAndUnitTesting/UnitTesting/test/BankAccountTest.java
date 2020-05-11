package DebuggingAndUnitTesting.UnitTesting.test;


import DebuggingAndUnitTesting.UnitTesting.BankAccount;
import ObjectOrientedProgramming.ClassesObjectsConstructors.Inheritance.Executable;
import org.junit.jupiter.api.*;

import javax.swing.plaf.IconUIResource;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private static int count = 0;

    @BeforeAll
    public static void beforeClass() {

        System.out.println("this executes before any test cases. Count = " + count);
    }

    @BeforeEach
    public void setup() {
        account = new BankAccount("Mauricio", "Benitez", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Test
    void deposit() throws Exception {
        double balance = account.deposit(200.00, true);

        /*
        * First argument on assertEquals: expected result.
        * Second argument: actual value we are testing.
        * Third argument: delta, which is what kind of variation between the results are acceptable / doesn't fail the test.
        */

        assertEquals(1200, balance, 0);
    }

    @Test
    void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test
    public void withdraw_notBranch() throws Exception {

        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(600.00, false)
        );
    }

    @Test
    void getBalance_deposit() throws Exception {
        account.deposit(200.00, true);

        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    void getBalance_withdraw() throws Exception {
        account.withdraw(200.00, true);

        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {

        assertTrue(account.isChecking(), "The account is NOT a checking account.");
    }

    @AfterAll
    public static void afterClass() {
        count++;
        System.out.println("This executes after any test cases. Count = " + count);
    }

    @AfterEach
    public void teardown() {
        count++;
        System.out.println("Count = " + count) ;
    }

//    @Test
//    public void dummyTest() {
//        assertEquals(20, 21);
//    }
}