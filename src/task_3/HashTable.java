package task_3;

import java.util.LinkedList;

public class HashTable {
    private final int MAXSIZE = 10; // Начальный размер таблицы
    private LinkedList<Book>[] books = new LinkedList[MAXSIZE]; // Инициализация таблицы

    public HashTable() {
        for (int i = 0; i < MAXSIZE; i++) {
            books[i] = null;
        }
    }

    //Метод добавления элемента в таблицу
    public void add(Book valueToAdd) {

        int hash = calcHashValue(valueToAdd.getISBN()); // Высчитываем хеш-функцией индекс в таблице
        // Инициализируем список при вычисленном индексе для элемента
        if (books[hash] == null) {
            books[hash] = new LinkedList<>();
        }
        System.out.println("Adding element at index: " + hash);

        // Добавление в начало списка требуемого элемента. Это обспечивает константную сложность
        books[hash].addFirst(valueToAdd);
    }

    // Хеш-функция, хеширование производится по модулю размера массива
    private int calcHashValue(Long key) {
        return (int) (long) (key % MAXSIZE);
    }

    // Метод вывода значений таблицы
    public void printOut() {
        for (int i = 0; i < MAXSIZE; i++) {
            if(books[i] != null) {
                for (Object x : books[i]) {
                    System.out.println("Value is at index " + i + ": " + x);
                }
            }
        }
    }

    // Метод удаления элемента из таблицы по ключу
    public void removeValue(long key) {
        int hash = calcHashValue(key);
        if (books[hash] == null) { // Если список по индексу пуст, то искомого значения в таблице нет
            System.out.println("No such value in table");
            return;
        }

        // Проходим по списку по индексу, и ищем нужное значение
        for(Book x : books[hash]) {
            if(key == x.getISBN()) {
                System.out.println("Removing " + x);
                books[hash].remove(x); // Удаляем значение по данному ключу
                return;
            }
        }
    }

    // Метод поиска элемента в таблице по ключу
    public Book search(long key) {
        int hash = calcHashValue(key);
        if (books[hash] != null) {

            // Проходим по списку и ищем значение по ключу
            for(Book x : books[hash]) {
                if(x.getISBN() == key)
                    return x;
            }
        }
        return null;
    }


}