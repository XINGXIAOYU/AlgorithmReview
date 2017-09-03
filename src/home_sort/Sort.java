package home_sort;

/**
 * Created by xingxiaoyu on 17/9/2.
 */
public class Sort {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 4, 6, 8, 2, 3, 4, 66, 22, 1};
        Heap heap = new Heap(A);
        HeapSort heapSort = new HeapSort();
        heapSort.heap_sort(heap);
        printstr(A);
    }

    public static void printstr(int[] A) {
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.print("");
    }
}

class Heap {
    int length;
    int heap_size;
    int[] array;

    public Heap(int[] array) {
        this.array = array;
        this.length = array.length;
        this.heap_size = array.length;
    }
}

class HeapSort {
    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }

    // i 是字符串下标+1
    public void heapify(Heap A, int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left <= A.heap_size && A.array[left - 1] > A.array[i - 1]) {
            largest = left;
        }
        if (right <= A.heap_size && A.array[right - 1] > A.array[largest - 1]) {
            largest = right;
        }

        if (largest != i) {
            int temp = A.array[i - 1];
            A.array[i - 1] = A.array[largest - 1];
            A.array[largest - 1] = temp;
            heapify(A, largest);
        }
    }

    public void buildMAxHeap(Heap A) {
        for (int i = A.heap_size / 2; i >= 1; i--) {
            heapify(A, i);
        }
    }

    public void heap_sort(Heap A) {
        buildMAxHeap(A);
        for (int i = A.length; i >= 2; i--) {
            int temp = A.array[i - 1];
            A.array[i - 1] = A.array[0];
            A.array[0] = temp;
            A.heap_size--;
            heapify(A, 1);
        }
    }

}

//用最大堆实现优先队列 insert maximum extract-max increase-key
class PriorityQueue {
    Heap heap;

    public PriorityQueue(Heap heap) {
        this.heap = heap;
    }

    int maximun(Heap heap) {
        return heap.array[0];
    }

    int extractMax(Heap heap) {
        if (heap.heap_size < 1) {
            return Integer.MIN_VALUE;
        } else {
            int max = heap.array[0];
            heap.array[0] = heap.array[heap.heap_size - 1];
            heap.array[heap.heap_size - 1] = max;
            heap.heap_size--;
            HeapSort heapSort = new HeapSort();
            heapSort.heapify(heap, 0);
            return max;
        }
    }

    void increaseKey(Heap heap, int position, int key) {
        HeapSort heapSort = new HeapSort();
        if (key < heap.array[position - 1]) {
            return;
        } else {
            heap.array[position - 1] = key;
            while (position > 1) {
                if (heap.array[position - 1] > heap.array[heapSort.parent(position) - 1]) {
                    int temp = heap.array[position - 1];
                    heap.array[position - 1] = heap.array[heapSort.parent(position) - 1];
                    heap.array[heapSort.parent(position) - 1] = temp;
                }
            }
        }
    }

    void insert(Heap heap, int key) {
        heap.heap_size++;
        heap.array[heap.heap_size - 1] = Integer.MIN_VALUE;
        increaseKey(heap, heap.heap_size, key);
    }

}


