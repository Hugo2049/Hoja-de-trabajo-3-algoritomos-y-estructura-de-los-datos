import java.util.*;

public class RadixSort {

    // Método para obtener el máximo valor del arreglo
    private static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // Método para hacer el conteo de sort de arr[] de acuerdo a
    // el dígito representado por exp.
    private static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // arreglo de salida
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Almacena la cuenta de ocurrencias en count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Cambia count[i] para que count[i] contenga
        // la posición actual de este dígito en output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Construye el arreglo de salida
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copia el arreglo de salida a arr[], para que arr[] contenga
        // los números ordenados de acuerdo al dígito actual
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // El método principal para ordenar el arreglo de tamaño n usando Radix Sort
    public static void sort(int arr[], int n) {
        // Encuentra el número máximo para saber la cantidad de dígitos
        int m = getMax(arr, n);

        // Hacer el conteo de sort para cada dígito. Nota que en vez
        // de pasar dígito por dígito, exp es pasado. exp es 10^i
        // donde i es el dígito actual
        for (int exp = 1; m / exp > 0; exp= 10)
            countSort(arr, n, exp);
    }
}
