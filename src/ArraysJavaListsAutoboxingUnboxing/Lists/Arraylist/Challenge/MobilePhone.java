package ArraysJavaListsAutoboxingUnboxing.Lists.Arraylist.Challenge;

import java.util.ArrayList;
import java.util.Objects;

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

    private ArrayList<Contact> contacts;
    private String myNumber;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {

        if (findContact(contact.getName()) >= 0) {

            System.out.println("Contact already on file!");
            return false;
        }
        contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {

        int foundPosition = findContact(oldContact);

        if (foundPosition < 0) {

            System.out.println(oldContact.getName() + " Was not found.");
            return false;
        } else if (findContact(newContact.getName()) != -1) {

            System.out.println("Contact with name: " + newContact.getName() + " Already exists.");
            return false;
        }

        this.contacts.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + " was replaced with: " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {

        int position = findContact(contact);

        if (findContact(contact) < 0) {
            System.out.println("Contact not found in file.");
            return false;
        }

        this.contacts.remove(position);
        System.out.println(contact.getName() + " Was removed from the list.");
        return true;
    }


    private int findContact(Contact contact) {

        return this.contacts.indexOf(contact);
    }

    // Validacion para asegurarme de que un objeto se encuentra dentro del arraylist.

    private int findContact(String contactName) {
        for (int i = 0; i < this.contacts.size(); i++) {

            Contact contact = this.contacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.contacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        int count = 1;
        if (contacts.size() > 0) {
            System.out.println("Contact list: ");
            for (Contact contact : contacts) {
                System.out.println(count + " - " + "Name: " + contact.getName()
                        + "\nPhone number: " + contact.getPhoneNumber() + "\n");
                count++;
            }
        } else {
            System.out.println("Contact list is empty.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobilePhone)) return false;
        MobilePhone that = (MobilePhone) o;
        return Objects.equals(contacts, that.contacts) &&
                Objects.equals(myNumber, that.myNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contacts, myNumber);
    }
}
