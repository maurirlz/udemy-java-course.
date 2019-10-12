package ControlFlowStatements.ReadingInput;

import java.util.Scanner;

public class ReadingInputChallenge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int acum = 0;

        for (int i = 0; i < 10 ; i++) {

            System.out.println("Enter number #" + (i+1));

            if (sc.hasNextInt()) {

                acum += sc.nextInt();
            } else {
                i--;
                System.out.println("Invalid  Number");
            }
            sc.nextLine();
        }
        sc.close();
        System.out.println("Sum of all 10 numbers = " + acum);

    }
}
