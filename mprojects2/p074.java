package mprojects2;
import java.util.List;
import java.util.Vector;

public class p074 {
    
    

    /**
     * 取其中一个，然后从剩下的字母中挑m-1个
     * @param s
     * @param m
     * @return
     */
    private static List<String> f(String s,int m) {
        List<String> lsts = new Vector<String>();
        //出口
        if ( m == 0 ) {//不取
            lsts.add("");
            return lsts;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // String rest = s.substring(0, i)+s.substring(i+1);
            String rest = s.substring(i+1); //令相同的组合只出现一次
            List<String> ts = f(rest,m-1);
            for (String t : ts ) {
                lsts.add("" + ch + t);
            }
        }
        return lsts;
    }

    public static void main(String[] args) {
        List<String> lsts = f("ABCD", 3);
        for (String lst : lsts) {
            System.out.println(lst);
        }
    }
}
