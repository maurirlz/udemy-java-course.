package ControlFlowStatements.WhileAndDoWhile;

public class WhileAndDoWhileChallenge {
    public static void main(String[] args) {

        int number = 4;
        int finishNumber = 20;

        while (number <= finishNumber) {

            number++;
            if (!isEvenNumber(number)) {

                continue;
            }

            System.out.println("Even number found: " + number);
        }
    }

    public static boolean isEvenNumber(int number) {

        if (number <= 0) {

            return false;
        } else {

            return (number % 2 == 0);
        }
    }
}
