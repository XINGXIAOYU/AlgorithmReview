package sort;

/**
 * 选择排序， 第一次选择最小的和A[1]交换，第二次在n-1中选择最小的和A[2]交换
 * 复杂度O(n2),不稳定,例如 5,8,5,2,3， 第一次5和2交换
 */
public class SelectSort{
    public void sort(int[] A){
        for(int i = 0;i<A.length-1;i++){
            int k = i;
            for(int j = i+1;j<A.length;j++){
                if(A[j]<A[k]){
                    int temp = A[j];
                    A[j] = A[k];
                    A[k] = temp;
                }
            }
        }
    }
}

