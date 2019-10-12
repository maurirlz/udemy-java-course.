package ControlFlowStatements.Switch;

public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        boolean result = false;
        int count = 0;

        if (number < 1) {
            return false;
        }
        for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                count += i;
            }
        }
        if (count == number) {
            result = true;
        }
        return result;
    }
}