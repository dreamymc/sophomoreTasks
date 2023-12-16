
import java.util.*;

public class implementation extends myAbstract {
    Scanner mbl = new Scanner(System.in);
    private String[] catalogue = new String[10];
    private HashMap<String, String> books = new HashMap<>();

    public void remove() {
        System.out.print("Enter the book name or ISBN you want to borrow: ");
        String search = mbl.nextLine();
        mbl.nextLine();
        Map<String, String> result = searchHashMap(books, search);

        if (!result.isEmpty())
            for (Map.Entry<String, String> entry : result.entrySet()) {
                System.out.print("Book borrowed ISBN: " + entry.getKey() + ", Book name: " + entry.getValue());
                books.remove(entry.getKey());
                for (int i = 0; i < catalogue.length; i++)
                    if (catalogue[i].equals(entry.getKey()))
                        catalogue[i] = null;
            }
        else
            System.out.println("No book found.");

    }

    public void search() {
        System.out.print("Enter the book name or ISBN you want to search for: ");
        String searchKeyOrValue = mbl.nextLine();
        mbl.nextLine();
        Map<String, String> result = searchHashMap(books, searchKeyOrValue);

        if (!result.isEmpty()) {
            for (Map.Entry<String, String> entry : result.entrySet()) {
                System.out.print("Book found! ISBN: " + entry.getKey() + ", Book name: " + entry.getValue());
                for (int i = 0; i < catalogue.length; i++)
                    if (catalogue[i] != null)
                        if (catalogue[i].equalsIgnoreCase(entry.getKey()))
                            System.out.println(" Book found at index " + i);
            }
        } else
            System.out.println("No book found.");

    }

    public Map<String, String> searchHashMap(Map<String, String> map, String searchStr) {
        Map<String, String> result = new HashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().contains(searchStr) || entry.getValue().contains(searchStr)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    public void linearProbing(int x, String isbn) {
        int i = 1;
        while (true) {
            int h = (x + i) % catalogue.length;
            if (catalogue[h] == null) {
                catalogue[h] = isbn;
                break;
            } else
                i++;

        }
    }

    public void addingBooks(String isbn, String title) {
        books.put(isbn, title);
        int x = Math.abs(isbn.hashCode()) % catalogue.length;
        System.out.println("index is " + x);
        if (catalogue[x] == null)
            catalogue[x] = isbn;
        else
            linearProbing(x, isbn);
    }

    public void addBook() {
        System.out.print("Enter the ISBN: ");
        String isbn = mbl.next();
        mbl.nextLine();
        System.out.print("Enter the title of the Book: ");
        String title = mbl.nextLine();
        addingBooks(isbn, title);
    }

    public void print() {
        System.out.println("Catalogue contains: ");
        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] != null)
                System.out.printf("%s: %s\n", catalogue[i], books.get(catalogue[i]));
            else
                System.out.println("null");
        }
        System.out.println();
    }

    public void run() {
        print();
        System.out.print("[0] Close the program\n[1] Add a new book\n" +
                "[2] Search for a book\n" +
                "[3] Borrow a book\n" +
                "Choose a command: ");
        int choice = mbl.nextInt();
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                search();
                break;
            case 3:
                remove();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input.");
        }
        System.out.println();
        this.run();
    }
}