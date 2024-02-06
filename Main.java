import java.util.Random;

public class Main {

    private static final int MAX_NUMBERS = 3000; // Cantidad de números por array
    private static final int ITERATIONS = 3000; // Cantidad de arrays a generar y ordenar

    public static void main(String[] args) {
        try {
            System.out.println("GnomeSort va a comenzar.");
            repeatSortAndMeasureTime("GnomeSort");
            System.out.println("GnomeSort ha terminado.");

            System.out.println("MergeSort va a comenzar.");
            repeatSortAndMeasureTime("MergeSort");
            System.out.println("MergeSort ha terminado.");

            System.out.println("QuickSort va a comenzar.");
            repeatSortAndMeasureTime("QuickSort");
            System.out.println("QuickSort ha terminado.");

            System.out.println("RadixSort va a comenzar.");
            repeatSortAndMeasureTime("RadixSort");
            System.out.println("RadixSort ha terminado.");

            System.out.println("HeapSort va a comenzar.");
            repeatSortAndMeasureTime("HeapSort");
            System.out.println("HeapSort ha terminado.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void repeatSortAndMeasureTime(String algorithmName) {
        long totalTime = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            int[] numbersToSort = generateRandomArray(MAX_NUMBERS); // Genera un nuevo array de 3000 números para cada iteración
            long startTime = System.currentTimeMillis();
            
            try {
                switch (algorithmName) {
                    case "GnomeSort":
                        GnomeSort.sort(numbersToSort);
                        break;
                    case "MergeSort":
                        MergeSort.sort(numbersToSort);
                        break;
                    case "QuickSort":
                        QuickSort.sort(numbersToSort);
                        break;
                    case "RadixSort":
                        RadixSort.sort(numbersToSort);
                        break;
                    case "HeapSort":
                        HeapSort.sort(numbersToSort);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown algorithm: " + algorithmName);
                }
            } catch (Exception e) {
                System.out.println("Una excepción ha ocurrido en " + algorithmName);
                e.printStackTrace();
            }

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println(algorithmName + " tomó: " + totalTime + " ms para ordenar " + ITERATIONS + " arrays de " + MAX_NUMBERS + " números cada uno.");
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // Genera números aleatorios entre 0 y 9999
        }
        return array;
    }
}

