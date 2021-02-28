package mprojects2;
import java.util.ArrayList;

import utils.TNode;
//子树包含
public class p012 {

    // 复杂度 O(n*m)
    public boolean containTree1(TNode big, TNode small){
        if( small == null ){
            return true;
        }
        if( big == null ){
            return false;
        }
        if( isSameStructure(big, small) ){
            return true;
        }
        return containTree1(big.left, small) && containTree1(big.left, small);
    }

    //结构相同
    public boolean isSameStructure(TNode big, TNode small) {
        if( big == null && small != null ){
            return false;
        }
        if( big != null && small == null ){
            return false;
        }
        if( big == null && small == null ){
            return true;
        }
        if( big.value != small.value ){
            return false;
        }
        return isSameStructure(big.left, small.left) && isSameStructure(big.right, small.right);
    }
    //序列化后使用KMP算法
    public boolean containTree2(TNode big, TNode small) {
        if( small == null ){
            return true;
        }
        if( big == null ){
            return false;
        }
        ArrayList<String> b = preSerial(big);
        ArrayList<String> s = preSerial(big);

        //主串
        String[] str = new String[b.size()];
        for (int i = 0; i < str.length; i++) {
            str[i] = b.get(i);
        }

        //子串
        String[] match = new String[s.size()];
        for (int i = 0; i < match.length; i++) {
            match[i] = s.get(i);
        }
        return getIndexOf(str, match) != -1;
    }

    public int getIndexOf(String[] str, String[] match) {
        //边界
        if( str.length == 0 || match.length == 0 || str.length < 1 || str.length < match.length){
            return -1;
        }
        int i = 0;
        int j = 0;
        int[] next = getNextArray(match);
        while( i<str.length && j<match.length ){
            if( str[i].equals(match[j]) ){
                i ++; j ++;
            }else if( next[j] == -1 ){
                i ++;
            }else{
                j = next[j];
            }
        }
        return j == match.length ? (i-j):-1;
    }

    public int[] getNextArray(String[] ms) {
        if( ms.length == 0 ){
            return new int[]{ -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int k = 2;
        int cn = 0;
        while( k < next.length ){
            if( ms[k-1].equals(ms[cn]) ){
                next[k++] = ++ cn;
            }else if( cn > 0 ){
                cn = next[cn];
            }else{
                next[k++] = 0;
            }
        }
        return next;
    }
    //改进的getNextArray - 参考p1005
    public int[] getNextArray2(String[] ms) {
        if( ms.length == 0 ){
            return new int[]{ -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1; //初变量不得为0 注意思考将j移到首位的命令与移动i的命令的区别
        int i = 0; //为next赋值  因在下面循环中每次循环给next[i + 1]赋值 故初值为0
        int j = -1;
        while(i < ms.length - 1){
            if (j == -1 || ms[i] == ms[j]) {
                i ++; // 为i + 1赋值
                j ++; // 子串长度+1 或是 为使j由-1到0；
                if (ms[j] == ms[i])
                    next[i] = next[j];
                else
                    next[i] = j;
            }else{
                j = next[j];
            }
        }
        return next;
    }

    public ArrayList<String> preSerial(TNode head) {
        ArrayList<String> ans = new ArrayList<>();
        pres(head, ans);
        return ans;
    }

    public void pres(TNode head, ArrayList<String> ans) { //先序遍历
        if( head == null ){
            ans.add("null");
        }else{
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }
}
