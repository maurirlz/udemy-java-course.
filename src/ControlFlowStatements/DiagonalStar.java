package ControlFlowStatements;

public class DiagonalStar {
    public static void main(String[] args) {

    }

    public static void printSquareStar(int n) {
        if(n < 5) {

            System.out.println("Invalid Value");
        } else {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j <= n - 1; j++) {

                    if (i == 0 || i == n - 1) {

                        System.out.print("*");
                    } else if (i + j == i || j == n - 1 || i == j || (n - 1) - i == j) {

                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
