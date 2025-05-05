package homework0;


/**
 * This is a container that can be used to contain Books. The key difference
 * between a Bookshelf and a Library is that a Library has a finite capacity.
 * Once a Library is full, we cannot add more books to it.
 */
public class Library {
    int maxPages;
    Bookshelf2 bookshelf;
    /**
     * @param maxPages - Total number of pages that this Library can contain.
     * @effects Creates a new Library.
     */
    public Library(int maxPages) {
        this.maxPages = maxPages;
        this.bookshelf = new Bookshelf2();
    }

    /**
     * @modifies this
     * @effects Adds book to the Library.
     * @return true if the book was successfully added to the Library,
     *         i.e. the book is not already in the Library and
     *         the Library has enough capacity;
     *         false otherwise.
     */
    public boolean addBook(Book book) {
        if (bookshelf.getTotalPages() + book.getPages() <= maxPages){
            return bookshelf.addBook(book);
        }
        return false;
    }

    /**
     * @modifies this
     * @effects Removes book from the Library.
     * @return true if the book was successfully removed from the Library,
     *         i.e. the book was in the Library; false otherwise.
     */
    public boolean removeBook(Book book) {
        return bookshelf.removeBook(book);
    }

    /**
     * @return the total number of pages in all the books in the Library.
     */
    public int getTotalPages() {
        return bookshelf.getTotalPages();
    }

    /**
     * @return the number of books in the Library.
     */
    public int size() {
        return bookshelf.size();
    }

    /**
     * @modifies this
     * @effects Empties the Library.
     */
    public void clear() {
        bookshelf.clear();
    }

    /**
     * @return true if this Library contains the book; false otherwise.
     */
    public boolean contains(Book book) {
        return bookshelf.contains(book);
    }
}
