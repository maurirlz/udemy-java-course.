package FirstSteps.PrimitiveTypes.ByteShortIntLong;

public class RangeOfInt {
    public static void main(String[] args) {
        // Width of the Integer data type: 32-bit or 4 bytes or 2^32.
        int myValue = 10000;

        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer Minimum value = "+ myMinIntValue);
        System.out.println("Integer Maximum value = "+ myMaxIntValue);
        System.out.println("Busted MAX value = "+(myMaxIntValue + 1));
        System.out.println("Busted MIN value = "+(myMinIntValue - 1));

        int myMaxIntTest = 2147483647;

        int myTotal = (myMinIntValue / 2);

    }
}
