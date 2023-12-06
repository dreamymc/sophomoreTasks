package Sort_Logronio_McBernard;

import java.util.*;

public class mainSort {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] _dreamymc) {
        System.out.print("Enter the array with one space in-between: ");
        String s = scan.nextLine();
        String sA[] = s.split(" ");
        int[] arr = new int[sA.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(sA[i]);
        run(arr);
    }

    private static void run(int[] arr) {
        int[] retUrn = new int[arr.length];
        for (int r = 0; r < arr.length; r++)
            retUrn[r] = arr[r];
        System.out.println("Current Array is: " + Arrays.toString(arr));
        System.out.print(
                "Press [1] for Bubble Sort\nPress [2] for Exchange Sort\nPress [3] for Selection Sor\nPress [4] for Insertion Sort\nPress [5] for Quick Sort\nPress [6] for Merge Sort\nPress [7] for Bucket Sort\nPress [0] to close program.\nEnter: ");
        implementationSort is = new implementationSort();
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("After Bubble Sort: " + Arrays.toString(is.bubbleSort(arr)));
                break;
            case 2:
                System.out.println("After Exchange Sort: " + Arrays.toString(is.exchangeSort(arr)));
                break;
            case 3:
                System.out.println("After Insertion Sort: " + Arrays.toString(is.selectionSort(arr)));
                break;
            case 4:
                System.out.println("After Insertion Sort: " + Arrays.toString(is.insertionSort(arr)));
                break;
            case 5:
                System.out.println("After Quick Sort: " + Arrays.toString(is.quickSort(arr, 0, arr.length - 1)));
                break;
            case 6:
                System.out.println("After Merge Sort: " + Arrays.toString(is.mergeSort(arr)));
                break;
            case 7:
                System.out.println("After Bucket Sort: " + Arrays.toString(is.bucketSort(arr)));
                break;
            default:
                System.exit(0);
                break;
        }
        run(retUrn);
    }
}