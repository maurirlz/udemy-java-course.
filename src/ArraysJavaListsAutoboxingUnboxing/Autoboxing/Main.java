package ArraysJavaListsAutoboxingUnboxing.Autoboxing;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<>();
        strArrayList.add("Tim");
        String name = strArrayList.get(0);

        ArrayList<Integer> intArrayList = new ArrayList<>();
        /* intArrayList.add(50); */// Autoboxing
        /*int number = intArrayList.get(0);*/ // Unboxing

        for (int i = 0; i <= 10; i++) {
            intArrayList.add(i);
        }

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + "===>" + intArrayList.get(i));
        }

        // Shorcuts, java autoboxing  and unboxing for myself.
        Integer myIntValue = 56;
        int myInt = myIntValue;

        ArrayList<Double> myDoubleValues = new ArrayList<>();
        for (double dbl = 8.0; dbl <= 10.0; dbl += 0.5) {
            myDoubleValues.add(dbl);
        }

        for (int i = 0; i < myDoubleValues.size(); i++) {
            double value = myDoubleValues.get(i);
            System.out.println(i + "====>" + value);
        }

    }
}
