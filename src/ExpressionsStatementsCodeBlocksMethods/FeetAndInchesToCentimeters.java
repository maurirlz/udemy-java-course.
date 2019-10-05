package ExpressionsStatementsCodeBlocksMethods;

public class FeetAndInchesToCentimeters {
    public static void main(String[] args) {
        // 1 inch = 2.54cm
        // 1 foot = 12 inches.
        double centimeters = calcFeetAndInchesToCentimeters(0, -15);
        if (centimeters < 0.0) {
            System.out.println("Invalid parameters");
        }
        calcFeetAndInchesToCentimeters(100);
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {

        System.out.println("Invalid feet or inches parameters");
        if (feet < 0 || (inches < 0 || inches > 12)) {
            return -1;
        }
        double centimeters = (feet * 12) * 2.54;
        centimeters += inches * 2.54;
        System.out.println(feet + " feet, "
                + inches + " inches = "
                + centimeters + " centimeters");
        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {

        System.out.println("Invalid feet or inches parameters");
        if (inches < 0) {
            return -1;
        }
        double feet = (int) inches  / 12;
        double remainingInches = (int) inches % 12;
        System.out.println(inches + "Inches is equal to "
        + feet + " feet " + remainingInches + " inches ");
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }
}

