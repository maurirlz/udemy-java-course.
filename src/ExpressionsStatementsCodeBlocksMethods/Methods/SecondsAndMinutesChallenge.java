package ExpressionsStatementsCodeBlocksMethods.Methods;

public class SecondsAndMinutesChallenge {
    public static void main(String[] args) {

        System.out.println(getDurationString(65L,45L));
        System.out.println(getDurationString());
    }

    private static String getDurationString(long minutes, long seconds){

        if (minutes < 0L || (seconds < 0L || seconds > 59L)){
            return "Invalid value";
        }
        long hours = minutes / 60L;
        long remainingMinutes = minutes % 60L;
        return hours + "h " + remainingMinutes + "m " + seconds +"s";
    }
    private static String getDurationString(){

        if ((long) 3945 < 0L){
            return "Invalid value";
        }

        long minutes = (long) 3945 / 60L;
        long remainingSeconds = (long) 3945 % 60L;
        return getDurationString(minutes,remainingSeconds);
    }
}
