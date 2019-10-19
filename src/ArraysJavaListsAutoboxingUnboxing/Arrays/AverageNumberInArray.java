package ArraysJavaListsAutoboxingUnboxing.Arrays;

import java.util.Scanner;

public class AverageNumberInArray {

    private static Scanner numSc = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntegers = getIntegers(5);

        for (int i = 0; i < myIntegers.length; i++) {

            System.out.println("Element " + i + ", typed value was " + myIntegers[i]);
        }
        System.out.println("The average is: " + getAverage(myIntegers));
    }

    private static int[] getIntegers(int number) {

        System.out.println("Enter " + number + "Integers values\r");
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++) {
            values[i] = numSc.nextInt();
        }
        return values;
    }

    public static double getAverage(int[] array) {

        int avg = 0, sum = 0;

        for (int i = 0; i < array.length; i++) {

            sum += array[i];
        }

        return (double) sum / (double) array.length;
    }
}
