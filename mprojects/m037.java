package mprojects;

import java.util.LinkedList;
import java.util.Queue;

import utils.TNode;

public class m037 {
    
    public String serialize(TNode root) {
        if ( root == null ) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        while( !q.isEmpty() ) {
            TNode t = q.poll();
            if ( t != null ) {
                res.append( t.value + ",");
                q.add(t.left);
                q.add(t.right);
            } else {
                res.append("null,");
            }
        }
        res.append("]");
        return res+"";
    }

    public TNode deserialize(String data) {
        if ( data.equals("[]") ) {
            return null;
        }
        String[] vals = data.substring(1, data.length()-1).split(",");
        TNode root = new TNode(Integer.parseInt(vals[0]));
        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        int k = 1;
        TNode node;
        while ( !q.isEmpty() ){
            node = q.poll();
            if ( !vals[k].equals("null") ) {
                node.left = new TNode(Integer.parseInt(vals[k]));
                q.add(node.left);
                k ++;
            }
            if ( !vals[k].equals("null") ) {
                node.right = new TNode(Integer.parseInt(vals[k]));
                q.add(node.right);
                k ++;
            }
        }

        return root;
    }
}
