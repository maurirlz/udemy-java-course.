package ControlFlowStatements.WhileAndDoWhile;

public class WhileAndDoWhileChallenge {
    public static void main(String[] args) {

        int number = 4;
        int finishNumber = 20;
        int evennumbers = 0;

        while (number <= finishNumber) {

            number++;

            if (!isEvenNumber(number)) {

                continue;
            } else if (isEvenNumber(number)) {

                evennumbers++;
                if (evennumbers == 5) {

                    break;
                }
            }

            System.out.println("Even number found: " + number);
        }
        System.out.println("Total of even numbers found: " + evennumbers);
    }

    public static boolean isEvenNumber(int number) {

        if (number <= 0) {

            return false;
        } else {

            return (number % 2 == 0);
        }
    }
}
