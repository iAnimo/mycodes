package leets;

import java.util.Stack;

import utils.TreeNode;

public class leet044b {
    /**
     * 迭代 - 使用栈模拟的前序遍历
     */
    class Pair<T, E> {
        T node;
        E value;
        public Pair() {
        }
		public Pair(T node, E value) {
			this.node = node;
			this.value = value;
		}
        
    }

    // 中左右 - 栈- 中，右左
    boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        st.push(new Pair<TreeNode, Integer>(root, root.val));

        while (!st.isEmpty()){
            Pair<TreeNode, Integer> pair = st.pop();
            if ( pair.node.left == null && pair.node.right == null && sum == pair.value) {
                return true;
            }
            if (pair.node.right != null) {
                st.push(new Pair<>(pair.node.right, pair.value+pair.node.right.val));
            }
            if (pair.node.left != null) {
                st.push(new Pair<>(pair.node.left, pair.value+pair.node.left.val));
            }
        }
        return false;
    }
}
