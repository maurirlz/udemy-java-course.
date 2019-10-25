package ArraysJavaListsAutoboxingUnboxing.Lists.Arraylist;

import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

        boolean quit = false;
        int choice;
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
                case 2:
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
                 /*   processArrayList();*/
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }

    private static String printInstructions() {

        final StringBuilder sb;
        sb = new StringBuilder();
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

    private static void addItem() {

        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(s.nextLine());
    }

    private static void modifyItem() {

        System.out.println("Current item nuame: ");
        String itemNo = s.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = s.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
    }

    private static void removeItem() {

        System.out.println("Enter item name: ");
        String itemName = s.nextLine();
        groceryList.removeGroceryItem(itemName);
    }

    private static void searchForItem() {

        System.out.println("Item to search for: ");
        String searchItem = s.nextLine();
        if (groceryList.onFile(searchItem)) {

            System.out.println("Found " + searchItem + " in our grocery list");
        } else {

            System.out.println(searchItem + " is not in the shopping list.");
        }
    }

    /*private static void processArrayList() {

        // forms of copying contents of one arraylist to another one, calling the constructor is faster.

        ArrayList<String> newArray = new ArrayList<>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());

        // form of making an ArrayList an array with all the contents saved.

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }*/
}
