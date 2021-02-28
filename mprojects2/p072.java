package mprojects2;
import java.util.List;
import java.util.Vector;

public class p072 {
    

    /**
     * @param s
     * @return
     * 
     * 子问题：全排列(n) = ch + 全排列(n-1)
     */
    private static List<String> f(String s) {
        List<String> lsts = new Vector<String>();

        //出口
        if ( s.length() == 1 ) {
            lsts.add(s);
            return lsts;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String rest = s.substring(0, i)+s.substring(i+1);
            List<String> temps = f(rest);
            for (String t : temps) {
                lsts.add( "" + ch + t );
            }
        }
        return lsts;
    }

    //使用数组
    /**
     * 
     * @param chs 待排数据
     * @param i 当前位置
     */
    //元素交换
    static void f2(char[] chs, int i){
        //出口
        if ( i == chs.length -1 ) {
            System.out.println(String.valueOf(chs));
            return ;
        }

        for (int j = i; j < chs.length; j++) {
            {char tmp = chs[i]; chs[i] = chs[j]; chs[j] = tmp;} //试探
            f2( chs, i+1 );
            {char tmp = chs[i]; chs[i] = chs[j]; chs[j] = tmp;} //回溯
        }
    }

    
    public static void main(String[] args) {
        List<String> lsts = f("ABC");
        for (String lst : lsts) {
            System.out.println(lst);
        }
        System.out.println("----------");
        f2("ABC".toCharArray(), 0);
    }
}
