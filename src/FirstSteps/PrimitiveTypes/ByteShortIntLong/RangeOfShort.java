package FirstSteps.PrimitiveTypes.ByteShortIntLong;

public class RangeOfShort {
    public static void main(String[] args) {
         // Width of the Short data type: 16-bit or 2 bytes or 2^16.
        short myMinShortValue = Short.MIN_VALUE;
        short myMAXShortValue = Short.MAX_VALUE;
        System.out.println("Short Minimum Value = "+myMinShortValue);
        System.out.println("Short Maximum Value = "+myMAXShortValue);

        // Casting example int to short.
        short myNewShortValue = (short) (myMinShortValue / 2);

    }
}
