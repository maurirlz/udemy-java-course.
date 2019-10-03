package FirstSteps.PrimitiveTypes.Strings;

public class Strings {
    public static void main(String[] args) {
        // byte
        // short
        // int
        // long
        // float
        // double
        // char
        // boolean
        // String is not a primitive data type but it has  certain favoritism.
        String myString = "This is a string";
        System.out.println("MyString is equal to: " + myString);
        myString = myString + ", and this is more";
        System.out.println("MyString is equal to: " + myString);
        myString = myString + "  \u00A9 2019";
        System.out.println("MyString is equal to: " + myString);
        String numberString = "250.55";
        numberString = numberString + "49.95";
        System.out.println(numberString);
        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println("LastString is equal to "+ lastString);
        double doubleNumber = 120.47D;
        lastString = lastString + doubleNumber;
        System.out.println("MyString is equal to: " + lastString);


    }
}
