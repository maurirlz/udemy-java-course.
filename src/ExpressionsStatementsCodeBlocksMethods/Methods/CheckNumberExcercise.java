package ExpressionsStatementsCodeBlocksMethods.Methods;

public class CheckNumberExcercise {
    // Write a method called checkNumber with an int parameter number

    // the method should not return any value, and it needs to print out:
    /*- "positive" if the parameter number is > 0
    - "negative" if the parameter number is < 0
    - "zero" if the parameter number is equal to 0*/
    /*Note: the checkNumber method needs to be defined in public static like we have been doing so far in the course.
    Note: Do not add a main method to your solution code! */
    public static void main(String[] args) {
        checkNumber(5);
        checkNumber(-1);
        checkNumber(0);
    }
    public static void checkNumber(int number) {

        if (number > 0){
            System.out.println("positive");

        } else if (number < 0) {

            System.out.println("negative");

        } else if (number == 0) {

            System.out.println("zero");

        }
    }
}
