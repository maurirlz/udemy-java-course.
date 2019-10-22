package ArraysJavaListsAutoboxingUnboxing.Arrays;

import java.util.Scanner;

public class ResizeArray {

    private static Scanner sc = new Scanner(System.in);
    private static int[] baseData = new int[10];

    public static void main(String[] args) {

    }
    private static void getInput() {

        for (int i = 0; i < baseData.length; i++) {

            baseData[i] = sc.nextInt();
        }
    }

    private static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }

    private static void resizeArray() {

        int[] original = baseData;
        baseData = new int[12];

        for (int i = 0; i < original.length; i++) {
            baseData[i] = original[i];
        }
    }
}
