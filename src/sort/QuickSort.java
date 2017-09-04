package sort;

/**
 * Created by xingxiaoyu on 17/9/3.
 */

/**
 * 若为随机版本，则不稳定
 * 期望复杂度为nlgn，最坏情况为n2
 *
 */
public class QuickSort {

    public void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public int partition(int[] A, int p, int r) {
        int key = A[r];
        int i = p - 1;
        for (int j = p; j <= r-1; j++) {
            if (A[j] <= A[r]) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return i + 1;
    }


}
