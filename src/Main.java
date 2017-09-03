import home_sort.*;
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
        quickSort.quickSort(B, 0, B.length - 1);
        printstr(B);
        int[] C = {2, 3, 1, 4, 6, 8, 2, 3, 4, 66, 22, 1};
        int[] C2 = new int[C.length];
        CountSort countSort = new CountSort();
        countSort.countSort(C, C2, 66);
        printstr(C2);
        int[] D = {2, 3, 1, 4, 6, 8, 2, 3, 4, 66, 22, 1};
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(D,2,10);
        printstr(D);
        double[] E = {0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
        BucketSort bucketSort = new BucketSort();
        bucketSort.bucketSort(E);
        printstr(E);
    }

    public static void printstr(int[] A) {
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void printstr(double[] A) {
        for (double i : A) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
