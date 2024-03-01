import java.util.*;
import java.io.*;

public class AddressBook {
    private List<AddressEntry> entries;


    public AddressBook() {
        entries = new ArrayList<>();
    }

    public void addEntry(AddressEntry entry) {
        entries.add(entry);
    }

    public boolean removeEntry(AddressEntry entry) {
        return entries.remove(entry);
    }

    public List<AddressEntry> findEntriesByLastName(String lastName) {
        List<AddressEntry> matchingEntries = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getLastName().startsWith(lastName)) {
                matchingEntries.add(entry);
            }
        }
        return matchingEntries;
    }

    public void listEntries() {
        Collections.sort(entries, new Comparator<AddressEntry>() {
            @Override
            public int compare(AddressEntry e1, AddressEntry e2) {
                return e1.getLastName().compareToIgnoreCase(e2.getLastName());
            }
        });
        for (AddressEntry entry : entries) {
            System.out.println(entry);
        }
    }

    public void loadFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(",");
            AddressEntry entry = new AddressEntry(parts[0], parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), parts[6], parts[7]);
            addEntry(entry);
        }
    }
}


