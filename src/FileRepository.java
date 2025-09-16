import java.io.*;
import java.util.*;

public class FileRepository {
    private File file;

    public FileRepository(String filename) {
        this.file = new File(filename);
    }

    public List<Patron> readPatrons() throws IOException {
        List<Patron> patrons = new ArrayList<>();
        if (!file.exists()) return patrons;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                patrons.add(Patron.fromString(line));
            }
        }
        return patrons;
    }

    public void writePatrons(List<Patron> patrons) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Patron p : patrons) {
                bw.write(p.toString());
                bw.newLine();
            }
        }
    }
}
