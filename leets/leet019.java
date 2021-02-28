package leets;

public class leet019 {

    /**
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     */

    public String reverseStr(String s, int k){
        for (int i = 0; i < s.length(); i++) {
            if ( i+k <= s.length() ) {
                reverse(s, i, i+k-1);
                continue;
            }
            reverse(s, i, s.length()-1);
        }
        return s;
    }

    public String reverse(String s, int l, int r) {
        char[] sch = s.toCharArray();
        while ( r > l) {
            char t = sch[l];
            sch[l] = sch[r];
            sch[r] = t;
            /**
             * s[i] ^= s[j]; s[j] ^= s[i]; s[i] ^= s[j];
             */
            l ++;
            r --;
        }

        return sch.toString();
    }

}
