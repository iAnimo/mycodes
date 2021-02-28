package leets;

public class leet022 {
    
    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1。
     */

    // kmp
    void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while ( j >= 0 && s.charAt(i) != s.charAt(j+1) ) {
                j = next[j];
            }
            if ( s.charAt(i) == s.charAt(j+1) ) {
                j ++;
            }
            next[i] = j;
        }
    }

    void getNext2(int[] next, String s) {
        
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < s.length(); i++) {
            while ( j >= 0 && s.charAt(i) != s.charAt(j) )  { // j要保证大于0，因为下面有取j-1作为数组下表的操作
                j = next[j - 1]; // 注意这里，是要找前一位的对应的回退位置了
            }
            if ( s.charAt(i) == s.charAt(j) ) {
                j++;
            }
            next[i] = j;
        }
    }

    int kmp(String haystack, String needle){
        if ( needle.length() == 0 ) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while ( j >= 0 && haystack.charAt(i) != needle.charAt(j+1) ) {
                j = next[j];
            }
            if ( haystack.charAt(i) == needle.charAt(j+1) ) {
                j ++;
            }

            if ( j == (needle.length() - 1) ) {
                return i-needle.length()+1;
            }
        }
        return -1;
    }


}
