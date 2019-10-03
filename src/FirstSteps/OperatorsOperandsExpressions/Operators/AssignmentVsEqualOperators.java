package FirstSteps.OperatorsOperandsExpressions.Operators;

public class AssignmentVsEqualOperators {
    public static void main(String[] args) {

        boolean isCar = false;
        // Assignment in if-else statement instead of equals to:
        if (isCar = true){
            System.out.println("This is not supposed to happend.");
        }
        // Equals to in If-else statement instead of Assignment Operator:
        if (isCar == true){
            System.out.println("This is not supposed to happend.");
        }
        // Abbreviated version to check if isCar is true.
        if (isCar){
            System.out.println("This is not supposed to happend.");
        }
        // Abreviated version to check if isCar is false
        if (!isCar){
            System.out.println("This is not supposed to happend.");
        }
    }
}
