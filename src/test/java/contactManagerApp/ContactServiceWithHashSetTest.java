package contactManagerApp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class ContactServiceWithHashSetTest {

    static ContactServiceWithHashSet contactServiceWithHashSet;
    static HashSet<Contact> contactHashSet = new HashSet<>();

    @BeforeAll
    static void createContacts() {
        contactHashSet.add(new Contact("Petras","pertas@imone.lt","+37067777777"));
        contactHashSet.add(new Contact("Jonas","jonas@imone.lt","+37067777788"));
        contactHashSet.add(new Contact("Jonas Jonaitis","jonas.j@imone.lt","37067779999"));

        contactServiceWithHashSet = new ContactServiceWithHashSet(contactHashSet);
    }

    @Test
    void testAddContact() {
        Contact newContact = new Contact("Ona", "onyte@imone.lt","+37067777799");

        assertThat(contactServiceWithHashSet.addContact(newContact)).isTrue();
    }

    @Test
    void testSearchContact_foundContact() {
        assertThat(contactServiceWithHashSet.searchContact("jonas").size()).isEqualTo(1);
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
        Contact newContact = new Contact("Jonas","jonas@imone.lt","+37067777788");

        assertThat(contactServiceWithHashSet.removeContact(newContact)).isTrue();
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