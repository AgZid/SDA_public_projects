package contactManagerApp;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactMainWithHasSet {
    Scanner scanner = new Scanner(System.in);
    ContactServiceWithHashSet contactServiceWithHashSet = new ContactServiceWithHashSet();

    public static void main(String[] args) throws IOException {
        new ContactMainWithHasSet().showMenu();

    }

    public void showMenu() throws IOException {
        System.out.println("Welcome to Contact management application");
        char userSelectedOption;

        ContactServiceWithHashSet.collectContacts();

        do {
            System.out.println();
            System.out.println("Select an option form the list:");

            provideOptions();

            userSelectedOption = scanner.nextLine().charAt(0);

            executeContactService(userSelectedOption);

        } while (userSelectedOption != 'E');

    }

    private void executeContactService(char userSelectedOption) {
        if (userSelectedOption == '1') {
            contactServiceWithHashSet.showContactsList();
        } else if (userSelectedOption == '2') {
            System.out.println("Enter full name:");
            printFoundContacts(contactServiceWithHashSet.searchContact(scanner.nextLine()));
        } else if (userSelectedOption == '3') {
            System.out.println("Enter part of the name:");
            printFoundContacts(contactServiceWithHashSet.getContactsByGivenString(scanner.nextLine()));
        } else if (userSelectedOption == '4') {
             contactServiceWithHashSet.addContact(createNewContact());
            contactServiceWithHashSet.showContactsList();
        } else if (userSelectedOption == '5') {
            System.out.println("Enter full name:");
            for (Contact foundContact : contactServiceWithHashSet.searchContact(scanner.nextLine())) {
                contactServiceWithHashSet.removeContact(foundContact);
            }
            contactServiceWithHashSet.showContactsList();
        } else if (userSelectedOption == 'E'){
            System.out.println("Exiting application...");
        } else {
            System.out.println("Incorrect option, choose another option");
        }

    }

    private Contact createNewContact() {
        System.out.println("Enter name");
        String name = scanner.nextLine();

        while (!contactServiceWithHashSet.searchContact(name).isEmpty()){
            System.out.println("Contact " + name + " already exits, enter another name");
            name = scanner.nextLine();
        }

        System.out.println("Enter email");
        String email = scanner.nextLine();

        while (contactServiceWithHashSet.isNotEmailAddress(email)) {
            System.out.println("Wrong email " + email + ", enter correct email");
            email = scanner.nextLine();
        }

        System.out.println("Phone number");
        String phone = scanner.nextLine();
        while (contactServiceWithHashSet.isNotPhoneNumber(phone)) {
            System.out.println("Wrong phone number " + phone + ", enter correct phone number");
            phone = scanner.nextLine();
        }

        return new Contact(name, email, phone);
    }

    private void printFoundContacts(HashSet<Contact> foundContacts) {
        if (!foundContacts.isEmpty()) {
            System.out.println("Contact was found:");
            for (Contact foundContact : foundContacts) {
                System.out.println(foundContact);
            }
        } else {
            System.out.println("Contact not found");
        }
    }

    public void provideOptions() {
        System.out.println("1 - view all contact list");
        System.out.println("2 - find contact by full name");
        System.out.println("3 - find contact by part of the name");
        System.out.println("4 - add contact");
        System.out.println("5 - remove contact from the list");
        System.out.println("E - exit application");
    }
}


