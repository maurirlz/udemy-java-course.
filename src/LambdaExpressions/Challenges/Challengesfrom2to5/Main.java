package LambdaExpressions.Challenges.Challengesfrom2to5;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Function<String, String> lambdaFunction = s -> {

            StringBuilder returnVal = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {

                if (i % 2 == 0) {

                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };

        String test = "1234567890";
        String s = everySecondCharacter(lambdaFunction, test);

        System.out.println(s);
    }

    public static String everySecondCharacter(Function<String, String> stringFunction, String s) {


        return stringFunction.apply(s);
    }
}
