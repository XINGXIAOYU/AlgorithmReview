package graph;

/**
 * Created by xingxiaoyu on 17/9/10.
 */
public class BellmanFord {
    public int[] result;

    public boolean bellmanford(Edge[] E, int n) {

        //初始化 除了原点其他都为最大
        result = new int[n];
        for (int i = 1; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        //对每条边进行n-1次松弛

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < E.length; j++) {
                if (result[E[j].end] > result[E[j].start] + E[j].weight) {
                    result[E[j].end] = result[E[j].start] + E[j].weight;
                }
            }
        }

        //判断有没有负环路
        boolean judge = true;
        for (int i = 0; i < E.length; i++) {
            if (result[E[i].start] > result[E[i].end] + E[i].weight) {
                judge = false;
                break;
            }
        }
        return judge;
    }

    public static void main(String[] args) {
        int[] V = {0, 1, 2, 3, 4, 5};
        Edge[] E = new Edge[10];
        E[0] = new Edge(0, 1, 6);
        E[1] = new Edge(0, 2, 1);
        E[2] = new Edge(0, 3, 5);
        E[3] = new Edge(1, 2, 5);
        E[4] = new Edge(1, 4, 3);
        E[5] = new Edge(2, 3, 5);
        E[6] = new Edge(2, 4, 6);
        E[7] = new Edge(2, 5, 4);
        E[8] = new Edge(3, 5, 2);
        E[9] = new Edge(4, 5, 6);
        BellmanFord test = new BellmanFord();
        if (test.bellmanford(E, 6)) {
            for (int i = 0; i < test.result.length; i++)
                System.out.print(test.result[i] + " ");
        } else
            System.out.println("给定图存在负环，没有最短距离");

    }
}
