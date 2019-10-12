package ExpressionsStatementsCodeBlocksMethods.Methods;

public class FeetAndInchesToCentimeters {
    public static void main(String[] args) {
        // 1 inch = 2.54cm
        // 1 foot = 12 inches.

        calcFeetAndInchesToCentimeters(100);
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {


        if (feet < 0 || (inches < 0 || inches > 12d)) {

            System.out.println("Invalid feet or inches parameters");
            return -1;
        }

        double centimeters = (feet * 12d) * 2.54;

        centimeters += inches * 2.54;
        System.out.println(feet + " feet, "
                + inches + " inches = "
                + centimeters + " centimeters");
        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {

        if (inches < 0) {

            System.out.println("Invalid feet or inches parameters");
            return -1;
        }

        double feet = (int) inches  / 12d;
        double remainingInches = (int) inches % 12;

        System.out.println(inches + " Inches is equal to "
        + feet + " feet " + remainingInches + " inches ");
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }
}

