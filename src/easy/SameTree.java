package easy;

public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return p == null && q == null || p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);

    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {

        return left == null && right == null || left != null && right != null && left.val == right.val && isSymmetric
                (left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
