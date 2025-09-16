public class Patron {
    private String id;
    private String name;
    private String address;
    private double fine;

    public Patron(String id, String name, String address, double fine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fine = fine;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public double getFine() { return fine; }
    public void setFine(double fine) { this.fine = fine; }

    @Override
    public String toString() {
        return id + "-" + name + "-" + address + "-" + fine;
    }

    public static Patron fromString(String line) {
        String[] parts = line.split("-", 4);
        return new Patron(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }
}
