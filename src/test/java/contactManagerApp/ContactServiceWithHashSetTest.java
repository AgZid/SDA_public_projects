package contactManagerApp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ContactServiceWithHashSetTest {

    static ContactServiceWithHashSet contactServiceWithHashSet;

    @BeforeAll
    static void setUp() {

    }

    @BeforeEach
    void createContacts() {
        HashSet<Contact> contactHashSet = new HashSet<>();

        contactHashSet.add(new Contact("Petras","pertas@imone.lt","+37067777777"));
        contactHashSet.add(new Contact("Jonas","jonas@imone.lt","+37067777788"));
        contactHashSet.add(new Contact("Jonas Jonaitis","jonas.j@imone.lt","37067779999"));

        contactServiceWithHashSet = new ContactServiceWithHashSet(contactHashSet);
    }

    @Test
    void testAddContact() {
        Contact newContact = new Contact("Ona", "onyte@imone.lt","+37067777799");

        assertThat(contactServiceWithHashSet.addContact(newContact)).isTrue();
        assertThat(contactServiceWithHashSet.getMyContacts().size()).isEqualTo(4);
    }

    @Test
    void testSearchContact_foundContact() {
        Set<Contact> foundContacts = contactServiceWithHashSet.searchContact("jonas");
        Contact jonas = null;

        for (Contact foundContact : foundContacts) {
            jonas = foundContact;
        }
        assertThat(foundContacts.size()).isEqualTo(1);
        assertThat(jonas.getName()).isEqualTo("Jonas");
        assertThat(jonas.getEmail()).isEqualTo("jonas@imone.lt");
        assertThat(jonas.getPhoneNumber()).isEqualTo("+37067777788");
    }

    @Test
    void testSearchContact_notFoundContact() {
          assertThat(contactServiceWithHashSet.searchContact("julius").size()).isEqualTo(0);
    }

    @Test
    void testGetContactsByGivenString_foundContact() {
        assertThat(contactServiceWithHashSet.getContactsByGivenString("jo").size()).isEqualTo(2);
    }

    @Test
    void testGetContactsByGivenString_notFoundContact() {
        assertThat(contactServiceWithHashSet.getContactsByGivenString("pu").size()).isEqualTo(0);
    }

    @Test
    void testRemoveContact() {
        assertThat(contactServiceWithHashSet.removeContact("petras")).isTrue();
        assertThat(contactServiceWithHashSet.getMyContacts().size()).isEqualTo(2);
    }

    @Test
    void testIsNotPhoneNumber_validNumber() {
        String phoneNumber1 = "+37062222222";
        String phoneNumber2 = "862222222";

        assertThat(contactServiceWithHashSet.isNotPhoneNumber(phoneNumber1)).isFalse();
        assertThat(contactServiceWithHashSet.isNotPhoneNumber(phoneNumber2)).isFalse();
    }

    @Test
    void testIsNotPhoneNumber_invalidNumber() {
        String phoneNumber1 = "123698547";
        String phoneNumber2 = "+123698547";

        assertThat(contactServiceWithHashSet.isNotPhoneNumber(phoneNumber1)).isTrue();
        assertThat(contactServiceWithHashSet.isNotPhoneNumber(phoneNumber2)).isTrue();
    }


    @Test
    void testIsNotEmailAddress_invalidNumber() {
        String email = "contact@contact.com";

        assertThat(contactServiceWithHashSet.isNotEmailAddress(email)).isFalse();
    }

    @Test
    void testIsNotEmailAddress_validNumber() {
        String email = "contact.com";

        assertThat(contactServiceWithHashSet.isNotEmailAddress(email)).isTrue();
    }
}