public class MergeSort {
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] leftTemp = new int[middle - left + 1];
        int[] rightTemp = new int[right - middle];

        for (int i = 0; i < leftTemp.length; ++i)
            leftTemp[i] = arr[left + i];
        for (int i = 0; i < rightTemp.length; ++i)
            rightTemp[i] = arr[middle + 1 + i];

        int leftIndex = 0, rightIndex = 0;
        int currentIndex = left;
        while (leftIndex < leftTemp.length && rightIndex < rightTemp.length) {
            if (leftTemp[leftIndex] <= rightTemp[rightIndex]) {
                arr[currentIndex] = leftTemp[leftIndex];
                leftIndex++;
            } else {
                arr[currentIndex] = rightTemp[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }

        while (leftIndex < leftTemp.length) {
            arr[currentIndex++] = leftTemp[leftIndex++];
        }

        while (rightIndex < rightTemp.length) {
            arr[currentIndex++] = rightTemp[rightIndex++];
        }
    }
}
