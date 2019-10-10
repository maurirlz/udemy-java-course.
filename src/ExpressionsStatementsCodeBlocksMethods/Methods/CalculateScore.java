package ExpressionsStatementsCodeBlocksMethods.Methods;

public class CalculateScore {
    public static void main(String[] args) {

        int newScore = calculateScore("Tim", 500);
        System.out.println("Now score is " + newScore);
        calculateScore(75);
        calculateScore(50);
    }

    public static int calculateScore(String playerName, int score) {

        System.out.println("Player " + playerName
                + " score: " + score
                + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {

        System.out.println("Unnamed player "
                + " score: " + score
                + " points");
        return score * 1000;
    }

}
