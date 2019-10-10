package ExpressionsStatementsCodeBlocksMethods.Methods;

public class Methods {
    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;
        int highScore = calculateScore(true, 800, 5, 100);

        System.out.println("Your final score was: " + highScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 500;

        highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was: " + highScore);

/* Create a method called displayHighScorePosition();
   It should recieve a players name as a parameter and a 2nd parameter as a position in the high score table
   You should display the players name along with a message like "Managed to get into position" and the
   position they got and a further message " on the high score table"*/
/* Create a 2nd method called calculateHighScorePosition
*  It should be sent one argument only, the player's score
*  It should return an int
*  the return data should be:
*  1 if the score is greater than 1000
*  2 if the score is greater than 500 and less than 1000
*  3 if the score is greater than 100 and less than 500
*  4 in all other cases
*  call both methods and display the results of the following:
*  A playerScore of 1500
*  A playerScore of 900
*  A playerScore of 400
*  A playerScore of 50*/

        highScore = 1500;
        int position = calculateHighScorePosition(highScore);
        displayHighScorePosition("Mauri", position);
        highScore = 900;
        position = calculateHighScorePosition(highScore);
        displayHighScorePosition("Mauribizio", position);
        highScore = 400;
        position = calculateHighScorePosition(highScore);
        displayHighScorePosition("Mauritez", position);
        highScore = 50;
        position = calculateHighScorePosition(highScore);
        displayHighScorePosition("Benizio", position);

    }

    public static int calculateScore(boolean gameOver, int playerScore, int levelCompleted, int bonus) {

        if (gameOver) {

            int finalScore = playerScore + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        }
        return -1;
    }

    public static void displayHighScorePosition(String playerName, int position) {

        System.out.println(playerName+ " Managed to get into position: " + position +
                " on the high playerScore table");
    }

    public static int calculateHighScorePosition(int playerScore) {

        /*if (playerScore >= 1000){
            return 1;
        } else if (playerScore >= 500)  {
            return 2;
        } else if (playerScore >= 100) {
            return 3;
        }

        return 4;*/

        int position = 4; // assuming position 4 will be returned.

        if (playerScore >= 1000) {

            position = 1;
        } else if (playerScore >= 500) {

            position = 2;
        } else if (playerScore >= 100) {

            position = 3;
        }
        return position;
    }
}
