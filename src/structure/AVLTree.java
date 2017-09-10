package structure;

/**
 * Created by xingxiaoyu on 17/9/9.
 */
public class AVLTree {
    TreeNode root;

    public AVLTree() {
        this.root = TreeNode.NIL;
    }

    public int height(TreeNode treeNode) {
        if (treeNode == TreeNode.NIL) {
            return -1;
        } else {
            return treeNode.height;
        }
    }

    public TreeNode right_right_rotate(TreeNode x) {
        TreeNode y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public TreeNode left_left_rotate(TreeNode y) {
        TreeNode x = y.left;
        y.left = x.right;
        x.right = y;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return x;
    }


    public TreeNode left_right_rotate(TreeNode x) {
        x.left = right_right_rotate(x.left);
        return left_left_rotate(x);
    }

    public TreeNode right_left_rotate(TreeNode x) {
        x.right = left_left_rotate(x.right);
        return right_right_rotate(x);
    }

    public TreeNode insert(TreeNode t, TreeNode z) {
        if (t == TreeNode.NIL) {
            t = z;
        } else {

            if (z.data < t.data) {
                t.left = insert(t.left, z);
                if (height(t.left) - height(t.right) == 2) {
                    if (z.data < t.left.data) {
                        t = left_left_rotate(t);
                    } else {
                        t = left_right_rotate(t);
                    }
                }
            } else if (z.data > t.data) {
                t.right = insert(t.right, z);
                if (height(t.right) - height(t.left) == 2) {
                    if (z.data < t.right.data) {
                        t = right_left_rotate(t);
                    } else {
                        t = right_right_rotate(t);
                    }
                }
            } else {

            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    public void insert(TreeNode x) {
        root = insert(root, x);
    }

    public TreeNode delete(TreeNode t, TreeNode d) {
        if (t == TreeNode.NIL) {
            return null;
        }
        if (d.data < t.data) {
            t.left = delete(t.left, d);
            if (height(t.right) - height(t.left) == 2) {
                if (height(t.right.left) > height(t.right.right)) {
                    t = right_left_rotate(t);
                } else {
                    t = right_right_rotate(t);
                }
            }
        } else if (d.data > t.data) {
            t.right = delete(t.right, d);
            if (height(t.left) - height(t.right) == 2) {
                if (height(t.left.left) > height(t.left.right)) {
                    t = left_left_rotate(t);
                } else {
                    t = left_right_rotate(t);
                }
            }
        } else {
            if (t.left != TreeNode.NIL && t.right != TreeNode.NIL) {
                if (height(t.left) > height(t.right)) {
                    TreeNode max = max(t.left);
                    t.data = max.data;
                    t.left = delete(t.left, max);

                } else {
                    TreeNode min = min(t.right);
                    t.data = min.data;
                    t.right = delete(t.right, min);
                }
            } else {
                t = (t.left != TreeNode.NIL) ? t.left : t.right;
            }
        }
        if (t != TreeNode.NIL) {
            t.height = Math.max(height(t.left), height(t.right)) + 1;
        }
        return t;
    }

    public void delete(TreeNode x) {
        root = delete(root, x);
    }

    public TreeNode max(TreeNode treeNode) {
        if (treeNode != TreeNode.NIL) {
            while (treeNode.right != TreeNode.NIL) {
                treeNode = treeNode.right;
            }
        }
        return treeNode;
    }

    public TreeNode min(TreeNode n) {
        if (n != TreeNode.NIL) {
            while (n.left != TreeNode.NIL) {
                n = n.left;
            }
        }
        return n;
    }


    public void inorder(TreeNode x) {
        if (x == TreeNode.NIL) {
            return;
        } else {
            inorder(x.left);
            System.out.println(x.data);
            inorder(x.right);
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
        AVLTree tree = new AVLTree();
        tree.insert(n1);
        tree.insert(n2);
        tree.insert(n3);
        tree.insert(n4);
        tree.insert(n5);
        tree.insert(n6);
        tree.insert(n7);
        tree.insert(n8);
        tree.insert(n9);
//        tree.inorder(tree.root);
        System.out.println("d 1");
        tree.delete(n5);
        tree.inorder(tree.root);
        System.out.println("d 7");
        tree.delete(n6);
        tree.inorder(tree.root);
        System.out.println("d 6");
        tree.delete(n1);
        tree.inorder(tree.root);
    }

}
