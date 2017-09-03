import home_sort.HeapSort;
import home_sort.QuickSort;
import structure.Heap;

/**
 * Created by xingxiaoyu on 17/9/3.
 */
public class Main {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 4, 6, 8, 2, 3, 4, 66, 22, 1};
        Heap heap = new Heap(A);
        HeapSort sort = new HeapSort();
        sort.heapSort(heap);
        printstr(A);
        int[] B = {2, 3, 1, 4, 6, 8, 2, 3, 4, 66, 22, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(B,0,B.length-1);
        printstr(B);
    }

    public static void printstr(int[] A) {
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
