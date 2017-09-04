package structure;

/**
 * Created by xingxiaoyu on 17/9/4.
 */
public class DoubleLinkedListWithNIL {
    Node head;
    Node tail;
    Node nil = Node.NIL;
    int count;

    public DoubleLinkedListWithNIL(int count) {
        nil.next = head;
        nil.pre = tail;
        head.pre = nil;
        tail.next = nil;
        this.count = count;
    }

    public Node listSearch(int key) {
        Node x = nil.next;
        while (x != null && x.data != key) {
            x = x.next;
        }
        return x;
    }

    public void listInsert(Node x) {
        x.next = nil.next;
        if (nil.next != null) {
            nil.next.pre = x;
        }
        nil.next = x;
        x.pre = nil;
        head = x;
    }

    public void listDelete(Node x) {
        x.pre.next = x.next;
        x.next.pre = x.pre;
    }
}
