package structure;

/**
 * Created by xingxiaoyu on 17/9/4.
 */

//二叉搜索树 左小于中小于右
public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        this.root = TreeNode.NIL;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int height(TreeNode treeNode) {
        if (treeNode == TreeNode.NIL) {
            return 0;
        } else {
            int i = height(treeNode.left) + 1;
            int j = height(treeNode.right) + 1;
            int max = i > j ? i : j;
            return max;

        }
    }

    public int size(TreeNode treeNode) {
        if (treeNode == TreeNode.NIL) {
            return 0;
        } else {
            return size(treeNode.left) + 1 + size(treeNode.right);
        }
    }

    public void destroy(TreeNode treeNode) {
        if (treeNode.parent == treeNode.NIL) {
            treeNode = null;
        } else {
            destroy(treeNode.left);
            destroy(treeNode.right);
            treeNode = null;
        }
    }

    public TreeNode treeSearch(TreeNode treeNode, int data) {
        if (treeNode == TreeNode.NIL || treeNode.data == data) {
            return treeNode;
        }
        if (treeNode.data < data) {
            return treeSearch(treeNode.right, data);
        } else {
            return treeSearch(treeNode.left, data);
        }
    }

    public void inorder(TreeNode treeNode) {
        if (treeNode != TreeNode.NIL) {
            inorder(treeNode.left);
            System.out.println(treeNode.data);
            inorder(treeNode.right);
        }
    }

    public TreeNode minimun(TreeNode treeNode) {
        if (treeNode != TreeNode.NIL) {
            while (treeNode.left != TreeNode.NIL) {
                treeNode = treeNode.left;
            }
        }
        return treeNode;
    }

    public TreeNode maximum(TreeNode treeNode) {
        if (treeNode != TreeNode.NIL) {
            while (treeNode.right != TreeNode.NIL) {
                treeNode = treeNode.right;
            }
        }
        return treeNode;
    }

    //succssor 值刚好大于当前值的节点
    public TreeNode successor(TreeNode treeNode) {
        if (treeNode != TreeNode.NIL) {
            if (treeNode.right != TreeNode.NIL) {
                return minimun(treeNode.right);
            } else {
                TreeNode y = treeNode.parent;
                while (y != TreeNode.NIL && y.right == treeNode) {
                    treeNode = y;
                    y = y.parent;
                }
                return y;
            }
        } else {
            return treeNode;
        }
    }

    //predecessor 值刚好小于当前值的节点
    public TreeNode predecessor(TreeNode treeNode) {
        if (treeNode != TreeNode.NIL) {
            if (treeNode.left != TreeNode.NIL) {
                return maximum(treeNode.left);
            } else {
                TreeNode y = treeNode.parent;
                while (y != TreeNode.NIL && y.left == treeNode) {
                    treeNode = y;
                    y = y.parent;
                }
                return y;
            }
        } else {
            return treeNode;
        }
    }

    public void insert(TreeNode z) {
        TreeNode y = null;
        TreeNode x = root;
        while (x != TreeNode.NIL) {
            y = x;
            if (z.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == TreeNode.NIL) {
            root = z;
        } else if (z.data < y.data) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    public void transplant(TreeNode u, TreeNode v) {
        if (u.parent == TreeNode.NIL) {
            root = v;
        } else if (u == u.parent.left) {

            u.parent.left = v;
        } else if (u == u.parent.right) {

            u.parent.right = v;
        }
        if (v != TreeNode.NIL) {
            v.parent = u.parent;
        }
    }

    public void delete(TreeNode z) {
        if (z.left == TreeNode.NIL) {
            transplant(z, z.right);
        } else if (z.right == TreeNode.NIL) {
            transplant(z, z.left);
        } else {
            TreeNode y = minimun(z.right);
            if (y.parent != z) {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, 6);
        TreeNode n2 = new TreeNode(2, 18);
        TreeNode n3 = new TreeNode(3, 3);
        TreeNode n4 = new TreeNode(4, 15);
        TreeNode n5 = new TreeNode(5, 1);
        TreeNode n6 = new TreeNode(6, 7);
        TreeNode n7 = new TreeNode(7, 20);
        TreeNode n8 = new TreeNode(8, 17);
        TreeNode n9 = new TreeNode(9, 8);
        BinaryTree tree = new BinaryTree();
        tree.insert(n1);
        tree.insert(n2);
        tree.insert(n3);
        tree.insert(n4);
        tree.insert(n5);
        tree.insert(n6);
        tree.insert(n7);
        tree.insert(n8);
        tree.insert(n9);
        tree.inorder(tree.root);
        tree.delete(n3);
        tree.delete(n1);
        System.out.println(" ");
        tree.inorder(tree.root);

    }
}

class TreeNode {
    static TreeNode NIL;
    int key;
    int data;
    boolean isVisited;
    int height;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int balance;



    public TreeNode() {
    }

    public TreeNode(int height) {
        this.height = height;
    }

    public TreeNode(int key, int data) {
        this.key = key;
        this.data = data;
        this.height = 0;
    }

    public TreeNode(int key, int data, int height) {
        this.key = key;
        this.data = data;
        this.height = height;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode getParent() {
        return parent;
    }
}
