package hashing;

public class Book {
    private long ISBN;
    private String author;
    private String name;

    public Book(long ISBN, String author, String name) {
        this.ISBN = ISBN;
        this.author = author;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
