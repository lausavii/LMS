import java.io.IOException;
import java.util.Scanner;

// Class containing the main menu for the Library Management System
public class Menu {
    public static void main(String[] args) {
        try {
            // Initialize the LMS with the file "patrons.txt"
            LMS lms = new LMS("patrons.txt");
            Scanner scanner = new Scanner(System.in);

            // This will display the menu until user exits
            while (true) {
                System.out.println("\n--- Library Management System ---");
                System.out.println("1. Add Patron");
                System.out.println("2. Remove Patron");
                System.out.println("3. List Patrons");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = scanner.nextInt(); // Read user's menu choice
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        // Add a new Patron
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter fine (0-250): ");
                        double fine = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        lms.addPatron(new Patron(id, name, address, fine));
                        break;

                    case 2:
                        // Remove a Patron by ID
                        System.out.print("Enter ID to remove: ");
                        String removeId = scanner.nextLine();
                        lms.removePatron(removeId);
                        break;

                    case 3:
                        // List all patrons
                        lms.listPatrons();
                        break;

                    case 4:
                        // Exit the system
                        System.out.println("Exiting system.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice."); // Handle invalid input
                }
            }
        } catch (IOException e) {
            // Handle file-related errors
            System.out.println("File error: " + e.getMessage());
        }
    }
}
