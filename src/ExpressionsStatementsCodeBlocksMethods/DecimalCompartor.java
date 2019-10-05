package ExpressionsStatementsCodeBlocksMethods;

public class DecimalCompartor {
    public static void main(String[] args) {

    }

    public static boolean areEqualByThreeDecimalPlaces(double firstNumber, double secondNumber) {
       return (long) (firstNumber * 1000d) == (long) (secondNumber * 1000d);
    }
}