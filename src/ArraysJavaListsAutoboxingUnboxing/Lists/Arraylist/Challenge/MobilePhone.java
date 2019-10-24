package ArraysJavaListsAutoboxingUnboxing.Lists.Arraylist.Challenge;

import java.util.ArrayList;

public class MobilePhone {

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

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact newContact) {
        if (!contacts.contains(newContact)) {

            contacts.add(newContact);
        } else {
            System.out.println("Contact already on the list.");
        }
    }

    public void printContacts() {

        if (contacts.size() <= 0){
            System.out.println("No contacts available.");
        }

        System.out.println("You have " + contacts.size()
                + " contacts on your phone.");

        for (Contact contact : contacts) {

            System.out.println("Contact name: " + contact.getName()
                              + "Contact phone number: " + contact.getPhoneNumber());
        }
    }

    public void modifyContact(Contact currentContact, Contact newContact) {

        int position = contacts.indexOf(currentContact);
        if (position >= 0) {

            modifyContact(position, newContact);
        }
    }

    private void modifyContact(int position, Contact contact) {

        contacts.set(position, contact);
        System.out.println("Contact has been successfully modifed.");
    }

    public void removeContact(Contact currentContact) {

        int position = findContact(currentContact);
        if (position >= 0) {

            removeContact(position);
        }
    }

    private void removeContact(int position) {

        contacts.remove(position);
        System.out.println("Contact removed.");
    }

    public int findContact(Contact contact) {


        if (onList(contact)) {

            return contacts.indexOf(contact);
        } else {

            System.out.println("Contact not found, returning -1.");
            return -1;
        }
    }

    private boolean onList(Contact contact) {

        int position = findContact(contact);
        return position >= 0;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
