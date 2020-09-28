package hashing;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        HashTable books = new HashTable();
        books.add(new Book(5, "Her", "he"));
        books.add(new Book(6, "Hwe", "hgj"));
        books.add(new Book(7, "wetr", "sdf"));
        books.printOut();
    }
}
