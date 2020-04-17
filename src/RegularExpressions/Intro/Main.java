package RegularExpressions.Intro;

public class Main {

    public static void main(String[] args) {


        String string = "I am a String, yes, I am.";
        String yourString = string.replaceAll("I", "You");
        String alphanumeric = "abcDeeeF12ghhiiiiijkl199z";

        System.out.println(alphanumeric.replaceAll(".", "Y")); // dot represents all characters, that will be replaced with an Y

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY")); // ^ is a boundary matcher that specifies certain pattern that must match at the beginning of the String

        System.out.println("^abcDeee".matches(alphanumeric)); // false
        System.out.println("abcDeee".matches("^abcDeee")); // true

        System.out.println(alphanumeric.replaceAll("ijkl199z$", "THE END")); // $ is a boundary matcher that specifies certain pattern that must match at the end of the String

        System.out.println(alphanumeric.replaceAll("[aei]", "X")); // Square brackets regex set a specified set of letters of characters to be, in this case, replaced.

        System.out.println(alphanumeric.replaceAll("[aeiAEI][fjFJ]", "X")); // Another set of square brackets after the first one defines a set of letters or characters that must follow the first bracket.

        System.out.println("harry".replaceAll("[hH]arry", "Harry"));

        System.out.println(alphanumeric.replaceAll("[^ej]", "X")); // when used inside brackets, the Carrot character becomes
                                                                   // a Character class that negates the current regex inside brackets,
                                                                   // in this case, selecting all letters THAT ARE NOT e or j.

        System.out.println(alphanumeric.replaceAll("[a-fA-F0-7]", "X")); // the Dash charcter class specifies RANGE, so this will select every character thaT IS
                                                                          // between a-f case insensitive and 0 and 7.

        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X")); // special construct to turn on case insensitiviness.
        System.out.println(alphanumeric.replaceAll("[0-9]", "X")); // replacing digits from 0 to 9.

        System.out.println(alphanumeric.replaceAll("\\d", "X")); // shortcut to replacing all the digits like the statement above.

        System.out.println(alphanumeric.replaceAll("\\D", "X")); // Shortcut to replacing all non-digits.

        String hasWhiteSpace = "I have blanks spaces and \ta tab and also a newline\n";

        System.out.println(hasWhiteSpace.replaceAll("\\s", "")); // shortcut to replacing all whitespaces with nothing.

        System.out.println(hasWhiteSpace.replaceAll("\\S", "X")); // replacing all non-whitespaces characters with an X, only tab spaces and new line remains.

        System.out.println(alphanumeric.replaceAll("\\w", "X")); // \w stands for [a-zA-Z0-9_] and this does replaces everything in that range for an X.
        System.out.println(hasWhiteSpace.replaceAll("\\W", "X")); // negates \w so it will replace everything that is NOT \w ([a-zA-Z0-9_])

        System.out.println(alphanumeric.replaceAll("\\b", "X")); // \b stands for BOUNDARIE matcher and this will replace every boundarie in the string for an X.
    }
}
