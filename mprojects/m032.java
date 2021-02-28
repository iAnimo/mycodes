package mprojects;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

public class m032 {
    public int[] levelOrder(TreeNode root) {
        if ( root == null ) {
            return new int[0];
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> ans = new LinkedList<>();
        while ( !q.isEmpty() ) {
            TreeNode r = q.poll();
            ans.add(r.val);
            if ( r.left != null ) {
                q.add(r.left);
            }
            if ( r.right != null) {
                q.add(r.right);
            }
        }
        
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
    
}
