package ControlFlowStatements.ReadingInput;

import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] args) {


        inputThenPrintSumAndAverage();
    }
    public static void inputThenPrintSumAndAverage() {

        Scanner sc = new Scanner(System.in);

        int number;
        int acum = 0,cont=0;
        long avg;

        while (true) {

            System.out.println("Enter number #"+cont);
            if (sc.hasNextInt()) {

                number = sc.nextInt();
                acum += number;
                cont++;

            } else {
                if (cont == 0 && sc.hasNextInt()) {

                    System.out.println("SUM = " + 0 + " AVG = " + 0);
                }

                avg = (Math.round((double) acum / cont));
                System.out.println("SUM = " + acum + " AVG = " + avg);
                break;
            }
        }
        sc.close();
    }
}
