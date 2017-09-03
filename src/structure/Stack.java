package structure;

/**
 * Created by xingxiaoyu on 17/9/3.
 */
public class Stack {
    int max_size;
    int[] stackArr;
    int top;

    public Stack(int max_size) {
        this.max_size = max_size;
        stackArr = new int[this.max_size];
        this.top = -1;
    }

    public boolean stack_empty() {
        if (this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int x) throws Exception {
        if(this.top==max_size-1){
            throw new Exception("stack full");
        }
        this.top++;
        this.stackArr[this.top] = x;
    }

    public int pop() throws Exception {
        if (stack_empty()) {
            throw new Exception("no element");
        } else {
            this.top--;
            int ele = this.stackArr[this.top + 1];
            return ele;

        }
    }

    public static void main(String[] args){

        try {
            Stack stack = new Stack(5);
            stack.push(1);
            stack.push(2);
            printStack(stack);
            stack.push(99);
            stack.push(88);
            printStack(stack);
            System.out.println(stack.pop());
            printStack(stack);
            System.out.println(stack.stack_empty());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            printStack(stack);
            System.out.println(stack.stack_empty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printStack(Stack stack){
        for(int i:stack.stackArr){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
