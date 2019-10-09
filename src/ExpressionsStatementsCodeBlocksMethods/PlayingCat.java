package ExpressionsStatementsCodeBlocksMethods;

public class PlayingCat {
    public static void main(String[] args) {
        isCatPlaying(true, 45);
        isCatPlaying(false,36);
        isCatPlaying(true, 56);
        isCatPlaying(false, 1);
    }
    public static boolean isCatPlaying(boolean summer, int temperature){
        // true > !summer && temperature >= 25 && temperature <= 35.
        // true > summer && temperature >= 25 && temperature  <= 45.
        // false en todos los demas.
        if (!summer && (temperature >= 25 && temperature <= 35)){
            return true;
        } else return summer && (temperature >= 25 && temperature <= 45);
    }
}
