package ControlFlowStatements.WhileAndDoWhile;

public class WhileAndDoWhileChallenge {
    public static void main(String[] args) {

        int number = 4;
        int finishNumber = 20;
        int evenNumbers = 0;

        while (number <= finishNumber) {

            number++;

            if (!isEvenNumber(number)) {

                continue;
            }
            System.out.println("Even number found: " + number);
            evenNumbers++;
            if  (evenNumbers == 5) {

                break;
            }

        }

        System.out.println("Total of even numbers found: " + evenNumbers);
    }

    public static boolean isEvenNumber(int number) {

        if (number <= 0) {

            return false;
        } else {

            return (number % 2 == 0);
        }
    }
}
