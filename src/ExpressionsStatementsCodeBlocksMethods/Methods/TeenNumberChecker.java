package ExpressionsStatementsCodeBlocksMethods.Methods;

public class TeenNumberChecker {
    public static void main(String[] args) {
        int myFirstNumber, mySecondNumber, myThirdNumber;
        myFirstNumber = 0;
        mySecondNumber = 2;
        myThirdNumber = 0;

        System.out.println(hasTeen(myFirstNumber,mySecondNumber,myThirdNumber));
    }
    public static boolean hasTeen(int myFirstNumber, int mySecondNumber, int myThirdNumber) {

        return (isTeen(myFirstNumber) || isTeen(mySecondNumber) || isTeen(myThirdNumber));
    }
    public static boolean isTeen(int myFourthNumber) {

        return (myFourthNumber >= 13 && myFourthNumber <= 19);
    }
}

