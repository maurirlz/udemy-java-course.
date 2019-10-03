package FirstSteps.PrimitiveTypes.CharAndBoolean;

public class CharDataType {
    public static void main(String[] args) {
        // Char occupies 2 bytes in memory or 16 bits or 2^4, it allows you to store unicode characters too.
        char myChar = 'D';
        // Representation of a char with unicode, in this case, the uppercase D:
        char myUnicodeChar = '\u0044';
        System.out.println(myChar);
        System.out.println(myUnicodeChar);
        // Printing the Copyright symbol with his unicode representation:
        char myCopyrightChar = '\u00A9';
        System.out.println(myCopyrightChar);



    }
}
