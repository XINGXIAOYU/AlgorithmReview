package graph;

/**
 * Created by xingxiaoyu on 17/9/11.
 */
public class FloydWarshall {
    int[][] d;

    public void floyd(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                d[i][j] = matrix[i][j];
            }
        }

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (d[i][k] != Integer.MAX_VALUE &&
                            d[k][j] != Integer.MAX_VALUE &&
                            d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
    }
}
