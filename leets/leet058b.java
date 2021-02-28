package leets;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

public class leet058b {
    /**
     * 迭代法
     * 迭代法可以通过三个队列来模拟，一个队列放遍历的节点，一个队列放左区间下表，一个队列放右区间下表。
     */
    TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        TreeNode root = new TreeNode(0);   // 初始根节点
        Queue<TreeNode> nodeQue = new LinkedList<>();           // 放遍历的节点
        Queue<Integer> leftQue = new LinkedList<>();;                 // 保存左区间下表
        Queue<Integer> rightQue = new LinkedList<>();;                // 保存右区间下表
        nodeQue.add(root);                 // 根节点入队列
        leftQue.add(0);                    // 0为左区间下表初始位置
        rightQue.add(nums.length - 1);     // nums.size() - 1为右区间下表初始位置

        while (!nodeQue.isEmpty()) {
            TreeNode curNode = nodeQue.poll();
            Integer left = leftQue.poll();
            Integer right = rightQue.poll();
            Integer mid = left + ((right - left) / 2);

            curNode.val = nums[mid];       // 将mid对应的元素给中间节点

            if (left <= mid - 1) {          // 处理左区间
                curNode.left = new TreeNode(0);
                nodeQue.add(curNode.left);
                leftQue.add(left);
                rightQue.add(mid - 1);
            }

            if (right >= mid + 1) {         // 处理右区间
                curNode.right = new TreeNode(0);
                nodeQue.add(curNode.right);
                leftQue.add(mid + 1);
                rightQue.add(right);
            }
        }
        return root;
    }

}
