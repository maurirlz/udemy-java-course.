package ControlFlowStatements;

public class FIrstAndLastDigitSum {
    public static void main(String[] args) {

    }

    public static int sumFirstAndLastDigit(int number) {
        if (number <= 0) {

            return (number == 0 ? 0 : -1); // Number is 0 ? then return 0, if not, then return -1.
        }

        int reverse = 0;
        int firstDigit;
        int lastDigit;
        int backupNumber = number;

        while (number != 0) {

            reverse = reverse * 10 + (number % 10);
            number = number / 10;
        }
        firstDigit = backupNumber % 10;
        lastDigit = reverse % 10;

        return firstDigit + lastDigit;
    }
}
