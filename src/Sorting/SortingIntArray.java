package Sorting;

public class SortingIntArray {
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }


    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }

        return array;
    }

    public static int[] quickSort(int[] array) {
        recursionQuickSort(array, 0, array.length - 1);
        return array;
    }

    public static void recursionQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            recursionQuickSort(arr, low, pi - 1);
            recursionQuickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Выбор среднего элемента в качестве опорного
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // Обмен опорного элемента с последним, чтобы использовать существующую логику
        int temp = arr[middle];
        arr[middle] = arr[high];
        arr[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}


