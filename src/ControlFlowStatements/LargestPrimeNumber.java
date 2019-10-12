package ControlFlowStatements;

public class LargestPrimeNumber {
    public static void main(String[] args) {

    }

    public static int getLargestPrime (int number) {
        if (number <= 1) {

            return -1;
        }

        int count = 1;
        int prime = 1;

        while (number > 1) {


            count += 1;
            if (number % count == 0) {


                number = number / count;
                prime = count;
                count = 1;
            }
        }
        return prime;
    }
}
