package DebuggingAndUnitTesting.Debugger;

public class StringUtilities {

    private final StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sBuilder, char c) {

        sBuilder.append(c);
        charsAdded++;
    }

    public String upperAndPrefix(String string) {

        String upper = string.toUpperCase();

        return "Prefix_" + upper;
    }

    public String addSuffix(String str) {

        return str + "__Suffix";
    }
}
