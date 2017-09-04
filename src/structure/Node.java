package structure;

/**
 * Created by xingxiaoyu on 17/9/4.
 */
public class Node {
    Node pre;
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    static Node NIL = new Node();
}
