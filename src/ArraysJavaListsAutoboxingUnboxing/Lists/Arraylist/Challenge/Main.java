package ArraysJavaListsAutoboxingUnboxing.Lists.Arraylist.Challenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Create a program that implements a simple mobile phone with the following capabilities.
    // Able to store, modify, remove and query contact names.
    // You will want to create a separate class for Contact (name and phone number).
    // Create a master class (MobilePhone) that holds the ArrayList of Contact
    // The MobilePhone class has the functionality listed above.
    // Add a menu of options that are available.
    // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
    // and search/find contact.
    // When adding or updating be sure to check if the contact already exists (use name)
    // Be sure not to expose the inner workings of the Arraylist to MobilePhone
    // e.g. no ints, no .get(i) etc
    // MobilePhone should do everything with Contact objects only.

    private static Scanner s = new Scanner(System.in);
    private static MobilePhone phone = new MobilePhone();

    public static void main(String[] args) {

        short choice;

        choice = s.nextShort();
        s.nextLine();
        System.out.println(printInstructions());

        Menu:
        while (true) {

            switch (choice) {

                case 0:

                    System.out.println(printInstructions());
                    break;

                case 1:

                    addNewContact();
                    break;

                case 2:

                    printContacts();
                    break;

                case 3:

                    updateContact();
                    break;

                case 4:

                    removeContact();
                    break;

                case 5:

                    searchContact();
                    break;

                case 6:

                    break Menu;

                default:
                    System.out.println("Wrong input.");
                    break;
            }
        }
    }

    private static String printInstructions() {
        final StringBuilder sb;
        sb = new StringBuilder();

        sb.append("\nPress: \n")
                .append("\n\t 0 - To print choice options.")
                .append("\n\t 1 - To add a new Contact.")
                .append("\n\t 2 - To print the Contact's list.")
                .append("\n\t 3 - To update a Conctact in the list")
                .append("\n\t 4 - To remove a Contact from the list.")
                .append("\n\t 5 - To search for a Contact in the list.")
                .append("\n\t 6 - To quit the application.\n");

        return sb.toString();
    }

    private static void addNewContact() {

        String name = scanContactName();
        String number = scanContactPhone();
        Contact contact = new Contact(name,number);
        phone.addContact(contact);
    }

    private static void printContacts() {
        phone.printContacts();
    }

    private static void updateContact() {

        System.out.println("Information about the Contact to be edited needed: ");
        String previousContactName = scanContactName();
        Contact previousContact = new Contact(previousContactName);

        System.out.println("Information about the new Contact needed: ");
        String newContactName = scanContactName();
        String newContactPhone = scanContactPhone();
        Contact newContact = new Contact(newContactName,newContactPhone);

        phone.modifyContact(previousContact,newContact);
    }

    private static void removeContact() {

        System.out.println("Information about the Contact to be edited needed: ");

        String previousContactName = scanContactName();
        Contact previousContact = new Contact(previousContactName);

        phone.removeContact(previousContact);
    }

    private static void searchContact() {

        System.out.println("Information about the contact to be searched needed: ");
        String searchName = scanContactName();

        Contact searchContact = new Contact(searchName);

        if (phone.findContact(searchContact) >= 0) {
            System.out.println("Found contact: " + searchName + "At index: " + phone.findContact(searchContact));
        } else {
            System.out.println("Contact couldn't be found on the phone.");
        }
    }

    private static String scanContactName() {

        String contactName;
        System.out.println("Please enter the name of the Contact: \r");
        contactName = s.nextLine();
        return contactName;
    }

    private static String scanContactPhone() {

        String contactPhone;
        System.out.println("Please enter the phone number of the contact: \r");
        contactPhone = s.nextLine();
        return contactPhone;
    }
}
