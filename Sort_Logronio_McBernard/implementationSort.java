package Sort_Logronio_McBernard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class implementationSort extends abstractSort {
    @Override
    public int[] bubbleSort(int[] arr) { // O(n^2)
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        return arr;
    }

    @Override
    public int[] exchangeSort(int[] arr) { // O(n^2)
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) { // Swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        return arr;
    }

    @Override
    public int[] selectionSort(int[] arr) { // O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            // Find the minimum element in unsorted array
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }

            // Swap the found minimum element with the first element
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    @Override
    public int[] insertionSort(int[] arr) { // O(n^2)
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    @Override
    public int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
        return arr;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public int[] mergeSort(int[] array) {
        merge(array);
        return array;
    }

    private void merge(int[] array) {
        int length = array.length;
        if (length <= 1)
            return; // base case
        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];
        int i = 0; // left array
        int j = 0; // right array
        for (; i < length; i++)
            if (i < middle)
                leftArray[i] = array[i];
            else {
                rightArray[j] = array[i];
                j++;
            }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; // indices
        // check the conditions for merging
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }

    }

    @Override
    public int[] bucketSort(int[] arr) {
        int maxVal = arr.length;
        List<Integer>[] buckets = new ArrayList[maxVal + 1];

        for (int num : arr) {
            if (buckets[num] == null) {
                buckets[num] = new ArrayList<>();
            }
            buckets[num].add(num);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            if (bucket != null) {
                Collections.sort(bucket);
                for (int num : bucket) {
                    arr[index++] = num;
                }
            }
        }

        return arr;
    }
}
