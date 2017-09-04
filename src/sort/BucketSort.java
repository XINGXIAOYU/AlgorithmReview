package sort;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by xingxiaoyu on 17/9/3.
 */
public class BucketSort {
    public void bucketSort(double[] A) {
        int n = A.length;
        ArrayList[] B = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            B[i] = new ArrayList();
        }
        for (int i = 0; i < n; i++) {
            int temp = (int) Math.floor(10 * A[i]);
            B[temp].add(A[i]);
        }

        for (int i = 0; i < n; i++) {
            insertionSort(B[i]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            Iterator iterator = B[i].iterator();
            while (iterator.hasNext()) {
                Double d = (Double) iterator.next();
                A[count] = d;
                count++;
            }
        }


    }

    public void insertionSort(ArrayList<Double> B) {
        for (int j = 1; j < B.size(); j++) {
            double key = B.get(j);
            int i = j - 1;
            while (i >= 0 && B.get(i) > key) {
                B.set(i + 1, B.get(i));
                i--;
            }
            B.set(i + 1, key);
        }
    }
}
