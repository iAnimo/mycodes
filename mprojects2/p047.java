package mprojects2;
import utils.TNode;

public class p047 {
    /**
     * O(k)
     * 左中右
     * 1.有右树
     *      返回右树的最左节点
     * 2.无右树
     *      返回当前节点祖节点P的根P*（注：祖节点P为P*左子树的根）
     */

     public TNode getSuccessorNode(TNode node){
        if ( node == null ){
            return node;
        }
        if ( node.right != null ){
            return getLeftMost(node.right);
        } else {
            TNode parent = node.parent;
            while ( parent != null && parent.right != null ){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
     }

     private TNode getLeftMost(TNode node) {
        if ( node == null ) {
            return node;
        }
        while ( node.left != null ) {
            node = node.left;
        }
        return node;
     }

}
