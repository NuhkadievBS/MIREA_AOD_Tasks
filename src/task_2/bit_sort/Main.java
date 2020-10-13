package task_2.bit_sort;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);

        // Путь к текстовому файлу
        String fileName = "/Users/baga_nuhkadiev/IdeaProjects/MIREA_AOD_Tasks/src/task_2/files/numbers.txt";

        // Генерация значений в диапазоне [1000000, 9999999],
        // таким образом возможно сгенерировать лишь 9000000 различных значений,
        // поэтому крайнее ограничение на кол-во элементов в файле = 9000000

//        PossibleValues possibleValues = new PossibleValues(fileName);
//        possibleValues.toFile(9000000);


        long m = System.currentTimeMillis(); // фиксируем начало работы алгоритма
        BitArray bitArray = new BitArray(fileName); // Инициализация битового массива (начальные значения = 0)
        bitArray.getFromFile(); // Достаем из массива индексы и активируем соответствующие эл-ты в битовом массиве

        // Записываем активированные эл-ты в файл, проходя по возрастанию индексов(таким образом сортируя)
        bitArray.writeSorted();

        System.out.println("used time = " + (double) (System.currentTimeMillis() - m) + "ms"); //вывод времени работы алгоритма
        long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

    }
}
