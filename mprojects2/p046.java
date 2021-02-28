package mprojects2;
import utils.TNode;

public class p046 {
    /**     v11v
     * H1H 
     *      ^12^
     * 遍历方式：中序 - 左中右
     */
    
    public void printTree(TNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private void printInOrder(TNode head, int height, String to, int len) {
        if ( head == null ) {
            return;
        }
        printInOrder(head.right, height+1, "v", len);
        
        //打印当前
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = addSpace(lenL) + val + addSpace(lenR);
        System.out.println(addSpace(height*len) + len);

        printInOrder(head.left, height+1, "^", len);
    }

    private String addSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

}
