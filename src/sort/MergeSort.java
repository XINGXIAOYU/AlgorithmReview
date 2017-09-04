package sort;

/**
 * 归并排序
 * T(n) = 2T(n/2) + O(n) ==> O(nlgn)
 * nonplace sort, stable
 */
public class MergeSort{
    public void sort(int[]A,int p, int r){
        if(p<r){
            int q = (p+r)/2;
            sort(A,p,q);
            sort(A,q+1,r);
            merge(A,p,q,r);
        }
    }

    public void merge(int[]A,int p ,int q, int r){
        int n1 = q-p+1;
        int n2 = r-q;;
        int[] left = new int[n1+1];
        int[] right = new int[n2+1];
        for(int i = 0;i<n1;i++){
            left[i] = A[p+i];
        }

        for(int i = 0;i<n2;i++){
            right[i] = A[q+i+1];
        }

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for(int k = p;k<=r;k++){
            if(left[i]<=right[j]){
                A[k] = left[i];
                i++;
            }else{
                A[k] = right[j];
                j++;
            }
        }
    }
}