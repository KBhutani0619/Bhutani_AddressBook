import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressEntryTest {
    @Test
    public void testToString() {
        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "CA", 12345, "john@example.com", "123-456-7890");

        // Test the toString() method
        String expectedOutput = "AddressEntry{firstName='John', lastName='Doe', street='123 Main St', city='Anytown', state='CA', zip=12345, email='john@example.com', phone='123-456-7890'}";
        Assertions.assertEquals(expectedOutput, entry.toString());
    }

    @Test
    public void testGettersAndSetters() {
        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry();

        // Set values using setters
        entry.setFirstName("Jane");
        entry.setLastName("Smith");
        entry.setStreet("456 Oak St");
        entry.setCity("Othertown");
        entry.setState("NY");
        entry.setZip(54321);
        entry.setEmail("jane@example.com");
        entry.setPhone("987-654-3210");

        // Test values using getters
        Assertions.assertEquals("Jane", entry.getFirstName());
        Assertions.assertEquals("Smith", entry.getLastName());
        Assertions.assertEquals("456 Oak St", entry.getStreet());
        Assertions.assertEquals("Othertown", entry.getCity());
        Assertions.assertEquals("NY", entry.getState());
        Assertions.assertEquals(54321, entry.getZip());
        Assertions.assertEquals("jane@example.com", entry.getEmail());
        Assertions.assertEquals("987-654-3210", entry.getPhone());
    }

    @Test
    public void testGettersAndSetters2() {
        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry();

        // Set values using setters
        entry.setFirstName("Jane");
        entry.setLastName("Smith");
        entry.setStreet("456 Oak St");
        entry.setCity("Othertown");
        entry.setState("NY");
        entry.setZip(54321);
        entry.setEmail("jane@example.com");
        entry.setPhone("987-654-3210");

        // Test values using getters
        Assertions.assertEquals("Jane", entry.getFirstName());
        Assertions.assertEquals("Smith", entry.getLastName());
        Assertions.assertEquals("456 Oak St", entry.getStreet());
        Assertions.assertEquals("Othertown", entry.getCity());
        Assertions.assertEquals("NY", entry.getState());
        Assertions.assertEquals(54321, entry.getZip());
        Assertions.assertEquals("jane@example.com", entry.getEmail());
        Assertions.assertEquals("987-654-3210", entry.getPhone());
    }
}
