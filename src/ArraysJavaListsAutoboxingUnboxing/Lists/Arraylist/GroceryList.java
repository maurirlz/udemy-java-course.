package ArraysJavaListsAutoboxingUnboxing.Lists.Arraylist;

import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item) {

        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size()
                + " items in your grocery list");

        for (int i = 0; i < groceryList.size(); i++) {

            System.out.println((i+1) + " - " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);

        if (position >= 0 ) {
            modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item "
                + " has been modified.");
    }

    private void removeGroceryItem(int position) {

        groceryList.remove(position);
        System.out.println("Item removed.");
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);

        if (position >= 0 ) {
            removeGroceryItem(position);
        }
    }

    private int findItem(String searchItem) {

        return groceryList.lastIndexOf(searchItem);
    }

    public boolean onFile(String searchItem) {

        int position = findItem(searchItem);
        return position >= 0;
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }
}
