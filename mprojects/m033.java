package mprojects;

public class m033 {
    public boolean verifyPostorder(int[] postorder){
        return dfs(postorder, 0, postorder.length); 
    }

    private boolean dfs(int[] postorder, int left, int right) {
        if ( left >= right ) 
            return false;
        int p = left;
        while ( postorder[p] < postorder[right] ) p ++;
        int mid = p;
        while ( postorder[p] > postorder[right] ) p ++;
        return (p == right) && dfs(postorder, left, mid-1) && dfs(postorder, mid, right);
    }
    
    
}
