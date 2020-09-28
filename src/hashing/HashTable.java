package hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable {
    ArrayList<Book> books = new ArrayList<>();

    // insert
    public void add(Book x) {
        books.add(x);
    }
    // remove
    public void remove(int index, Book x) {
    }
    // find
    public int find(Book x) {
        try {
            return hash(x);
        }
        catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }
    // print
    public void printOut() {
        System.out.println('[');
        for(Book x : books)
            System.out.println(x);
        System.out.println(']');

    }

    // hash
    public int hash(Book x) {
        return 0;
    }
}
