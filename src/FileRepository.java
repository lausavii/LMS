import java.io.*;
import java.util.*;

// Class for handling reading and writing Patron objects to a file
public class FileRepository {
    // File object representing the file where Patron data will be stored
    private File file;

    // Constructor: initializes FileRepository with a filename
    public FileRepository(String filename) {
        this.file = new File(filename);
    }

    // Reads Patron objects from the file and returns them as a List
    public List<Patron> readPatrons() throws IOException {
        List<Patron> patrons = new ArrayList<>();

        // If the file does not exist, return an empty list
        if (!file.exists()) return patrons;


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            // Read each line and convert it into a Patron object
            while ((line = br.readLine()) != null) {
                patrons.add(Patron.fromString(line));
            }
        }

        return patrons; // Return the list of Patron objects
    }

    // Writes a List of Patron objects to the file
    public void writePatrons(List<Patron> patrons) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Patron p : patrons) {
                // Convert each Patron to a string and write to file
                bw.write(p.toString());
                bw.newLine(); // Add a new line after each Patron
            }
        }
    }
}
