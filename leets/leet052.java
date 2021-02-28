package leets;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

import utils.TreeNode;



public class leet052 {
    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     * 结点左子树中所含结点的值 <= 当前结点的值 <= 结点右子树中所含结点的值
     */
    // 递归法
    // map<int, int> key:元素，value:出现频率
    void searchBST(TreeNode cur, Map<Integer, Integer> map) {
        if (cur == null) {
            return;
        }
        map.put(cur.val, map.get(cur.val)+1);
        searchBST(cur.left, map);
        searchBST(cur.right, map);
    }

    // 非二叉搜索树
    Vector<Integer> findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Vector<Integer> result = new Vector<>();

        if (root == null) {
            return result;
        }
        searchBST(root, map);
        // 按值排序
        map.entrySet().stream()   
        .sorted(Map.Entry.comparingByValue())
        .collect(
                Collectors.toMap(
                    Map.Entry::getKey, 
                    Map.Entry::getValue,
                    (oldVal, newVal) -> oldVal,
                    LinkedHashMap::new
                )
        );

        int pre = 0;
        for (Integer key : map.keySet()) {
            if ( pre != 0 && map.get(pre) != map.get(key)) {
                break;
            }
            result.add(map.get(key));
            pre = map.get(key);
        }
        return result;
    }

}
