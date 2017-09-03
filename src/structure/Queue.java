package structure;

/**
 * Created by xingxiaoyu on 17/9/3.
 */
public class Queue {
    int[] queue_arr;
    int max_size;
    int head;
    int tail;
    int now_size;

    public Queue(int max_size) {

        this.max_size = max_size;
        queue_arr = new int[this.max_size];
        this.head = this.tail = 0;
        now_size = 0;
    }

    public void enqueue(int x) throws Exception {
        if (now_size == max_size) {
            throw new Exception("queue full");
        }
        queue_arr[this.tail] = x;
        now_size++;
        if (this.tail == queue_arr.length - 1) {
            this.tail = 0;
        } else {
            this.tail++;
        }
    }

    public int dequeue() throws Exception {
        if (now_size == 0) {
            throw new Exception("empty queue");
        }
        int x = queue_arr[head];
        now_size--;
        if (head == queue_arr.length - 1) {
            this.head = 0;
        } else {
            this.head++;
        }
        return x;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        try {
//            queue.dequeue();
            queue.enqueue(1);
            queue.enqueue(2);
            printQueue(queue);
            System.out.println(queue.dequeue());
            printQueue(queue);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            printQueue(queue);
            queue.enqueue(6);
            printQueue(queue);
//            queue.enqueue(7);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void printQueue(Queue queue) {
        for (int i : queue.queue_arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
