package ControlFlowStatements;

public class ForLoop {
    public static void main(String[] args) {

        /*System.out.println("10,000 at 2% interest = " + calculateInterest(10000.0d, 2.0));
        System.out.println("10,000 at 3% interest = " + calculateInterest(10000.0d, 3.0));
        System.out.println("10,000 at 4% interest = " + calculateInterest(10000.0d, 4.0));
        System.out.println("10,000 at 5% interest = " + calculateInterest(10000.0d, 5.0));*/

        for (int interestRate = 2; interestRate < 9; interestRate++) {

            System.out.println("10,000 at " + interestRate + "% = " + String.format("%.2f",calculateInterest(10000.0,interestRate)));
        }

        for (int j = 1; j <= 100; j++) {

            int cont = 0;
            if (isPrime(j)) {

                cont++;
                if (cont == 3) {

                    break;
                }
            }

        }
    }

    public static boolean  isPrime(int n) {

        if (n == 1) {

            return false;
        }
        for (int i = 2; i <= n/2; i++) {

            if (n % i == 0) {

                return false;
            }
        }
        return true;
    }

    public static double calculateInterest(double amount, double interestRate) {

        return (amount * (interestRate / 100d));
    }
}
