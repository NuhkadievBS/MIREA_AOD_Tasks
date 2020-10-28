package task_3;

// Класс, описывающий логику книги
public class Book {
    private final Long ISBN; // ID книги, который выступает ключом в таблице
    private final String author; // Автор книги
    private final String name; // Название книги

    // Инициализация значений в конструкторе
    public Book(Long ISBN, String author, String name) {
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

    public Long getISBN() {
        return ISBN;
    }
}
