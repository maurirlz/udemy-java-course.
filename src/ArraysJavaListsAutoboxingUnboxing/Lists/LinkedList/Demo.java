package ArraysJavaListsAutoboxingUnboxing.Lists.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder("Sydney", placesToVisit);
        addInOrder("Melbourne", placesToVisit);
        addInOrder("Brisbane", placesToVisit);
        addInOrder("Perth", placesToVisit);
        addInOrder("Canberra", placesToVisit);
        addInOrder("Adelaide", placesToVisit);
        addInOrder("Darwin", placesToVisit);
        addInOrder("Darwin", placesToVisit);
        printList(placesToVisit);
        visitCity(placesToVisit);


        /*placesToVisit.add(1,"Alice Springs");
        printList(placesToVisit);

        placesToVisit.remove(4);
        printList(placesToVisit);*/



    }

    private static void printList(LinkedList<String> linkedList) {

        Iterator<String> i = linkedList.iterator();
        /*while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }*/

        for (String s : linkedList) {
            System.out.println("Now visiting " + i.next());
        }

        System.out.println("==============================");
    }

    private static boolean addInOrder(String newCity, LinkedList<String> linkedList) {

        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {

            int comparison = stringListIterator.next().compareTo(newCity);

            if (comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {

                // newCity should appear before this one
                // Brisbane -> Adelaide should make Adelaide go first.

                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
        }

        stringListIterator.add(newCity);
        return true;
    }

    private static void visitCity(LinkedList<String> cities) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itenery");
        } else {
            System.out.println("Now visiting: " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {

                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:

                    if (!goingForward){
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }

                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting: " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list.");
                        goingForward = false;
                    }
                    break;

                case 2:

                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }

                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting: " + listIterator.previous());
                    } else {
                        System.out.println("Reached the start of the list.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }
    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - Quit");
        System.out.println("1 - Go to the next city");
        System.out.println("2 - Go to the previous city");
        System.out.println("3 - Print menu options");
    }
}
