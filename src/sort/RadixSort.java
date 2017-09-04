package sort;

/**
 * Created by xingxiaoyu on 17/9/3.
 */

import java.util.Arrays;

/**
 * 从前往后排会导致错误 例如921，831
 * 如果不稳定也会出错 421 432 最后反了过来是不行的
 * 所以采用从后往前以及稳定的算法
 * A 待排序数组 d位数 radix基数
 * 复杂度 d(n+k)
 */
public class RadixSort {
    public void radixSort(int[] A, int d, int radix) {
        int length = A.length;
        int[] temp = new int[length];
        int[] count = new int[radix];
        int divide = 1;
        for (int i = 0; i < d; i++) {
            System.arraycopy(A, 0, temp, 0, length);//把A复制到temp中
            Arrays.fill(count, 0);
            for (int j = 0; j < length; j++) {
                int tempKey = (temp[j] / divide) % radix;
                count[tempKey]++;
            }

            for(int j = 1;j<count.length;j++){
                count[j]+=count[j-1];
            }

            for(int j = length-1;j>=0;j--){
                int tempKey = (temp[j]/divide)%radix;
                A[count[tempKey]-1] = temp[j];
                count[tempKey]--;
            }
            divide = divide*radix;
        }
    }

}
