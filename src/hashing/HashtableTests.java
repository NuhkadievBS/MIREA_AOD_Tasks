package hashing;

public class HashtableTests {

    public static void main(String[] args) {

        // Генерация тестовых значений
        Book book1 = new Book(214748364885L, "Dostoevsky", "Idiot");
        Book book2 = new Book(798562985235L, "Tolstoy", "War and Peace");
        Book book3 = new Book(679792843345L, "Huxley", "Brave New World");
        Book book4 = new Book(987478833456L, "Remarque", "All Quiet on the Western Front");
        Book book5 = new Book(847454845632L, "Sienkiewicz", "Quo vadis");
        Book book6 = new Book(465543823420L, "Shakespeare", "Hamlet");


        HashTable hashTable = new HashTable();
        // Добавление сгенерированных значений в Хеш-Таблицу
        hashTable.add(book1);
        hashTable.add(book2);
        hashTable.add(book3);
        hashTable.add(book4);
        hashTable.add(book5);
        hashTable.add(book6);

        //Вывод созданной хеш-таблицы
        hashTable.printOut();

        System.out.println();

        //Удаление значения по ключу
        hashTable.removeValue(987478833456L);
        hashTable.removeValue(679792843345L);

        System.out.println();

        //Поиск значения по ключу
        System.out.println("Found value at " + hashTable.search(798562985235L) + " index\n");

        //Вывод обработанной таблицы
        hashTable.printOut();
    }
}
