import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String category;
    private double price;
    private String author;
    private String isbn;
    private int quantity;

    public Book(String title, String category, double price, String author, String isbn, int quantity) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public int sell(int quantity) {
        int soldQuantity = Math.min(this.quantity, quantity);
        if (this.quantity > 0) {
            this.quantity -= soldQuantity;
        } else {
            System.out.println("Sold all " + this.title + " we have in stock");
        }
        return soldQuantity;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }
}

class BookStore {
    private List<Book> books;
    private double totalPrice;

    public BookStore() {
        this.books = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> searchByCategory(String category) {
        List<Book> categoryBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                categoryBooks.add(book);
            }
        }
        return categoryBooks;
    }

    public void sellBook(String title, int quantity) {
        Book book = searchByTitle(title);
        if (book != null) {
            int soldQuantity = book.sell(quantity);
            this.totalPrice += book.getPrice() * soldQuantity;
        } else {
            System.out.println("Sorry " + title + " doesn't exist in the bookstore.");
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

public class Main {
    public static void main(String[] args) {
        BookStore bookBless = new BookStore();

        Book book1 = new Book("Humble Pi: A Comedy of Maths Errors", "Humor", 23.82, "Matt Parker", "978-0241360231", 2);
        Book book2 = new Book("I Can't Make This Up: Life Lessons", "Humor", 29.66, "Kevin Hart", "978-1501155567", 3);
        Book book3 = new Book("You Can Be Funny and Mank People Laugh: No Fluff", "Humor", 19.63, "Greg Dean", "978-1890905241", 5);
        Book book4 = new Book("Two Years On A Bike: From Vancouver to Patagonia", "Adventure", 78.0, "Martijn Doolaard", "978-9082885408", 10);
        Book book5 = new Book("The Man's Guide to Women: Scientifically Proven Secrets from the Love Lab About What Women Really Want", "Relationship", 26.99, "John Gottman", "978-1623361846", 8);
        Book book6 = new Book("Getting the Love You Want: A Guide for Couples", "Relationship", 18.99, "Harville Hendrix", "978-0805087000", 1);

        bookBless.addBook(book1);
        bookBless.addBook(book2);
        bookBless.addBook(book3);
        bookBless.addBook(book4);
        bookBless.addBook(book5);
        bookBless.addBook(book6);

        System.out.println("Humor Books:");
        printBooks(bookBless.searchByCategory("Humor"));

        System.out.println("Current total earnings: " + bookBless.getTotalPrice());
        String title = "The Man's Guide to Women: Scientifically Proven Secrets from the Love Lab About What Women Really Want";
        bookBless.sellBook(title, 3);
        System.out.println("Current total earnings: " + bookBless.getTotalPrice());
    }

    public static void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Category: " + book.getCategory() +
                    ", Price: " + book.getPrice() + ", Quantity: " + book.getQuantity());
        }
    }
}
