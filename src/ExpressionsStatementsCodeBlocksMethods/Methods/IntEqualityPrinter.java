package ExpressionsStatementsCodeBlocksMethods.Methods;

public class IntEqualityPrinter {
    public static void main(String[] args) {
        printEqual(1,2,3);
        printEqual(1,1,1);
        printEqual(1,2,3);
    }
    public static void printEqual(int myFirstNumber, int mySecondNumber, int myThirdNumber) {

        if (myFirstNumber < 0 || mySecondNumber < 0 || myThirdNumber < 0) {

            System.out.println("Invalid Value");
        } else if (myFirstNumber == myThirdNumber && mySecondNumber == myThirdNumber) {

            System.out.println("All numbers are equal");
        } else if (myFirstNumber != mySecondNumber && myFirstNumber != myThirdNumber && mySecondNumber  != myThirdNumber) {

            System.out.println("All numbers are different");
        } else {

            System.out.println("Neither all are equal or different");
        }
    }
}