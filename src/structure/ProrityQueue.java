package structure;

/**
 * Created by xingxiaoyu on 17/9/3.
 */

/**
 * based on large heap
 */
public class ProrityQueue {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 4, 6, 8, 2, 3, 4, 66, 22, 1};
        Heap heap = new Heap(A);
        heap.buildMaxHeap(heap);
        ProrityQueue prorityQueue = new ProrityQueue();
        System.out.println(prorityQueue.heap_maximum(heap));
        printstr(heap.a);
        try {
            System.out.println(prorityQueue.heap_extract_max(heap));
            printstr(heap.a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        prorityQueue.heap_increase_key(heap, 3, 1000);
        printstr(heap.a);
        prorityQueue.heap_insert(heap, 888);
        printstr(heap.a);

    }

    public static void printstr(int[] A) {
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    int heap_maximum(Heap heap) {
        return heap.a[0];
    }

    int heap_extract_max(Heap heap) throws Exception {
        if (heap.heap_size < 1) {
            throw new Exception("no heap");
        } else {
            int max = heap.a[0];
            heap.a[0] = heap.a[heap.heap_size - 1];
            heap.heap_size--;
            heap.heapify(heap, 1);
            return max;
        }
    }

    void heap_increase_key(Heap heap, int i, int key) {
        if (key < heap.a[i - 1]) {
            return;
        } else {
            heap.a[i - 1] = key;
            while (i >= 2 && heap.a[heap.parent(i) - 1] < heap.a[i - 1]) {
                int temp = heap.a[heap.parent(i) - 1];
                heap.a[heap.parent(i) - 1] = heap.a[i - 1];
                heap.a[i - 1] = temp;
                i = heap.parent(i);
            }
        }
    }

    void heap_insert(Heap heap, int key) {
        heap.heap_size++;
        heap.a[heap.heap_size - 1] = Integer.MIN_VALUE;
        heap_increase_key(heap, heap.heap_size, key);
    }
}


