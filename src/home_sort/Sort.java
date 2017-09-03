package home_sort;

import structure.Heap;

/**
 * Created by xingxiaoyu on 17/9/3.
 */
public class Sort {

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 4, 6, 8, 2, 3, 4, 66, 22, 1};
        Heap heap = new Heap(A);
        Sort sort = new Sort();
        sort.heapSort(heap);
        printstr(A);
    }

    public static void printstr(int[] A) {
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.print("");
    }

    public void heapSort(Heap heap) {
        heap.buildMaxHeap(heap);
        for (int i = heap.length; i >= 2; i--) {
            int temp = heap.a[0];
            heap.a[0] = heap.a[heap.heap_size - 1];
            heap.a[heap.heap_size - 1] = temp;
            heap.heap_size--;
            heap.heapify(heap, 1);
        }
    }
}
