package contactManagerApp;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactServiceWithHashSet {
    public static final String CONTACT_LIST = "src/main/resources/ContactList";

    private static final Logger LOGGER = Logger.getLogger(ContactServiceWithHashSet.class);

    private HashSet<Contact> myContacts = new HashSet<>();

    public ContactServiceWithHashSet() {
    }

    public ContactServiceWithHashSet(HashSet<Contact> myContacts) {
        this.myContacts = myContacts;
    }

    public HashSet<Contact> getMyContacts() {
        return myContacts;
    }

    public void setMyContacts(HashSet<Contact> myContacts) {
        this.myContacts = myContacts;
    }

    public void collectContacts() throws IOException {
        FileReader contactFile = new FileReader(CONTACT_LIST);

        try(BufferedReader bufferedReader = new BufferedReader(contactFile)) {
            String singleLine;

            while((singleLine = bufferedReader.readLine()) != null){
                String[] line = singleLine.split(",");

                Contact contact = new Contact(line[0],line[1], line[2]);
                myContacts.add(contact);
            }
        } catch(IOException e){
            System.out.println("Nerastas failas:" + e);
        }
    }

    public void showContactsList() {
        System.out.println("[< MY CONTACTS>]");
        for (Contact myContact : myContacts) {
            if(myContact != null) {
                System.out.println(myContact);
            }
        }
        System.out.println("[< END OF MY CONTACTS>]");
    }

    public boolean addContact(Contact contactToAdd) {
        LOGGER.info("Adding contact " + contactToAdd);
        myContacts.add(contactToAdd);
        System.out.println("Contact " + contactToAdd + " was added");
        return myContacts.contains(contactToAdd);
    }

    public HashSet<Contact> searchContact(String fullName) {
        LOGGER.info("Searching contact " + fullName);
        HashSet<Contact> foundContacts= new HashSet<>();

        for (Contact contact : myContacts) {
            if(contact.getName().equalsIgnoreCase(fullName)) {
                foundContacts.add(contact);
            }
        }

        return foundContacts;
    }

    public HashSet<Contact> getContactsByGivenString(String givenString) {
        LOGGER.info("Searching contact by name part " + givenString);
        HashSet<Contact> foundContacts= new HashSet<>();

        for (Contact contact : myContacts) {
            if (contact.getName().toUpperCase().contains(givenString.toUpperCase())) {
                foundContacts.add(contact);
            }
        }

        return foundContacts;
    }

    public boolean removeContact(String contactNameToRemove) {
        LOGGER.info("Removing contact " + contactNameToRemove);

        boolean isContactRemoved = false;
        Iterator<Contact> iterator = myContacts.iterator();

        while (iterator.hasNext()) {
            Contact nextContact = iterator.next();
            if (contactNameToRemove.equalsIgnoreCase(nextContact.getName())) {
                iterator.remove();
                isContactRemoved = true;
            }
        }

        System.out.println("Contact " + contactNameToRemove + " was removed");
        return isContactRemoved;
    }

    public boolean isNotPhoneNumber(String phone) {
        LOGGER.info("Checking phone number " + phone);
        Pattern p = Pattern.compile("(86|\\+3706)\\d{7}");
        Matcher m = p.matcher(phone);

        return !m.matches();
    }

    public boolean isNotEmailAddress(String email) {
        LOGGER.info("Checking email " + email);
        Pattern p = Pattern.compile("(.*)(@)(.*)(.[a-z]{2,3})");
        Matcher m = p.matcher(email);

        return !m.matches();
    }
}
