package FirstSteps.PrimitiveTypes.FloatAndDouble;

public class FloatAndDouble {
    public static void main(String[] args) {

        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float Minimum Value = " + myMinFloatValue);
        System.out.println("Float Maximum Value = " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double Minimum Value = " + myMinDoubleValue);
        System.out.println("Double Maximum Value = " + myMaxDoubleValue);

        int myIntValue = 5;
        float myFloatValue = 5.25F; //  best way
        float myFloatValue1 = (float) 5.25;
        double myDoubleValue = 5.25D;
        // Java treats floating point values as double by default, so we cast it to float.
        float myNewFloatValue = (float) (myMinFloatValue / 2.5);

    }
}
