package FirstSteps.OperatorsOperandsExpressions.Operators;

public class TerniaryOperator {
    public static void main(String[] args) {
        boolean isCar = false;
        isCar = true;
        boolean wasCar = isCar ? true : false;
        if (wasCar){
            System.out.println("wasCar is true.");
        }
    }
}
