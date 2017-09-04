package sort;

import structure.Heap;

/**
 * Created by xingxiaoyu on 17/9/3.
 */

/**
 * 堆排序，首先建立最大堆，再将最后一个和第一个交换（n-1)次，堆大小-1，再对第一个进行Heapify
 * 复杂度nlgn, 不稳定，原地排序
 */
public class HeapSort {

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
