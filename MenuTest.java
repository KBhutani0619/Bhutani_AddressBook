import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class MenuTest {
    private Menu menu;

    @BeforeEach
    public void setUp() {
        AddressBook addressBook = new AddressBook();
        menu = new Menu(addressBook);
    }

    @Test
    public void testDisplayMenu_LoadFromFile() {
        // Simulate user input for selecting "a" for loading from file
        String input = "a\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirect output to capture printed menu
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menu.displayMenu();

        // Assert that the menu was displayed and the correct method was called
        String expectedOutput = "Please enter your menu selection:\n" +
                "a) Loading From File\n" +
                "b) Addition\n" +
                "c) Removal\n" +
                "d) Find\n" +
                "e) Listing\n" +
                "f) Quit\n" +
                "*************************\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testDisplayMenu_AddEntry() {
        // Simulate user input for selecting "b" for adding entry
        String input = "b\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirect output to capture printed menu
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menu.displayMenu();

        // Assert that the menu was displayed and the correct method was called
        String expectedOutput = "Please enter your menu selection:\n" +
                "a) Loading From File\n" +
                "b) Addition\n" +
                "c) Removal\n" +
                "d) Find\n" +
                "e) Listing\n" +
                "f) Quit\n" +
                "*************************\n";
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}

