package ControlFlowStatements;

public class DigitSumChallenge {

    public static void main(String[] args) {

        int number = 350;

        System.out.println("The sum of the total digits of  " + number + " equals = " + sumDigits(number));

    }

    public static int sumDigits(int number) {

        if ((number <= 9 )) {
            return -1;
        }

        int sum = 0;

        // 125 -> (125 / 10) = 12 -> 12 * 10 = 120 -> 125 - 120 -> = 5 (Extracting 5 from 125) with Integers.

        while (number > 0) {

            int digit = number % 10;
            sum += digit;
            number /= 10;

        }
        return sum;
    }

}
