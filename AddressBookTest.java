import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookTest {
    private AddressBook addressBook;

    @BeforeEach
    public void setUp() {
        addressBook = new AddressBook();
    }

    @Test
    public void testAddEntry() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "CA", 12345, "john@example.com", "123-456-7890");
        addressBook.addEntry(entry);
        List<AddressEntry> entries = addressBook.findEntriesByLastName("Doe");
        Assertions.assertEquals(1, entries.size());
        Assertions.assertEquals("John", entries.get(0).getFirstName());
    }

    @Test
    public void testRemoveEntry() {
        AddressEntry entry = new AddressEntry("Jane", "Smith", "456 Oak St", "Othertown", "NY", 54321, "jane@example.com", "987-654-3210");
        addressBook.addEntry(entry);
        List<AddressEntry> entriesBeforeRemoval = addressBook.findEntriesByLastName("Smith");
        Assertions.assertEquals(1, entriesBeforeRemoval.size());

        boolean removed = addressBook.removeEntry(entry);
        Assertions.assertTrue(removed);

        List<AddressEntry> entriesAfterRemoval = addressBook.findEntriesByLastName("Smith");
        Assertions.assertTrue(entriesAfterRemoval.isEmpty());
    }

    @Test
    public void testFindEntriesByLastName_NonexistentLastName() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "CA", 12345, "john@example.com", "123-456-7890");
        addressBook.addEntry(entry);

        // Attempt to find entries with a last name that doesn't exist in the address book
        List<AddressEntry> entries = addressBook.findEntriesByLastName("Smith");

        // Assert that no entries were found
        Assertions.assertTrue(entries.isEmpty()); // This assertion will fail because an entry with the last name "Smith" was not added
    }
}
