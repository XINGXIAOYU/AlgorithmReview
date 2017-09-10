package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by xingxiaoyu on 17/9/10.
 */
public class Krustal {
    public static void krustal(int[] V, Edge[] E) {
        Arrays.sort(E);
        ArrayList<HashSet> sets = new ArrayList<HashSet>();
        for (int i = 0; i < V.length; i++) {
            HashSet set = new HashSet();
            set.add(V[i]);
            sets.add(set);
        }
        for (int i = 0; i < E.length; i++) {
            int s = E[i].start;
            int e = E[i].end;
            int a = -1;
            int b = -2;
            for (int j = 0; j < sets.size(); j++) {
                if (sets.get(j).contains(s)) {
                    a = j;
                }

                if (sets.get(j).contains(e)) {
                    b = j;
                }
            }

            if (a < 0 || b < 0) {
                System.err.println("error");
            }

            if (a != b) {
                System.out.println(s + "---" + e + "weight: " + E[i].weight);
                HashSet s1 = sets.get(a);
                HashSet s2 = sets.get(b);
                sets.remove(b);
                sets.remove(a);
                s1.addAll(s2);
                sets.add(s1);
            } else {
                System.out.println("same set");
            }
        }
    }

    public static void main(String[] args) {
        int[] V = {1, 2, 3, 4, 5, 6};
        Edge[] E = new Edge[10];
        E[0] = new Edge(1, 2, 6);
        E[1] = new Edge(1, 3, 1);
        E[2] = new Edge(1, 4, 5);
        E[3] = new Edge(2, 3, 5);
        E[4] = new Edge(2, 5, 3);
        E[5] = new Edge(3, 4, 5);
        E[6] = new Edge(3, 5, 6);
        E[7] = new Edge(3, 6, 4);
        E[8] = new Edge(4, 6, 2);
        E[9] = new Edge(5, 6, 6);
        Krustal.krustal(V, E);
    }
}

class Edge implements Comparable {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge) o;
        if (this.weight > e.weight) {
            return 1;
        } else if (this.weight == e.weight) {
            return 0;
        } else {
            return -1;
        }
    }
}
