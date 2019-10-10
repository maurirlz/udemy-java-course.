package ControlFlowStatements;

public class LastDigitChecker {
    public static void main(String[] args) {


    }
    public static boolean hasSameLastDigit(int firstNumber, int secondNumber, int thirdNumber) {

        if ((!isValid(firstNumber)) || (!isValid(secondNumber)) || (!isValid(thirdNumber))) {

            return false;
        }

        int firstLastDigit = firstNumber % 10;
        int secondLastDigit = secondNumber % 10;
        int thirdnLastDigit = thirdNumber % 10;

        return ((firstLastDigit == secondLastDigit) ||  (firstLastDigit == thirdnLastDigit) || (secondLastDigit == thirdnLastDigit));
    }

    public static boolean isValid(int number) {
        if ((number < 10 || number > 1000)) {

            return false;
        } else {

            return true;
        }
    }
}
