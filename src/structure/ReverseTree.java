package structure;

/**
 * Created by xingxiaoyu on 17/9/9.
 */
public class ReverseTree {
    public TreeNode2 createBiTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        TreeNode2 t = create(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return t;
    }

    public TreeNode2 create(int[] pre, int[] in, int ps, int pe, int is, int ie) {
        TreeNode2 root = new TreeNode2(pre[ps]);
        if (pe == ps && is == ie) {
            return root;
        }
        int root_n = 0;
        for (root_n = is; root_n <= ie; root_n++) {
            if (pre[ps] == in[root_n]) {
                break;
            }
        }
        int leftlen = root_n - is;
        int rightlen = ie - root_n;
        if (leftlen > 0) {
            root.left = create(pre, in, ps + 1, ps + leftlen, is, root_n - 1);
        }
        if (rightlen > 0) {
            root.right = create(pre, in, ps + leftlen + 1, pe, root_n + 1, ie);
        }
        return root;

    }

    int s;

    public void checkPre(TreeNode2 t) {
        if (t != null) {
            if (s != 0) System.out.print(" ");
            s++;
            System.out.print(t.data);
            checkPre(t.left);
            checkPre(t.right);
        }
    }
    int s2;
    public String checkIn(TreeNode2 t) {
        String s = "";
        if (t != null) {
            s += checkIn(t.left);
            if (s2 != 0) s+=" ";
            s2++;
            s += t.data;
            s += checkIn(t.right);

        }
        return s;
    }

    public static void main(String[] args) {
        int pre[] = {1, 2, 3};
        int in[] = {2, 1, 3};
        ReverseTree c = new ReverseTree();
        TreeNode2 root = c.createBiTree(pre, in);
        System.out.print("先序遍历结果:  {");
        c.checkPre(root);
        System.out.println("}");
        System.out.print("中序遍历结果:  {");
        System.out.print(c.checkIn(root));
        System.out.println("}");

    }

}

class TreeNode2 {
    int data;
    TreeNode2 left;
    TreeNode2 right;

    public TreeNode2(int data) {
        this(data, null, null);
    }

    public TreeNode2(int data, TreeNode2 left, TreeNode2 right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}