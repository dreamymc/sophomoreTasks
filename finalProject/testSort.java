import java.util.*;

public class testSort {
    public static List<Integer> exchangeSort(List<Integer> arr) { // O(n^2)
        for (int i = 0; i < arr.size() - 1; i++)
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) < arr.get(j)) { // Swap arr[i] and arr[j]
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        return arr;
    }

    public static void main(String[] args) {
        Integer array[] = { 8, 13, 10, 18, 7 };
        List<Integer> list = Arrays.asList(array);
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        System.out.print("Original Array: ");
        System.out.println(Arrays.toString(array));
        System.out.print("\nExchange Sort Array: ");
        System.out.println((exchangeSort(linkedList)));
    }
}
