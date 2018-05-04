package easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> nodeList = new ArrayList<>();
        if (root == null) {
            return nodeList;
        }
        nodeList.add(new ArrayList<>());
        levelOrderBottom(root, nodeList, 0);
        return nodeList;
    }

    private void levelOrderBottom(TreeNode root, List<List<Integer>> nodeList, int backIndex) {
        if (root == null) {
            return;
        }
        int index = nodeList.size() - backIndex - 1;
        List<Integer> nowList = nodeList.get(index);
        nowList.add(root.val);
        if (root.left == null && root.right == null) {
            return;
        }
        if (index == 0) {
            nodeList.add(index, new ArrayList<>());
        }
        levelOrderBottom(root.left, nodeList, backIndex + 1);
        levelOrderBottom(root.right, nodeList, backIndex + 1);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBst(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBst(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.val = nums[mid];
        root.left = sortedArrayToBst(nums, left, mid - 1);
        root.right = sortedArrayToBst(nums, mid + 1, right);
        return root;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && ((root.left == null && root.right == null && root.val == sum) || (hasPathSum(root
                .left, sum - root.val) || hasPathSum(root.right, sum - root.val)));
    }

}
