package leets;

public class leet017 {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     */

    // 双指针解法
    public String reverseString(String s) {
        char[] sch = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (r > l) {
            char t = sch[l];
            sch[l] = sch[r];
            sch[r] = t;
            /**
             * s[i] ^= s[j]; s[j] ^= s[i]; s[i] ^= s[j];
             */
        }

        return sch.toString();
    }

    // 递归解法
    public String reverseString2(String s) {
        char[] sch = s.toCharArray();
        return reverseIt(sch, 0, sch.length-1);
    }

    private String reverseIt(char[] s, int l, int r) {    //[]
        
        if ( l == r ) {
            return s[l]+"";
        }
        if ( l > r) {
            return "";
        }

        return s[r] + reverseIt(s, l+1, r-1) + s[l]+"";
    }

    public static void main(String[] args) {
        System.out.println(new leet017().reverseString2("hello"));;
    }
}
