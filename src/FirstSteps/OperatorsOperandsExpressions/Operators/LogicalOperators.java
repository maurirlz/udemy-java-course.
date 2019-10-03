package FirstSteps.OperatorsOperandsExpressions.Operators;

public class LogicalOperators {
    public static void main(String[] args) {

        int topScore = 100;
        // Is not equal to
        if (topScore != 100){
            System.out.println("You got the highest score!");
        }
        //Greater than
        if (topScore > 100){
            System.out.println("You got the highest score!");
        }
        // Greater than or equal to
        if (topScore >= 100){
            System.out.println("You got the highest score!");
        }
        // less than
        if (topScore < 100){
            System.out.println("You got the highest score!");
        }
        // Less than or equal to
        if (topScore <= 100){
            System.out.println("You got the highest score!");
        }
        int secontTopScore = 81;
        // AND operator
        if ((topScore > secontTopScore) && (topScore < 100)){
            System.out.println("Greater than second top score and less than  100");
        }
        // OR operator
        if ((topScore > 90) || (secontTopScore <= 90)){
            System.out.println("Either or both of the conditions aare true");
        }

    }
}
