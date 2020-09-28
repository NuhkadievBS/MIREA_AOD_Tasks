package task_2.bit_sort;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;

// Класс реализующий генерацию возможных значений в диапазоне [1000000, 9999999]
public class PossibleValues {
    ArrayList<Integer> possibleValues = new ArrayList<>(); // массив возможных значений
    String fileName; // путь до файла

    // В конструкторе записываем все возможные значения в диапазоне [1000000, 9999999] и перемешиваем его
    public PossibleValues(String fileName) {
        this.fileName = fileName;
        for (int i = 1000000; i < 10000000; i++) {
            possibleValues.add(i);
        }
        Collections.shuffle(possibleValues); // перемешиваем значения массива
    }

    // Метод, записывающий n значений в файл(значения не повторяются, т.к. все перемешанные значения изначально не повторяются)
    public void toFile(int n) throws IOException {

        // Создаем объект класса Writer, с помощью которого осуществляется запись
        Writer writer = new FileWriter(fileName);

        // В цикле записываем сгенерированные значения в файл
        for (int i = 0; i < n; i++) {
            try {
                writer.write(String.valueOf(possibleValues.get(i)));
                writer.write("\n");
            } catch (Exception e) {
                System.out.println(i + '\n');
            }
        }
        writer.flush(); // очистка потока
        writer.close();

    }

}
