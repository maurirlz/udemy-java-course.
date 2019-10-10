package ControlFlowStatements.ForLoop;

public class SumOf3And5Challenge {
    public static void main(String[] args) {
        double acum = 0;
        int cont = 0;

        for (int i = 1; i <= 1000 ; i++) {

            if (i % 3 == 0 && i % 5 == 0) {

                acum+=i;
                cont++;
                System.out.println("Number accumulated: " + i);
                if (cont == 5) {

                    break;
                }
            }
        }

        System.out.println("The sum of all numbers that made it into the acumulator is : " + acum);
    }
}
