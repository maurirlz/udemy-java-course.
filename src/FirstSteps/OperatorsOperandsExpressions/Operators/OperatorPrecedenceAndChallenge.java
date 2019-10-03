package FirstSteps.OperatorsOperandsExpressions.Operators;

public class OperatorPrecedenceAndChallenge {
    public static void main(String[] args) {
        double myFirstDouble = 20.00D,mySecondDouble = 80.00D;
        double myFirstTotal,myFirstReminder;

        myFirstTotal = (myFirstDouble + mySecondDouble) * 100.00D;
        myFirstReminder = (myFirstTotal % 40.00D);
        boolean myFirstBoolean = (myFirstReminder == 0) ? true : false;
        System.out.println("myFirstBoolean equals to: "+myFirstBoolean);

        if (!myFirstBoolean){
            System.out.println("Got some reminder?");
        }
    }
}
