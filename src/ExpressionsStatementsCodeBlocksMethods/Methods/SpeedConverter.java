package ExpressionsStatementsCodeBlocksMethods.Methods;
public class SpeedConverter {
    public static void main(String[] args) {

        double kmh = 95.75d;
        printConversion(kmh);

    }
    public static long toMilesPerHour(double kilometersPerHour){
        if (kilometersPerHour <= 0){
            return kilometersPerHour == 0 ? 0 : -1;
        }
        return Math.round(kilometersPerHour / 1.609);
    }
    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            long milesPerHour= toMilesPerHour(kilometersPerHour);
            System.out.println(kilometersPerHour + " km/h = "
                    + milesPerHour +
                    " mi/h");
        }
    }
}

