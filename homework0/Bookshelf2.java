package homework0;

import java.util.ArrayList;
import java.util.List;


/**
 * A container that can be used to store Books. A given Book may only
 * appear in a Bookshelf once.
 */
public class Bookshelf2 {
    List<Book> shelf;
    int numOfPages;
    
    /**
     * @effects Creates a new empty Bookshelf.
     */
    public Bookshelf2() {
        this.shelf = new ArrayList<>();
        numOfPages = 0;
    }

    /**
     * @modifies this
     * @effects Adds book to the Bookshelf.
     * @return true if the book was successfully added,
     *         i.e. the book was not already in the Bookshelf; false otherwise.
     */
    public boolean addBook(Book book) {
        // Boolean success = shelf.add(book);
        // if(success){
        //     numOfPages += book.getPages();
        // }
        // return success;
        
        if(shelf.add(book)){
            numOfPages += book.getPages();
            return true;
        }
        else return false;
    }

    /**
     * @modifies this
     * @effects Removes book from the Bookshelf.
     * @return true if the book was successfully removed,
     *         i.e. the book was in the Bookshelf; false otherwise.
     */
    public boolean removeBook(Book book) {
        return shelf.remove(book);
    }

    /**
     * @return the total number of pages in all the books in the Bookshelf.
     */
    public int getTotalPages() {
        return numOfPages;
    }

    /**
     * @return the number of books in the Bookshelf.
     */
    public int size() {
        return shelf.size();
    }

    /**
     * @modifies this
     * @effects Empties the Bookshelf, i.e., removes all books.
     */
    public void clear() {
        shelf.clear();
    }

    /**
     * @return true if this Bookshelf contains the book; false otherwise.
     */
    public boolean contains(Book book) {
        return shelf.contains(book);
    }
}

