/**
 * Created by xingxiaoyu on 17/9/2.
 */
public class Problem {
    public static void main(String[] args){
        int[]A = {2,3,1,4,6,8,2,3,4,66,22,1};
        MaxCrossSubstr maxCrossSubstr = new MaxCrossSubstr();
        int[] res = maxCrossSubstr.find_max_substr(A,0,A.length-1);
        printstr(res);
    }

    public static void printstr(int[]A){
        for(int i : A){
            System.out.print(i+" ");
        }
        System.out.print("");
    }
}

class MaxCrossSubstr{
    public int[] find_max_substr(int[]A,int low,int high){
        int[] res = new int[3];
        if(low==high){
            res[0] = A[low];
            res[1] = low;
            res[2] = high;
            return res;
        }
        else{
            int mid = (low+high)/2;
            int[] res_left = find_max_substr(A,low,mid);
            int[] res_right = find_max_substr(A,mid+1,high);
            int[] res_cross  = find_cross(A, low, mid, high);

            if(res_left[0]>=res_right[0]&&res_left[0]>=res_cross[0]){
                return res_left;
            }else if(res_right[0]>=res_left[0]&&res_right[0]>=res_cross[0]){
                return res_right;
            }else{
                return res_cross;
            }
        }
    }

    public int[] find_cross(int[]A,int low,int mid,int high){
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        int max_left = 0;
        for(int i = mid;i>=low;i--){
            sum = sum+A[i];
            if(sum>left_sum){
                left_sum = sum;
                max_left = i;
            }
        }

        int right_sum = Integer.MIN_VALUE;
        sum =  0;
        int max_right = 0;
        for(int i = mid+1;i<=high;i++){
            sum = sum+A[i];
            if(sum>right_sum){
                right_sum = sum;
                max_right = i;
            }
        }
        int[] res = {max_left+right_sum,max_left,max_right};
        return res;
    }
}
