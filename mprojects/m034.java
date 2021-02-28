package mprojects;

import java.util.LinkedList;
import java.util.List;

import utils.TreeNode;

public class m034 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum){
        recur(root, sum);
        return res;
    }

    private void recur(TreeNode root, int target) {
        if ( root == null ) return;
        path.add(root.val);
        target -= root.val;
        if ( target == 0 && root.left == null && root.right == null ){
            res.add(new LinkedList<>(path));
        }
        recur(root.left, target);
        recur(root.right, target);
    }
}
