import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static final String FILE_NAME = "numeros.txt";
    private static final int MAX_NUMBERS = 3000;

    public static void main(String[] args) {
        try {
            // Generar y leer números
            NumberGenerator.generateToFile(FILE_NAME, MAX_NUMBERS);
            int[] numbers = NumberGenerator.readFromFile(FILE_NAME);

            // Ejecutar y medir el tiempo para cada algoritmo de ordenamiento
            runSortAndMeasureTime(numbers, GnomeSort::sort, "GnomeSort");
            runSortAndMeasureTime(numbers, MergeSort::sort, "MergeSort");
            runSortAndMeasureTime(numbers, QuickSort::sort, "QuickSort");
            runSortAndMeasureTimeForRadixSort(numbers, "RadixSort");

            // Ejecutar y medir el tiempo para cada algoritmo de ordenamiento en datos ya ordenados
            System.out.println("Ordenando datos ya ordenados:");
            runSortAndMeasureTime(numbers, GnomeSort::sort, "GnomeSort");
            runSortAndMeasureTime(numbers, MergeSort::sort, "MergeSort");
            runSortAndMeasureTime(numbers, QuickSort::sort, "QuickSort");
            runSortAndMeasureTimeForRadixSort(numbers, "RadixSort");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runSortAndMeasureTime(int[] numbers, SortingAlgorithm algorithm, String algorithmName) {
        int[] dataToSort = Arrays.copyOf(numbers, numbers.length);
        long startTime = System.currentTimeMillis();
        algorithm.sort(dataToSort);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(algorithmName + " tomó: " + elapsedTime + " ms para ordenar " + MAX_NUMBERS + " números.");
    }

    private static void runSortAndMeasureTimeForRadixSort(int[] numbers,  String algorithmName) {
        int[] dataToSort = Arrays.copyOf(numbers, numbers.length);
        long startTime = System.currentTimeMillis();
        RadixSort.sort(dataToSort, dataToSort.length);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(algorithmName + " tomó: " + elapsedTime + " ms para ordenar " + MAX_NUMBERS + " números.");
    }

    @FunctionalInterface
    interface SortingAlgorithm {
        void sort(int[] arr);
    }
}

