import java.util.Scanner;

class Book {

    private String name;
    private String author;
    private double price;
    private int numPages;


    public Book(String name, String author, double price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getNumPages() {
        return numPages;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "Book [Name: " + name + ", Author: " + author + ", Price: " + price + ", Number of Pages: " + numPages + "]";
    }
}

public class BookStore {
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of books you want to create: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

      
        Book[] books = new Book[n];


        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");

            System.out.print("Enter book name: ");
            String name = scanner.nextLine();

            System.out.print("Enter author name: ");
            String author = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter number of pages: ");
            int numPages = scanner.nextInt();
            scanner.nextLine(); 

 
            books[i] = new Book(name, author, price, numPages);
        }

        System.out.println("\nBook Details:");
        for (Book book : books) {
            System.out.println(book);  
        }

 
        scanner.close();
    }
}
