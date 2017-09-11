package graph;

import java.util.*;

/**
 * Created by xingxiaoyu on 17/9/11.
 */
public class Dijkstra {
    public static void dijkstra(Graph g, Vertex s) {
        Set<Vertex> set = g.vertexSet;
        Map<Vertex, Edge2[]> adj_map = g.adjacents;
        for (Vertex v : set) {
            if (v == s) {
                continue;
            } else {
                v.value = Integer.MAX_VALUE;
            }
        }

        Set<Vertex> s2 = new HashSet<Vertex>();

        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        for (Vertex v : set) {
            queue.add(v);
        }

        Vertex[] temp = queue.toArray(new Vertex[0]);
        while (temp.length != 0) {
            Vertex u = temp[0];
            s2.add(u);
            Edge2[] adj_es = adj_map.get(u);
            if (adj_es != null && adj_es.length > 0) {
                for (Edge2 e : adj_es) {
                    if (e.e.value > e.s.value + e.weight) {
                        e.e.value = e.s.value + e.weight;
                    }
                }
            }
            PriorityQueue<Vertex> queue2 = new PriorityQueue<Vertex>();
            for (int i = 1; i < temp.length; i++) {
                queue2.add(temp[i]);
            }
            temp = queue2.toArray(new Vertex[0]);

        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Set<Vertex> vertexSet = graph.vertexSet;
        Map<Vertex, Edge2[]> edgeMap = graph.adjacents;

        Vertex z = new Vertex("z");
        Vertex s = new Vertex("s");
        Vertex t = new Vertex("t");
        Vertex x = new Vertex("x");
        Vertex y = new Vertex("y");

        vertexSet.add(z);
        vertexSet.add(s);
        vertexSet.add(t);
        vertexSet.add(x);
        vertexSet.add(y);

        Edge2 st = new Edge2(s, t, 10);
        Edge2 sy = new Edge2(s, y, 5);
        Edge2 tx = new Edge2(t, x, 1);
        Edge2 ty = new Edge2(t, y, 2);
        Edge2 yt = new Edge2(y, t, 3);
        Edge2 yx = new Edge2(y, x, 9);
        Edge2 yz = new Edge2(y, z, 2);
        Edge2 xz = new Edge2(x, z, 4);
        Edge2 zx = new Edge2(z, x, 6);
        Edge2 zs = new Edge2(z, s, 7);

        edgeMap.put(z, new Edge2[]{zx, zs});
        edgeMap.put(s, new Edge2[]{st, sy});
        edgeMap.put(t, new Edge2[]{tx, ty});
        edgeMap.put(x, new Edge2[]{xz});
        edgeMap.put(y, new Edge2[]{yz, yt, yx});


//        Vertex[] sortedVertexs = graph.toposort(graph);
//
//        Vertex[] sortedVertexs = TopoSortShortest.dag_shortest_path(graph, s);
        dijkstra(graph, s);
        printVertex(vertexSet.toArray(new Vertex[0]));
    }

    public static void printVertex(Vertex[] Vertexs) {
        for (Vertex vertex : Vertexs) {
            System.out.println(vertex.name + "  discover time:"
                    + vertex.discover + "  finish time:"
                    + vertex.finish + " value:" + vertex.value);
        }
    }
}

class MinPriorityQueue {
    MinHeap minHeap;

    public MinPriorityQueue(Vertex[] vertexes) {
        minHeap = new MinHeap(vertexes);
        minHeap.buildMinHeap(minHeap);
    }

    public Vertex extractMin() {
        Vertex min = minHeap.A[0];
        Vertex temp = minHeap.A[minHeap.size - 1];
        minHeap.A[0] = temp;
        minHeap.size--;
        minHeap.buildMinHeap(minHeap);
        return min;
    }
}

class MinHeap {
    Vertex[] A;
    int length;
    int size;

    public MinHeap(Vertex[] a) {
        this.A = a;
        this.length = a.length;
        this.size = this.length;
    }

    public void buildMinHeap(MinHeap heap) {
        for (int i = heap.size / 2; i >= 1; i--) {
            heapify(heap, i);
        }
    }

    public void heapify(MinHeap heap, int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;
        if (left <= heap.size && heap.A[left - 1].value < heap.A[smallest - 1].value) {
            smallest = left;
        }

        if (right <= heap.size && heap.A[right - 1].value < heap.A[smallest - 1].value) {
            smallest = right;
        }

        if (smallest != i) {
            Vertex temp = heap.A[smallest - 1];
            heap.A[smallest - 1] = heap.A[i - 1];
            heap.A[i - 1] = temp;
            heapify(heap, smallest);
        }
    }

    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }
}
