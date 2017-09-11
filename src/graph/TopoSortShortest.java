package graph;

import java.util.*;

/**
 * Created by xingxiaoyu on 17/9/10.
 */
public class TopoSortShortest {
    public static Vertex[] dag_shortest_path(Graph g, Vertex s) {
        Vertex[] vs = g.toposort(g);
        //initialize single source
        for (int i = 0; i < vs.length; i++) {
            vs[i].value = Integer.MAX_VALUE;
        }
        s.value = 0;
        Map<Vertex, Edge2[]> edgeMap = g.adjacents;
        boolean judge = false;
        for (Vertex v : vs) {
            if (v == s) {
                judge = true;
            }
            if (judge == true) {
                Edge2[] v_ad_e = edgeMap.get(v);
                if (v_ad_e != null && v_ad_e.length > 0) {
                    for (Edge2 v_e : v_ad_e) {
                        Vertex end = v_e.e;
                        if (end.value > v.value + v_e.weight) {
                            end.value = v.value + v_e.weight;

                        }
                    }
                }

            }
        }
        return vs;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Set<Vertex> vertexSet = graph.vertexSet;
        Map<Vertex, Edge2[]> edgeMap = graph.adjacents;

        Vertex r = new Vertex("r");
        Vertex s = new Vertex("s");
        Vertex t = new Vertex("t");
        Vertex x = new Vertex("x");
        Vertex y = new Vertex("y");
        Vertex z = new Vertex("z");

        vertexSet.add(r);
        vertexSet.add(s);
        vertexSet.add(t);
        vertexSet.add(x);
        vertexSet.add(y);
        vertexSet.add(z);

        Edge2 rs = new Edge2(r, s, 5);
        Edge2 st = new Edge2(s, t, 2);
        Edge2 tx = new Edge2(t, x, 7);
        Edge2 xy = new Edge2(x, y, -1);
        Edge2 yz = new Edge2(y, z, -2);
        Edge2 sx = new Edge2(s, x, 6);
        Edge2 xz = new Edge2(x, z, 1);
        Edge2 rt = new Edge2(r, t, 3);
        Edge2 ty = new Edge2(t, y, 4);
        Edge2 tz = new Edge2(t, z, 1);

        edgeMap.put(r, new Edge2[]{rs, rt});
        edgeMap.put(s, new Edge2[]{st, sx});
        edgeMap.put(t, new Edge2[]{tx, ty, tz});
        edgeMap.put(x, new Edge2[]{xy, xz});
        edgeMap.put(y, new Edge2[]{yz});


//        Vertex[] sortedVertexs = graph.toposort(graph);
//
        Vertex[] sortedVertexs = TopoSortShortest.dag_shortest_path(graph, s);
        printVertex(sortedVertexs);
    }

    public static void printVertex(Vertex[] Vertexs) {
        for (Vertex vertex : Vertexs) {
            System.out.println(vertex.name + "  discover time:"
                    + vertex.discover + "  finish time:"
                    + vertex.finish + " value:" + vertex.value);
        }
    }


}

enum Color {
    WHITE, GREY, BLACK
}

class Vertex implements Comparable {
    String name;
    Color color;
    Vertex parent;
    int discover;
    int finish;
    int d;
    int value;

    public Vertex(String name) {
        this.color = Color.WHITE;
        this.name = name;
    }

    public Vertex() {
        this.color = Color.WHITE;
    }

    @Override
    public int compareTo(Object o) {
        Vertex v = (Vertex) o;
        if (this.value > v.value) {
            return 1;
        } else if (this.value == v.value) {
            return 0;
        } else {
            return -1;
        }
    }
}

class Edge2 {
    Vertex s;
    Vertex e;
    int weight;

    public Edge2(Vertex s, Vertex e, int weight) {
        this.s = s;
        this.e = e;
        this.weight = weight;
    }
}

class Graph {
    Set<Vertex> vertexSet = new HashSet<Vertex>();
    Map<Vertex, Edge2[]> adjacents = new HashMap<Vertex, Edge2[]>();
    Set<Edge2> edgeSet = new HashSet<Edge2>();

    public Vertex[] toposort(Graph g) {
        Set<Vertex> vertexes = g.vertexSet;
        if (vertexes.size() < 2) {
            return vertexes.toArray(new Vertex[0]);
        }

        LinkedList<Vertex> sortedList = new LinkedList<Vertex>();
        TimeRecorder timeRecorder = new TimeRecorder();
        for (Vertex vertex : vertexes) {
            if (vertex.color == Color.WHITE) {
                visitVertex(g, vertex, timeRecorder, sortedList);
            }
        }
        return sortedList.toArray(new Vertex[0]);
    }

    //deep first search
    public void visitVertex(Graph g, Vertex v, TimeRecorder t, LinkedList<Vertex> sortedList) {
        t.time++;
        v.color = Color.GREY;
        v.discover = t.time;

        Map<Vertex, Edge2[]> edgeMap = g.adjacents;
        Edge2[] adj = edgeMap.get(v);
        if (adj != null && adj.length > 0) {
            for (Edge2 e : adj) {
                Vertex a = e.e;
                if (a.color == Color.WHITE) {
                    a.parent = v;
                    visitVertex(g, a, t, sortedList);
                }
            }
        }
        t.time++;
        v.color = Color.BLACK;
        v.finish = t.time;
        sortedList.addFirst(v);
    }

    //broad first search
    public void BFS(Graph g, Vertex v) {
        Set<Vertex> vertexes = g.vertexSet;
        Map<Vertex, Edge2[]> maps = g.adjacents;
        for (Vertex v2 : vertexes) {
            v2.color = Color.WHITE;
            v2.d = Integer.MAX_VALUE;
            v2.parent = null;
        }
        v.d = 0;
        v.color = Color.GREY;
        v.parent = null;
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(v);
        while (queue.size() != 0) {
            Vertex u = queue.poll();
            Edge2[] u_adj = maps.get(u);
            for (Edge2 u_e : u_adj) {
                Vertex u_a = u_e.e;
                if (u_a.color == Color.WHITE) {
                    u_a.color = Color.GREY;
                    u_a.d++;
                    u_a.parent = u;
                    queue.add(u_a);
                }
            }
            u.color = Color.BLACK;

        }

    }
}

class TimeRecorder {
    int time = 0;
}
