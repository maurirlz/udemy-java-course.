package FirstSteps.PrimitiveTypes.ByteShortIntLong;

public class RangeOfByte {
    public static void main(String[] args) {
        // Width of the Short data type: 8bits or 1 byte or 2^3 bits.
        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMAXByteValue = Byte.MAX_VALUE;
        System.out.println("Byte Minimum Value = "+myMinByteValue);
        System.out.println("Byte Maximum Value = "+myMAXByteValue);

        //Casting example.
        byte myNewByteValue = (byte) (myMinByteValue / 2);

    }
}
