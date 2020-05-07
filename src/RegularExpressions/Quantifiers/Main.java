package RegularExpressions.Quantifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String string = "I am a String, yes, I am.";
        String yourString = string.replaceAll("I", "You");
        String alphanumeric = "abcDeeeF12ghhiiiiijkl199z";
        String hasWhiteSpace = "I have blanks spaces and \ta tab and also a newline\n";

        System.out.println(alphanumeric.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(alphanumeric.replaceAll("^abcDe+", "YYY"));
        System.out.println(alphanumeric.replaceAll("^abcDe*", "YYY"));
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}", "YYY"));


        StringBuilder htmlText = new StringBuilder();
        htmlText.append("<h1>My Heading</h1>");
        htmlText.append("<h2>My Sub-Heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String pattern = "<h2>";
        Pattern h2Pattern = Pattern.compile(pattern);
        Matcher matcher = h2Pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset(); // must reset the matcher when you use it.
        int count = 0;
        String s;

        while (matcher.find()) {
            count++;
            s = String.format("Ocurrence %d : %d to %d", count, matcher.start(), matcher.end());
            System.out.println(s);
        }

        String h2GroupPattern = "(<h2>.*?</h2>)"; // by default * is a greedy quantifier (will grab as much text that causes a match as it can)
                                                // if we use the ? quantifier next, it will make the star quantifier a lazy one
                                                // (will grab as less text that causes a match as it can)

        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);

        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {

            System.out.println("Ocurrence: " + groupMatcher.group(1));
        }
    }
}
