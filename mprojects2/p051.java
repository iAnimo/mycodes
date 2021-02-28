package mprojects2;
import utils.TNode;

public class p051 {
    /**
     * 搜索二叉树：
     * 左子树 < 根 < 右子树
     */
    /**
     * 可能性：
     * 1.与X有关，有关性判定（左右子树都是BST，且左子树max < X < 右子树min）
     * 2.与X无关，下抛问题
     * 
     * 左树信息：最大搜索二叉子树 - maxBSTSize,
     *          isAllBST,max
     * 右树信息：最大搜索二叉子树 - maxBSTSize,
     *          isAllBST,min
     * 
     */
    class Info{
        public boolean isAllBST;
        public int max;
        public int min;
        public int maxBSTSize;
        public Info(boolean isAllBST, int max, int min, int maxBSTSize) {
            this.isAllBST = isAllBST;
            this.max = max;
            this.min = min;
            this.maxBSTSize = maxBSTSize;
        }
    }
    public Info process(TNode X){
        if( X == null ){
            return null;
        }
        Info leftInfo = process(X.left);
        Info rightInfo  = process(X.right);

        int max = X.value;
        int min = X.value;
        if ( leftInfo != null ){
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }

        if ( rightInfo != null ){
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }

        //可能性 1
        int maxBSTSize = 0;
        if ( leftInfo != null ) {
            maxBSTSize = leftInfo.maxBSTSize;
        }
        if ( rightInfo != null ) {
            maxBSTSize = Math.max(maxBSTSize, rightInfo.maxBSTSize );
        }

        boolean isAllBST = false;
        //可能性 2
        if (    ( leftInfo == null ? true : leftInfo.isAllBST )
            &&  ( rightInfo == null ? true : rightInfo.isAllBST )
            &&  ( leftInfo == null ? true : leftInfo.max < X.value )
            &&  ( rightInfo == null ? true : rightInfo.min > X.value )
           ) {
            // maxBSTSize = leftInfo.maxBSTSize + rightInfo.maxBSTSize + 1;
            maxBSTSize = (leftInfo == null ? 0 : leftInfo.maxBSTSize)
                        + (rightInfo == null ? 0 : rightInfo.maxBSTSize)
                        + 1;
            isAllBST = true;
        }
        return new Info(isAllBST,max,min,maxBSTSize);
    }
}
