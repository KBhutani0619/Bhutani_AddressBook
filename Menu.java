import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Menu extends AddressBook {
    private Scanner scanner;

    public Menu(AddressBook addressBook) {
        scanner = new Scanner(System.in);
    }



    public void displayMenu() {
        String selection;
        do {
            System.out.println("Please enter your menu selection:");
            System.out.println("a) Loading From File");
            System.out.println("b) Addition");
            System.out.println("c) Removal");
            System.out.println("d) Find");
            System.out.println("e) Listing");
            System.out.println("f) Quit");
            System.out.println("*************************");
            selection =  scanner.nextLine();
            switch (selection) {
                case "a":
                    loadFromFile();
                    break;
                case "b":
                    addEntry();
                    break;
                case "c":
                    removeEntry();
                    break;
                case "d":
                    findEntry();
                    break;
                case "e":
                    listEntries();
                    break;
                case "f":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection, please try again.");
            }
        } while (selection != "f");
    }

    private void loadFromFile() {
        System.out.print("Enter file name: ");
        String fileName = scanner.next();
        try {
            loadFromFile(fileName);
            System.out.println("Entries loaded from file: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    private void addEntry() {
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter street: ");
        String street = scanner.next();
        System.out.print("Enter city: ");
        String city = scanner.next();
        System.out.print("Enter state: ");
        String state = scanner.next();
        System.out.print("Enter zip: ");
        int zip = scanner.nextInt();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter phone: ");
        String phone = scanner.next();

        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);
        addEntry(entry);
        System.out.println("Entry added: " + entry);
    }

    private void removeEntry() {
        System.out.print("Enter last name to remove: ");
        String lastName = scanner.next();
        List<AddressEntry> entriesToRemove = findEntriesByLastName(lastName);
        if (entriesToRemove.isEmpty()) {
            System.out.println("No entries found with last name: " + lastName);
        } else {
            System.out.println("Select entry to remove:");
            for (int i = 0; i < entriesToRemove.size(); i++) {
                System.out.println((i + 1) + ": " + entriesToRemove.get(i));
            }
            int selection = scanner.nextInt() - 1;
            if (selection >= 0 && selection < entriesToRemove.size()) {
                AddressEntry entryToRemove = entriesToRemove.get(selection);
                if (removeEntry(entryToRemove)) {
                    System.out.println("Entry removed: " + entryToRemove);
                } else {
                    System.out.println("Entry not found: " + entryToRemove);
                }
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    private void findEntry() {
        System.out.print("Enter last name to find: ");
        String lastName = scanner.next();
        List<AddressEntry> matchingEntries = findEntriesByLastName(lastName);
        if (matchingEntries.isEmpty()) {
            System.out.println("No entries found with last name: " + lastName);
        } else {
            System.out.println("Matching entries:");
            for (int i = 0; i < matchingEntries.size(); i++) {
                System.out.println((i + 1) + ": " + matchingEntries.get(i));
            }
        }
    }
}
