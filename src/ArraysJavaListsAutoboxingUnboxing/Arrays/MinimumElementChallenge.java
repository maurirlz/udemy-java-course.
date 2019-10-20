package ArraysJavaListsAutoboxingUnboxing.Arrays;

import java.util.Scanner;

public class MinimumElementChallenge {

    private static Scanner numSc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] intArray = new int[5];
        int minElement;

        intArray = readIntegers(intArray.length);

        minElement = findMin(intArray);
        System.out.println(minElement);
    }


    public static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {

                min = array[i];
            } else {
                if (array[i] < min) {

                    min = array[i];
                }
            }
        }
        return min;
    }

    public static int[] readIntegers(int dimension) {

        int[] intArray = new int[dimension];

        for (int i = 0; i < intArray.length; i++) {

            System.out.println("Please, enter a Integer to be stored in index " + (i + 1) + "\r");

            if (numSc.hasNextInt()) {

                intArray[i] = numSc.nextInt();
            } else {
                System.out.println("Invalid value, please input an integer.");
                i--;
            }
         }

        return intArray;
    }

}
