package ObjectOrientedProgramming.MasterChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scNum = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        
        Burger acumPriceBurger = new Burger("Test","test","test",0);
        ArrayList<Burger> alBurger = new ArrayList<>();

        String burgerName,meatType,rollType,flag;
        byte maxAdditions;
        int count = 0;
        double totalPrice = 0d;

        Start:
        while (true) {

            System.out.println("Please, declare the order 1 burger at a time: ");
            System.out.println("Input the type of burger #" + (count + 1) + ": ");
            String burgerType = scNum.nextLine().toUpperCase();

            switch (burgerType) {

                case "NORMAL":
                    System.out.println("Input what type of meat you want with your burger: (BEEF, CHICKEN or VEGGIE) ");
                    meatType = scStr.nextLine().toUpperCase();

                    alBurger.add(new Burger("NORMAL","NORMAL",meatType,13.30d));

                    System.out.println("Burguer created! current price of your: NORMAL BURGER"
                            + " is $13.30");

                    System.out.println("Please, input the number of additions you want for your burguer: ");
                    maxAdditions = scNum.nextByte();

                    while (!scNum.hasNextByte() && (scNum.nextByte() > 4 || scNum.nextByte() < 0)) {
                        System.out.println("Invalid value, please be sure to add a valid number (0 to 4)");
                        maxAdditions = scNum.nextByte();
                    }

                    for (int i = 0; i < maxAdditions; i++) {
                        if ((i >= 1)) {
                            System.out.println("Want to keep adding toppings? input:" +
                                    "Y for yes " +
                                    "N to exit the menu.");
                            char breakOpt = scStr.next().toUpperCase().charAt(0);
                            if (breakOpt == 'N') {
                                break;
                            }

                        }

                        System.out.println("You can add up to a maximum of: " + maxAdditions + " additions to this burguer.");
                        System.out.println("You can add add the following additions: " +
                                "1. Lettuce." +
                                "2. Tomato." +
                                "3. Bacon." +
                                "4. Pickles.");

                        System.out.println("Please, input the corresponding number of the addition you want on your burguer: ");
                        byte option = scNum.nextByte();

                        switch (option) {
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            default:
                                System.out.println("invalid value");
                                break;
                        }

                    }
                case "HEALTHY":


                    break;
                case "DELUXE":


                    break;
                default:
                    System.out.println("Invalid type of burguer.");
                    count--;

            }


            System.out.println("Do you want to keep adding burgers? Yes/No");
            flag = scStr.nextLine();

            switch (flag.toUpperCase()) {
                case "YES":
                case "Y":
                case "YEAH":
                    System.out.println("Loading burger menu.");
                    count++;
                    break;
                case "NO":
                case "N":
                    break Start;
            }
        }

        for (Burger o : alBurger) {
            totalPrice += o.showTotalPrice();
        }

        System.out.println("Total price of your order: " + totalPrice);
    }

}
