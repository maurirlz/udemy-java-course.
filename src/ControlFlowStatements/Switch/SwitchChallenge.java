package ControlFlowStatements.Switch;

public class SwitchChallenge {
    public static void main(String[] args) {
        // Create a new switch statement using char instead of int
        // create a new char variable
        // create a switch statement testing for
        // A, B, C, D, or E
        // display a message if any of these are found and then break
        // Add a default which displays a message saying not found
        char charValue = 'A';

        switch(charValue){
            case 'A':
                System.out.println("A was found.");
                break;
            case 'B':
                System.out.println("B was found.");
                break;
            case 'C':
                System.out.println("C was found.");
                break;
            case 'D':
                System.out.println("D was found.");
                break;
            case 'E':
                System.out.println("E was found.");
                break;
            default:
                System.out.println("Neither of the cases were found.");
                break;
        }

        String month = "january";

        switch (month.toLowerCase()){
            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
                break;
        }

    }
}
