package home_sort;

/**
 * Created by xingxiaoyu on 17/9/3.
 */

/**
 * 计数排序 A原数组 B结果数组 k A中最大的数字
 * 最后从后往前 为了使算法稳定
 * C为计数数组 记录应该放的位置
 * 复杂度k+n，不是原址排序
 */
public class CountSort {
    public void countSort(int[] A, int[] B, int k) {
        int[] C = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            C[i] = 0;
        }
        for (int j = 0; j < A.length; j++) {
            C[A[j]] = C[A[j]] + 1;
        }

        for(int i = 1;i<C.length;i++){
            C[i] += C[i-1];
        }

        for(int j = A.length-1;j>=0;j--){
            B[C[A[j]]-1] = A[j];
            C[A[j]]--;
        }
    }
}
