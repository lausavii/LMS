import java.io.IOException;
import java.util.*;

public class LMS {
    private List<Patron> patrons;
    private FileRepository repo;

    public LMS(String filename) throws IOException {
        repo = new FileRepository(filename);
        patrons = repo.readPatrons();
    }

    public void addPatron(Patron patron) throws IOException {
        for (Patron p : patrons) {
            if (p.getId().equals(patron.getId())) {
                System.out.println("Error: Patron ID already exists.");
                return;
            }
        }
        patrons.add(patron);
        repo.writePatrons(patrons);
    }

    public void removePatron(String id) throws IOException {
        patrons.removeIf(p -> p.getId().equals(id));
        repo.writePatrons(patrons);
    }

    public void listPatrons() {
        for (Patron p : patrons) {
            System.out.println(p);
        }
    }
}
