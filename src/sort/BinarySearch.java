package sort;

/**
 * Created by xingxiaoyu on 17/9/9.
 */
public class BinarySearch {
    public int search(int[] A, int key) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < A[mid]) {
                high = mid - 1;
            } else if (key > A[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
