package leets;

import utils.TreeNode;

public class leet047 {
    /**
     * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
     * 二叉树的根是数组中的最大元素。 
     * 左子树是通过数组中最大值左边部分构造出的最大二叉树。 
     * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
     * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。 构造树一般采用的是前序遍历
     */
    TreeNode traversal(int[] nums, int left, int right) {

        if ( left >= right) {
            return null;
        }
        // 找到节点的值 - 下标
        int maxi = left;
        for (int i = left+1; i < right; i++) {
            if ( nums[i] > nums[maxi] ) {
                maxi = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxi]);

        //遇到空节点，也就是数组区间为0 - 所以不用判断空节点
        root.left = traversal(nums, left, maxi);
        root.right = traversal(nums, maxi+1, right);

        return root;
    }

    TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums, 0, nums.length);
    }
}
