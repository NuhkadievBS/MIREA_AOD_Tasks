package task_2.bit_sort;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

// Класс, реализующий логику битового массива
public class BitArray {
    ArrayList<Boolean> bitArray = new ArrayList<>(); // битовый массив
    String fileName; // путь до файла

    //конструктор битового массива, инициализируем все элементы значением false
    public BitArray(String fileName) {
        this.fileName = fileName; // записываем путь до файла
        for (int i = 0; i < 9000000; i++) {
            bitArray.add(false);
        }
    }

    // Метод активации эл-тов битового массива, индексы которого находятся в файле
    public void getFromFile() throws IOException {

        Path filePath = Paths.get(fileName); // получаем путь до файла
        Scanner scanner = new Scanner(filePath); //

        // в цикле получаем индексы из файла и по индексам, равным им, записываем значение true
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                bitArray.set(scanner.nextInt() - 1000000, true);
            } else {
                scanner.next();
            }
        }
    }

    // Запись в файл "отсортированного" массива значений из битового массива
    public void writeSorted() throws IOException {

        // Создаем объект класса Writer, с помощью которого осуществляется запись
        FileWriter writer = new FileWriter(fileName);

        // В цикле проходимся по битовому массиву и записываем в файл те индексы, чьи элементы равны true
        for (int i = 0; i < bitArray.size(); i++) {
            if (bitArray.get(i)) {
                writer.write(String.valueOf(i  + 1000000));
                writer.write("\n");
            }
        }

        writer.flush(); // очистка потока
        writer.close();
    }

}
