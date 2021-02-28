package leets;

import utils.TreeNode;

public class leet088 {
    /**
     * 给定一个二叉树，我们在树的节点上安装摄像头。
     */
    /**
     * 从下往上看，局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，整体最优：全部摄像头数量所用最少！
     */
    int result = 0;

    int minCameraCover(TreeNode root) {
        result = 0;

        // case 4 情况4：头结点没有覆盖
        if (traversal(root) == 0) {
            result++;
        }

        return result;
    }

    // 左右中
    private int traversal(TreeNode cur) {
        if (cur == null) {
            return 2;
        }
        int left = traversal(cur.left);
        int right = traversal(cur.right);

        // case 1 情况1：左右节点都有覆盖
        if (left == 2 && right == 2) {
            return 0; // 父节点无覆盖 - 状态0
        }

        // case 2 情况2：左右节点至少有一个无覆盖的情况
        if (left == 0 || right == 0) {
            result++;
            return 1; // 父节点单侧覆盖 - 状态1
        }

        // case 3 情况3：左右节点至少有一个有摄像头
        if (left == 1 || right == 1) {
            return 2; // 父节点有覆盖 - 状态2
        }

        return -1;
    }

    // 精简
    int traversal2(TreeNode cur) {
        if (cur == null) {
            return 2;
        }
        int left = traversal2(cur.left); // 左
        int right = traversal2(cur.right); // 右
        if (left == 2 && right == 2) { // 双侧覆盖
            return 0;
        } else if (left == 0 || right == 0) { // 存在无覆盖
            result++;
            return 1;
        } else { // other
            return 2;
        }
    }
}
