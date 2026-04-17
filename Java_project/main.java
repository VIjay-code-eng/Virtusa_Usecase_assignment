import java.util.*;

public class Main {

    static ArrayList<String> books = new ArrayList<>();
    static ArrayList<String> issuedBooks = new ArrayList<>();

    static void addingBook(Scanner sc) {
        System.out.print("Enter book name: ");
        sc.nextLine();
        String book = sc.nextLine();

        books.add(book);
        System.out.println("Book added successfully!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
        } else {
            System.out.println("\n--- Book List ---");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
            System.out.println("Total Books: " + books.size());
        }
    }

    static void issueBook(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("No books available to issue!");
            return;
        }

        System.out.println("\nAvailable Books:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }

        System.out.print("Enter book number to issue: ");
        int choice = sc.nextInt();

        if (choice > 0 && choice <= books.size()) {
            String book = books.remove(choice - 1);
            issuedBooks.add(book);
            System.out.println("Book issued: " + book);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    static void returnBook(Scanner sc) {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books to return!");
            return;
        }

        System.out.println("\nIssued Books:");
        for (int i = 0; i < issuedBooks.size(); i++) {
            System.out.println((i + 1) + ". " + issuedBooks.get(i));
        }

        System.out.print("Enter book number to return: ");
        int choice = sc.nextInt();

        if (choice > 0 && choice <= issuedBooks.size()) {
            String book = issuedBooks.remove(choice - 1);
            books.add(book);
            System.out.println("Book returned: " + book);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to My Library Management System");

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                addingBook(sc);
            } else if (choice == 2) {
                viewBooks();
            } else if (choice == 3) {
                issueBook(sc);
            } else if (choice == 4) {
                returnBook(sc);
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
