package ControlFlowStatements.ReadingInput;
import java.util.Scanner;

public class ReadingInput {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your year of birth.");
        boolean hasNextInt = sc.hasNextInt();

        if (hasNextInt) {                   // if statement in charge of filtering through character or string inputs when
                                            // the Scanner is waiting an Int,  using hasNextInt method from Scanner Class
            int yearOfBirth = sc.nextInt(); // If the user inputs a negative number, there needs to be a range for
                                            // the Int scanner to handle, IE: 0-100 for age.

            sc.nextLine();  // Solution to nextLine skipping input,
                            // there always need to be a nextLine method to handle the end of line
                            // when reading a Number.

            System.out.println("Enter your name: ");
            String  name = sc.nextLine();

            int age = 2019 - yearOfBirth;

            if (age >= 0 && age <= 100) {
                System.out.println("Your name is: " + name + ", and you are " + age + " years old.");
            } else {
                System.out.println("Invalid year of birth.");
            }
        } else {
            System.out.println("Unable to parse year of birth.");
        }

        // Always close the scanner after usage, this does free the memory Java has reserved for the scanner class and static methods.
        sc.close();

    }
}
