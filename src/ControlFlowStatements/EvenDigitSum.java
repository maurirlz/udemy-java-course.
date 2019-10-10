package ControlFlowStatements;

public class EvenDigitSum {
    public static void main(String[] args) {


    }

    public static int getEvenDigitSum(int number) {

        if (number <= 0) {

            return (number == 0 ? 0 : -1); // Number is 0 ? then return 0, if not, then return -1.
        }

        int lastDigit = 0;
        int sum = 0;

        while (number > 0) {

            lastDigit = number % 10;
            number = number / 10;

            if (lastDigit % 2 == 0) {
                sum+=lastDigit;
            }
        }
        return sum;
    }
}
