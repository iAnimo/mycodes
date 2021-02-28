package mprojects2;
import utils.TNode;

public class p050 {
    /**
     * 左：最大距离，高度
     * 右：最大距离，高度
     * 可能性：
     * 1.与X无关，最大距离不通过该点，则最大距离=左树或右树上的最大距离
     * 2.与X有关，最大距离通过该点，则最大距离 = 左高+1+右高
     */
    class Info{
        public int maxDistance;
        public int height;
        public Info(int dis, int h){
            maxDistance = dis;
            height = h;
        }
    }
    public Info process(TNode head){
        if ( head == null ) {
            return new Info(0,0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        
        int height = Math.max(
            leftInfo.height, 
            rightInfo.height);
        int mDis = Math.max(
            leftInfo.maxDistance, 
            rightInfo.maxDistance);
        int maxDistance = Math.max(
            mDis,
            height);

        return new Info(maxDistance, height);
    }
}
