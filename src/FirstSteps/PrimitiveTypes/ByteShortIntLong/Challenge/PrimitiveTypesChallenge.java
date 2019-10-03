package FirstSteps.PrimitiveTypes.ByteShortIntLong.Challenge;

public class PrimitiveTypesChallenge {
    public static void main(String[] args) {

        byte varByte = 125;
        short varShort = 31000;
        int varInteger = 35000;
        long varLong = (50000L + 10L * (varByte+varShort+varInteger));

        System.out.println(varLong);

        short shortTotal;
        shortTotal = (short) (1000 + 10 * (varByte + varShort + varInteger));
        System.out.println(shortTotal);

    }
}
