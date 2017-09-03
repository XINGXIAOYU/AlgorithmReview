package structure;

/**
 * Created by xingxiaoyu on 17/9/3.
 */
public class Heap {
    public int[] a;
    public int length;
    public int heap_size;

    public Heap(int[] a) {
        this.a = a;
        this.length = a.length;
        this.heap_size = length;
    }

    public void heapify(Heap A, int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left <= A.heap_size && A.a[left - 1] > A.a[i - 1]) {
            largest = left;
        }
        if (right <= A.heap_size && A.a[right - 1] > A.a[largest - 1]) {
            largest = right;
        }
        if (largest != i) {
            int temp = A.a[i - 1];
            A.a[i - 1] = A.a[largest - 1];
            A.a[largest - 1] = temp;
            heapify(A, largest);
        }
    }

    public void buildMaxHeap(Heap A) {
        for (int i = A.heap_size / 2; i >= 1; i--) {
            heapify(A, i);
        }
    }

    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }
}
