package leets;

import java.util.Vector;

import utils.TreeNode;

public class leet052b {
    /**
     * 是二叉搜索树
     */
    // 中序遍历


    int maxCount;
    int count;
    TreeNode pre;
    Vector<Integer> result;

    Vector<Integer> findMode(TreeNode root) {
        count = 0; 
        maxCount = 0;
        pre = null; // 记录前一个节点
        result.clear();

        searchBST(root);
        return result;
    }

    void searchBST(TreeNode cur) {
        if (cur == null) {
            return;
        }
        searchBST(cur.left);

        if (pre == null) {
            count = 1;
        } else if (pre.val == cur.val) {
            count ++;
        } else {
            count = 1;
        }
        pre = cur;

        if (count == maxCount) {
            result.add(cur.val);
        }

        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(cur.val);
        }

        searchBST(cur.right);

        return;
    }
}
