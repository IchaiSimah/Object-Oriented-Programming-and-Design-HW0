package homework0;

/**
 * A simple test program to demonstrate the functionality of Book and Bookshelf using printf.
 */
public class TestBookshelf {
    public static void main(String[] args) {
        Bookshelf shelf = new Bookshelf();

        Book b1 = new Book(100);
        Book b2 = new Book(200);
        Book b3 = new Book(150);

        System.out.println("Adding books:");
        System.out.printf("Add b1: %b\n", shelf.addBook(b1));   // true
        System.out.printf("Add b2: %b\n", shelf.addBook(b2));   // true
        System.out.printf("Add b1 again: %b\n", shelf.addBook(b1)); // false (duplicate)
        System.out.printf("Add b3: %b\n", shelf.addBook(b3));

        System.out.printf("\nBookshelf contains b2? %b\n", shelf.contains(b2));
        System.out.printf("Current size: %d\n", shelf.size());
        System.out.printf("Total pages: %d\n", shelf.getTotalPages());

        System.out.printf("\nRemoving book b2: %b\n", shelf.removeBook(b2));
        System.out.printf("Contains b2? %b\n", shelf.contains(b2));
        System.out.printf("\nRemoving book b3: %b\n", shelf.removeBook(b3));

        System.out.printf("\nFinal shelf: %s\n", shelf);

        System.out.println();
        System.out.println("Clearing bookshelf.");
        shelf.clear();
        System.out.printf("Size after clear: %d\n", shelf.size());
    }
}
