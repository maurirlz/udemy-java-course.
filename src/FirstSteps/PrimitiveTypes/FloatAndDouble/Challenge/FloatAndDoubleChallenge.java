package FirstSteps.PrimitiveTypes.FloatAndDouble.Challenge;

public class FloatAndDoubleChallenge {
    public static void main(String[] args) {

        int myIntValue = 5 / 3;
        float MyFloatValue = 5F / 3F;
        double myDoubleValue = 5D / 3D;
        double myDoubleValue1 = 5.00 / 3.00; // the same as doing 5D / 3D, java treats floating point operations with double as default.

        System.out.println("MyIntValue= " +myIntValue);
        System.out.println("MyFloatValue= " +MyFloatValue);
        System.out.println("MyDoubleValue= " +myDoubleValue);
        System.out.println("MyDoubleValue1= " +myDoubleValue1);

        // It's better to use Double than float, it's acceded more rapidly with modern computers, it's more precise and it works with a wider range of numbers.

        // Pounds to Kilograms Challenge:

        double Pounds = 50;
        double Kilograms = Pounds * 0.45359237D;
        System.out.println(Pounds+" Pounds equals "+Kilograms+" Kilograms");

        double pi = 3.1415927D;
        double anotherNumber = 3_000_000.4_567_890D;

        System.out.println(pi);
        System.out.println(anotherNumber);

    }
}
