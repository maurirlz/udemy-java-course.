package FirstSteps.PrimitiveTypes.ByteShortIntLong;

public class RangeOfLong {
    public static void main(String[] args) {
        // Width of the Long data type: 64-bit or 8 bytes or 2^64.
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Long Minimum value = "+ myMinLongValue);
        System.out.println("Long Maximum value = "+ myMaxLongValue);
        System.out.println("Busted MAX value = "+(myMaxLongValue + 1));
        System.out.println("Busted MIN value = "+(myMinLongValue - 1));

        long myLongValue = 100L;
        long bigLongLiteralValue = 214_748_364_723_45L;
        // If I add a L java will start to treat the number as a Long data type.
        long bigLongLiteralValue1 = 214_748_364_723_453L;

    }
}
