package RegularExpressions.Intro;

public class Quantifiers {

    public static void main(String[] args) {

        String string = "I am a String, yes, I am.";
        String yourString = string.replaceAll("I", "You");
        String alphanumeric = "abcDeeeF12ghhiiiiijkl199z";
        String hasWhiteSpace = "I have blanks spaces and \ta tab and also a newline\n";

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

    }
}
