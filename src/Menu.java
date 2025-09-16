import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        try {
            LMS lms = new LMS("patrons.txt");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Library Management System ---");
                System.out.println("1. Add Patron");
                System.out.println("2. Remove Patron");
                System.out.println("3. List Patrons");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter fine (0-250): ");
                        double fine = scanner.nextDouble();
                        scanner.nextLine();
                        lms.addPatron(new Patron(id, name, address, fine));
                        break;
                    case 2:
                        System.out.print("Enter ID to remove: ");
                        String removeId = scanner.nextLine();
                        lms.removePatron(removeId);
                        break;
                    case 3:
                        lms.listPatrons();
                        break;
                    case 4:
                        System.out.println("Exiting system.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
