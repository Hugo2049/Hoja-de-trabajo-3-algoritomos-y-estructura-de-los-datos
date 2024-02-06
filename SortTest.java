import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SortTest {

    @Test
    public void testQuickSort() {
        int[] array = {4, 3, 2, 1};
        QuickSort.sort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testGnomeSort() {
        int[] array = {10, 3, 2, 40, 1};
        GnomeSort.sort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testMergeSort() {
        int[] array = {3, 6, 45, 12, 1, -2};
        MergeSort.sort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testRadixSort() {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort.sort(array);
        assertTrue(isSorted(array));
    }
    
    @Test
    public void testHeapSort() {
        int[] array = {20, 3, 50, 1, 4, 7, 9};
        HeapSort.sort(array);
        assertTrue(isSorted(array));
    }

    // Método auxiliar para verificar si un arreglo está ordenado
    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
