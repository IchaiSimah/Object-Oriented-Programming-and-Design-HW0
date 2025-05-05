package homework0;

/**
 * A simple object that represents a book with a number of pages.
 */
public class Book {
   private int pages;
    /**
     * @requires pages > 0
     * @modifies this
     * @effects Creates and initializes a new Book object with the specified
     *          number of pages.
     */
    public Book(int pages) {
        assert(pages > 0);
        this.pages = pages;
    }

    /**
     * @requires pages > 0
     * @modifies this
     * @effects Sets the number of pages in the Book.
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * @return the number of pages in the Book.
     */
    public int getPages() {
        return pages;
    }
}
