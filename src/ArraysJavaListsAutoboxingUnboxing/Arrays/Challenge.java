package ArraysJavaListsAutoboxingUnboxing.Arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Challenge {
    private static Scanner numSc = new Scanner(System.in);

    public static void main(String[] args) {
        // Create a program using arrays that sorts a list of integers in descending order.
        // Descending order is highest value to lowest.
        // In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
        // ultimately have an array with 106,81,26, 15, 5 in it.
        // Set up the program so that the numbers to sort are read in from the keyboard.
        // Implement the following methods - getIntegers, printArray, and sortIntegers
        // getIntegers returns an array of entered integers from keyboard
        // printArray prints out the contents of the array
        // and sortIntegers should sort the array and return a new array containing the sorted numbers
        // you will have to figure out how to copy the array elements from the passed array into a new
        // array and sort them and return the new sorted array.

        int[] array = getIntegers(5);
        printArray(array);
        sortArray(array);
        printArray(array);

    }

    private static void sortArray(int[] array) {

        int temp;
        int arrayLength = array.length;

        for (int i = 0; i < (arrayLength - 1); i++) {

            for (int j = 0; j < (arrayLength - i - 1); j++) {

                if (array[j] < array[j+1]) {

                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    private static void printArray(int[] array) {

        System.out.println("Array with a length of: " + array.length + " being printed now.");
        for (int i = 0; i < array.length; i++) {

            System.out.printf("Position %d of the array contains: %d\n", (i+1), array[i]);
        }
    }

    private static int[] getIntegers(int number) throws InputMismatchException {

        int[] values = new int[number];

        System.out.println("Please, enter "
                + number + " integer values\r");

        if (numSc.hasNextInt()) {

            for (int i = 0; i < values.length; i++) {

                values[i] = numSc.nextInt();
                System.out.printf("Position of the array number: %d now contains: %d\n", (i+1), values[i]);
            }

            numSc.close();
        } else {

            System.out.println("Invalid value, please input a valid integer value.");
        }

        return values;
    }
}
