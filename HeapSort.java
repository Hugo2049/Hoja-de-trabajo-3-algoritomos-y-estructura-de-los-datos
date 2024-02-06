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

    // Para heapify un subárbol enraizado con el nodo i que es
    // un índice en arr[]. n es el tamaño del heap
    private static void heapify(int arr[], int n, int i) {
        int largest = i; // Inicializar largest como raíz
        int l = 2 * i + 1; // izquierda = 2i + 1
        int r = 2  i + 2; // derecha = 2*i + 2

        // Si el hijo izquierdo es más grande que la raíz
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Si el hijo derecho es más grande que largest hasta ahora
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Si largest no es raíz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Heapify recursivamente el subárbol afectado
            heapify(arr, n, largest);
        }
    }
}