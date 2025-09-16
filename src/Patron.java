// Class representing a library patron
public class Patron {
    // Private fields for Patron's ID, name, address, and outstanding fine
    private String id;
    private String name;
    private String address;
    private double fine;

    // Constructor: initializes a Patron object with ID, name, address, and fine
    public Patron(String id, String name, String address, double fine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fine = fine;
    }

    // setters and getters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getFine() {
        return fine;
    }

    // Setter method for fine, allows updating the fine amount
    public void setFine(double fine) { this.fine = fine; }

    // Converts the Patron object into a single string with fields separated by '-'
    @Override
    public String toString() {
        return id + "-" + name + "-" + address + "-" + fine;
    }

    // Static method to create a Patron object from a string
    // Expects the string format: "id-name-address-fine"
    public static Patron fromString(String line) {
        // Split the input string into 4 parts
        String[] parts = line.split("-", 4);
        // Create and return a new Patron object using the split values
        return new Patron(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }
}
