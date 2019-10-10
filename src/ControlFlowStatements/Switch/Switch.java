package ControlFlowStatements.Switch;

public class Switch {
    public static void main(String[] args) {
        /*int value = 1;
        if (value == 1) {
            System.out.println("Value was 1");
        } else if  (value == 2) {
            System.out.println("value was 2");
        } else  {
            System.out.println("Was  not 1 or 2");
        }*/


        int switchValue = 4;
        switch (switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3:case 4:case 5: // multiple cases.
                System.out.println("Was a 3, 4, or 5");
                System.out.println("Actually, it was a: " + switchValue);
                break;
            default:
                System.out.println("Was not 1 or 2");
                break;
        }
        // more code here

    }
}
