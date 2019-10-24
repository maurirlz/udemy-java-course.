package ArraysJavaListsAutoboxingUnboxing.Lists.Arraylist.Challenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static MobilePhone phone = new MobilePhone("0039-0039-0039");

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
    public static void main(String[] args) {

        startPhone();
        printActions();

        Menu:
        while (true) {

            System.out.println("\nEnter action: (6 to show available actions.)");
            int action = s.nextInt();
            s.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Shutting down....");
                    break Menu;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void startPhone() {

        System.out.println("Phone starting....");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\nPress: ");
        System.out.println("\n0 - Shutdown"
                          + "\n1 - Print contacts"
                          + "\n2 - Add contact"
                          + "\n3 - Update existing contact"
                          + "\n4 - Remove existing contact"
                          + "\n5 - Query if contact exists"
                          + "\n6 - Print list of available actions.");
        System.out.println("Choose your action now: ");

    }

    private static void printContacts() {
        phone.printContacts();
    }

    private static void addNewContact() {

        String name = askForName();
        String phoneNumber = askForPhone();
        Contact newContact = Contact.createContact(name,phoneNumber);

        if (phone.addNewContact(newContact)) {

            System.out.println("Contact successfully added.");
        } else {
            System.out.println("Error, cannot add contact, already on file.");
        }
    }

    private static void updateContact() {

        String name = askForName();
        Contact existingContact = phone.queryContact(name);

        if (existingContact == null) {

            System.out.println("Contact not found.");
            return;
        }

        System.out.println("NEW CONTACT INFORMATION NEEDED: ");
        String newName = askForName();
        String newNumber = askForPhone();

        Contact newContact = Contact.createContact(newName,newNumber);
        phone.updateContact(existingContact, newContact);

        if (phone.updateContact(existingContact, newContact)) {

            System.out.println("Successfully updated contact.");
        } else {
            System.out.println("Error updating contact.");
        }
    }

    private static void removeContact() {

        String name = askForName();
        Contact existingContact = phone.queryContact(name);

        if (existingContact == null) {

            System.out.println("Contact not found.");
            return;
        }
        if (phone.removeContact(existingContact)) {
            System.out.println("Successfully deleted.");
        } else {
            System.out.println("error deleting contact.");
        }
    }

    private static void queryContact() {

        String name = askForName();
        Contact existingContact = phone.queryContact(name);

        if (existingContact == null) {

            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContact.getName() + "\nPhone number: " + existingContact.getPhoneNumber());
    }

    private static String askForName() {
        System.out.println("Enter contact name: ");
        return s.nextLine();
    }

    private static String askForPhone() {
        System.out.println("Enter contact phone number: ");
        return s.nextLine();
    }
}
