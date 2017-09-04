package structure;

/**
 * Created by xingxiaoyu on 17/9/4.
 */
public class DoubleLinkedList {
    Node head;
    Node tail;
    int count;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /**
     * 从头部开始找，O(n)
     * @param key
     * @return
     */
    public Node listSearch(int key) {
        Node x = this.head;
        while (x != null && x.data != key) {
            x = x.next;
        }
        return x;
    }

    /**
     * 插入 默认从头部插入
     * @param node
     */
    public void listInsert(Node node){
        node.next = this.head;
        if(this.head!=null){
            this.head.pre = node;
        }
        this.head = node;
        node.pre = null;
    }

    /**
     * 检查边界条件
     * @param node
     */
    public void listDelete(Node node){
        if(node.pre!=null){
            node.pre.next = node.next;
        }else{
            this.head = node.next;
        }
        if(node.next!=null){
            node.next.pre = node.pre;
        }

    }
}