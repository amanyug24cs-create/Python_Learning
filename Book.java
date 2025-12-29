public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Book is available by default
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}

class Library {
    private Book[] books;
    private int bookCount;
    private static final int MAX_BOOKS = 100; 

    public Library() {
        books = new Book[MAX_BOOKS];
        bookCount = 0;
    }

    public void add(Book book) {
        if (bookCount < MAX_BOOKS) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Book '" + book.getTitle() + "' added to the library.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void issue(int bookId) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId() == bookId) {
                if (books[i].isAvailable()) {
                    books[i].setAvailable(false);
                    System.out.println("Book '" + books[i].getTitle() + "' has been issued.");
                } else {
                    System.out.println("Book '" + books[i].getTitle() + "' is already issued.");
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public void returnBook(int bookId) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId() == bookId) {
                if (!books[i].isAvailable()) {
                    books[i].setAvailable(true);
                    System.out.println("Book '" + books[i].getTitle() + "' has been returned.");
                } else {
                    System.out.println("Book '" + books[i].getTitle() + "' is already in the library.");
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public void display() {
        if (bookCount == 0) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\nLibrary Books:");
        System.out.println("ID\tTitle\t\tAuthor\t\tAvailable");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i].getBookId() + "\t" + 
                              books[i].getTitle() + "\t\t" + 
                              books[i].getAuthor() + "\t\t" + 
                              (books[i].isAvailable() ? "Yes" : "No"));
        }
    }

    public static void main(String[] args) {
       
        Library library = new Library();

        
        library.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.add(new Book(2, "1984", "George Orwell"));
        library.add(new Book(3, "Pride and Prejudice", "Jane Austen"));
        library.add(new Book(4, "To Kill a Mockingbird", "Harper Lee"));

       
        library.display();

        library.issue(2); 
        library.issue(2); 
        library.returnBook(2); 
        library.issue(5); 
        library.returnBook(3); 
        
        library.display();
    }
}