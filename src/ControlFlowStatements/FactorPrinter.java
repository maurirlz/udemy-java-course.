package ControlFlowStatements;

public class FactorPrinter {
    public static void main(String[] args) {

    }

    public static void printFactors(int number) {
        if (number < 1) {

            System.out.println("Invalid Value");
        }
        else {
            for(int i=1; i<number/1.9999999; i++) {
                if (number % i == 0) {

                    System.out.println(i);
                }
            }
            System.out.println(number);
        }
    }
}
