package ControlFlowStatements.WhileAndDoWhile;

public class WhileAndDoWhile {
    public static void main(String[] args) {

        int count = 1;

        /*while (count != 7) {

            System.out.println("Count value is " + count);
            count++;
        }*/

        /*for (count = 1; count < 7; count++) {

            System.out.println("Count value is " + count);
        }}*/

        /*int count1 = 1;

        while (true) {
            if (count1 == 6) {

                break;
            }
            System.out.println("Count1 value is " + count1);
            count1++;
        }*/
        int count2  = 6;

        do {

            System.out.println("Count2 value was " + count2);
            count2++;

            if (count2 > 100) {
                break;
            }

        } while(count2 != 6);

    }

}
