package ExpressionsStatementsCodeBlocksMethods.Methods;

public class AreaCalculator {
    public static void main(String[] args) {

        double invalidCircleParameter = area(-1);
        double validCircleParameter = area(5);
        double invalidFirstRectanguleParameters = area(-1,5);
        double invalidSecondRectanguleParameters = area(1,-5);

        System.out.println("Area of the Circle: " + validCircleParameter);
        System.out.println("Invalid parameter for Circle: " + invalidCircleParameter);
        System.out.println("Area of the Rectangule: " + validCircleParameter);
        System.out.println("Invalid first parameter for Rectangule: " + invalidFirstRectanguleParameters);
        System.out.println("Invalid second parameter for Rectangule: " + invalidSecondRectanguleParameters);

    }

    public static double area(double radius) {

        if (radius < 0d){

            return -1.0d;
        }
        return (Math.PI * (Math.pow(radius, 2d)));
    }

    public static double area(double x, double y) {

        if ((x < 0 ) || (y < 0)) {

            return -1.0d;
        }
        return (x * y);
    }
}
