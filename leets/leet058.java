package leets;

import utils.TreeNode;

public class leet058 {
    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     */
    // 递归
    TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, left, mid-1);
        root.right = traversal(nums, mid+1, right);
        return root;
    }

    TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length-1);
    }
}
