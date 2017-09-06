package structure;

/**
 * Created by xingxiaoyu on 17/9/6.
 */

//无法解决碰撞的问题 可以用开放寻址和双向链表解决
public class DirectAddress {

    Data direct_address_search(Data[] datas, int key) {
        return datas[key];
    }

    void direct_address_insert(Data[] datas, Data data) {
        datas[data.key] = data;
    }

    void direct_address_delete(Data[] datas, Data data) {
        datas[data.key] = null;
    }
}

class Data {
    int key;
    int satellite;

    public Data(int key, int satellite) {
        this.key = key;
        this.satellite = satellite;
    }
}


//双向链表解决冲突, 把又冲突的元素放在一张链表中
class DirectAddressWithCollision {
    final static int max = 10;

    int hashfunction(int n) {
        return n % max;
    }


    //在头部插入
    void list_insert(ListNode listNode, Data data) {
        ListNode n2 = new ListNode();
        n2.data = data;
        n2.next = null;
        collision(listNode, data.key, n2);

    }

    int list_search(ListNode listNode, int key) {
        ListNode temp = null;
        ListNode p = null;

        if (listNode == null) {
            System.out.println("error");
            return -1;
        } else {
            temp = listNode;
            while (temp.data.key != key) {
                if (temp.next == null) {
                    return -1;
                }
                p = temp;
                temp = temp.next;
            }
        }
        return 0;
    }

    int list_delete(ListNode listNode, int key) {
        ListNode temp = null;
        ListNode p = null;
        if (listNode == null) {
            System.out.println("error");
            return -1;
        } else {
            temp = listNode;
            while (temp.data.key != key) {
                if (temp.next == null) {
                    System.out.println("not exist");
                    return -1;
                }
                p = temp;
                temp = temp.next;

            }
            p.next = temp.next;
            temp.pre = p.pre;
            temp = null;
        }
        return 0;
    }

    void chained_hash_insert(HashTable hashTable, Data data) {
        list_insert(hashTable.listNodes[hashfunction(data.key)], data);
    }

    void chained_hash_delete(HashTable hashTable, int key) {
        list_delete(hashTable.listNodes[hashfunction(key)], key);
    }

    void chained_hash_search(HashTable hashTable, int key) {
        list_search(hashTable.listNodes[key], key);
    }

    void collision(ListNode n1, int key, ListNode node) {
        if (n1 == null) {
            n1 = node;
        } else {
            node.pre = n1;
            n1.next = node;
        }
    }

    void printHashTable(HashTable hashTable) {
        for (int i = 0; i < hashTable.listNodes.length; i++) {
            ListNode a = hashTable.listNodes[i];
            System.out.println(a.data.key);
            while (a != null) {
                System.out.print(a.data.satellite + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Data d1 = new Data(1, 1);
        Data d2 = new Data(2, 2);
        Data d3 = new Data(3, 1);
        Data d4 = new Data(11, 2);
        Data d5 = new Data(12, 4);
        DirectAddressWithCollision directAddressWithCollision = new DirectAddressWithCollision();
        HashTable hashTable = new HashTable();
        directAddressWithCollision.chained_hash_insert(hashTable, d1);
        directAddressWithCollision.chained_hash_insert(hashTable,d2);
        directAddressWithCollision.chained_hash_insert(hashTable,d3);
        directAddressWithCollision.chained_hash_insert(hashTable,d4);
        directAddressWithCollision.chained_hash_insert(hashTable,d5);
        directAddressWithCollision.printHashTable(hashTable);


    }
}

class ListNode {
    Data data;
    ListNode pre;
    ListNode next;

}

class HashTable {
    ListNode[] listNodes = new ListNode[DirectAddressWithCollision.max];

    public HashTable() {

    }
}