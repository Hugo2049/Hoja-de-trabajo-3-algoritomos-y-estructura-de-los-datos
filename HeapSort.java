public class HeapSort {

    public static void sort(int arr[]) {
        int n = arr.length;

        // Construir el heap (reorganizar el array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extraer elementos uno por uno del heap
        for (int i = n - 1; i >= 0; i--) {
            // Mover la raíz actual al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // llamar a la función heapify en el heap reducido
            heapify(arr, i, 0);
        }
    }
}