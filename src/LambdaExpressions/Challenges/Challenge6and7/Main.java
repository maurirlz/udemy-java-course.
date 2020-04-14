package LambdaExpressions.Challenges.Challenge6and7;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "I love Java!";

        String supplierResult = supplier.get();
        System.out.println(supplierResult);
    }
}
