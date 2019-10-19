package ArraysJavaListsAutoboxingUnboxing.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myVariable;
        myVariable = new int[9];

        int[] myIntArray = new int[9]; // same as above.

        myIntArray[5] = 50;

        // array of doubles

        double[] myDoubleArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(myDoubleArray[4]);

        for (int i = 0; i < myDoubleArray.length; i++) {
            myDoubleArray[i] = i*10;
        }

        printArray(myDoubleArray);



    }
    // pass an array as argument in a method.
    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {

            System.out.println("Element " + i + ", value is: " + array[i])   ;
        }
    }
}
