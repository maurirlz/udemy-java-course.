package ArraysJavaListsAutoboxingUnboxing.Arrays;

import java.util.Scanner;

public class ReverseChallenge {

    private static Scanner numSc = new Scanner(System.in);

    public static void main(String[] args) {

        int[] array = new int[5];
        int[] array1 = new int[5];

        array = readIntegers(array.length);

        reverse(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    public static void reverse(int[] array) {
        int maxIndex = (array.length - 1);
        int halfLength = (array.length / 2);

        for (int i = 0; i < halfLength; i++) {

            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;

        }
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
