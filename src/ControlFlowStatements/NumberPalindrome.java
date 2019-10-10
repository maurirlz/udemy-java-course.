package ControlFlowStatements;
public class NumberPalindrome {
    public static void main(String[] args) {

        System.out.println(isPalindrome(123321));

    }

    public static boolean isPalindrome (int number) {

        if (number < 0) {

            number = -1*number;
        }

        int reverse = 0;
        int lastDigit;
        int n1 = number;

        while (n1 > 0) {

            lastDigit = n1 % 10;
            n1 /=10;
            reverse *= 10;
            reverse += lastDigit;
        }

        return number - reverse == 0;
    }
}