import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static final String FILE_NAME = "numeros.txt";
    private static final int MAX_NUMBERS = 3000;
    private static final int ITERATIONS = 3000;

    public static void main(String[] args) {
        try {
            NumberGenerator.generateToFile(FILE_NAME, MAX_NUMBERS);
            int[] originalNumbers = NumberGenerator.readFromFile(FILE_NAME);

            // Repite el proceso de ordenamiento para cada algoritmo
            repeatSortAndMeasureTime(originalNumbers, GnomeSort::sort, "GnomeSort");
            repeatSortAndMeasureTime(originalNumbers, MergeSort::sort, "MergeSort");
            repeatSortAndMeasureTime(originalNumbers, QuickSort::sort, "QuickSort");
            repeatSortAndMeasureTimeForRadixSort(originalNumbers, "RadixSort");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void repeatSortAndMeasureTime(int[] originalNumbers, SortingAlgorithm algorithm, String algorithmName) {
        for (int i = 0; i < ITERATIONS; i++) {
            int[] numbersToSort = Arrays.copyOf(originalNumbers, originalNumbers.length);
            runSortAndMeasureTime(numbersToSort, algorithm, algorithmName);
        }
    }

    private static void repeatSortAndMeasureTimeForRadixSort(int[] originalNumbers, String algorithmName) {
        for (int i = 0; i < ITERATIONS; i++) {
            int[] numbersToSort = Arrays.copyOf(originalNumbers, originalNumbers.length);
            runSortAndMeasureTimeForRadixSort(numbersToSort, algorithmName);
        }
    }

    private static void runSortAndMeasureTime(int[] numbersToSort, SortingAlgorithm algorithm, String algorithmName) {
        long startTime = System.nanoTime();
        algorithm.sort(numbersToSort);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convertir a milisegundos
        System.out.println(algorithmName + " tomó: " + duration + " ms para ordenar " + MAX_NUMBERS + " números.");
    }

    private static void runSortAndMeasureTimeForRadixSort(int[] numbersToSort, String algorithmName) {
        long startTime = System.nanoTime();
        RadixSort.sort(numbersToSort, numbersToSort.length);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convertir a milisegundos
        System.out.println(algorithmName + " tomó: " + duration + " ms para ordenar " + MAX_NUMBERS + " números.");
    }

    @FunctionalInterface
    interface SortingAlgorithm {
        void sort(int[] arr);
    }
}

