package ArraysJavaListsAutoboxingUnboxing.Lists.Arraylist;

import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        System.out.println(printInstructions());

        while(!quit) {
            System.out.println("Enter your choice:");
            choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 0:
                    System.out.println(printInstructions());
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case  2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }


    public static String printInstructions() {

        final StringBuilder sb = new StringBuilder();
        sb.append("\nPress: \n")
                .append("\n\t 0 - To print choice options.")
                .append("\n\t 1 - To print the list of grocery items.")
                .append("\n\t 2 - To add an item in the list.")
                .append("\n\t 3 - To modify an item in the list")
                .append("\n\t 4 - To remove an item from the list.")
                .append("\n\t 5 - To search for an item in the list.")
                .append("\n\t 6 - To quit the application.\n");

        return sb.toString();
    }

    public static void addItem() {

        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(s.nextLine());
    }

    public static void modifyItem() {

        System.out.println("Enter item number: ");
        int itemNumber = s.nextInt();
        s.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = s.nextLine();
        groceryList.modifyGroceryItem(itemNumber - 1, newItem);
    }

    public static void removeItem() {

        System.out.println("Enter item number: ");
        int itemNumber = s.nextInt();
        s.nextLine();
        groceryList.removeGroceryItem(itemNumber - 1);
    }

    public  static void searchForItem() {

        System.out.println("Item to search for: ");
        String searchItem = s.nextLine();
        if (groceryList.findItem(searchItem) != null) {

            System.out.println("Found " + searchItem + " in our grocery list");
        } else {

            System.out.println(searchItem + " is not in the shopping list.");
        }
    }
}
