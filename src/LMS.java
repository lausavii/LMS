import java.io.IOException;
import java.util.*;

// Class representing a simple Library Management System (LMS)
public class LMS {
    // List to save all patrons added into the system
    private List<Patron> patrons;

    // FileRepository to handle reading/writing Patron data to a file
    private FileRepository repo;

    // Constructor: initializes the LMS and loads existing patrons from a file
    public LMS(String filename) throws IOException {
        repo = new FileRepository(filename); // Create a repository for the file
        patrons = repo.readPatrons();       // Load existing patrons into the list
    }

    // Method to add a new Patron
    public void addPatron(Patron patron) throws IOException {
        // Check if a patron with the same ID already exists
        for (Patron p : patrons) {
            if (p.getId().equals(patron.getId())) {
                System.out.println("Error: Patron ID already exists.");
                return; // Exit without adding duplicate
            }
        }
        patrons.add(patron);           // Add the new patron to the list
        repo.writePatrons(patrons);    // Save the updated list to the file
    }

    // Method to remove a Patron by ID
    public void removePatron(String id) throws IOException {
        // Remove any Patron whose ID matches
        patrons.removeIf(p -> p.getId().equals(id));
        repo.writePatrons(patrons);    // Save the updated list to the file
    }

    // Method to list all patrons to the console
    public void listPatrons() {
        for (Patron p : patrons) {
            System.out.println(p);     // Uses Patron.toString() to display patron info
        }
    }
}
