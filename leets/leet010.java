package leets;

public class leet010 {

    /**
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines
     * 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
     * 
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
     */

    public static boolean canConstruct(String ransomNote, String magazine) {

        int len = 0;
        for (int i = 0; i < magazine.length(); i++) {
            for (int j = len; j < ransomNote.length(); j++) {
                // 在ransomNote中找到和magazine相同的字符
                if (magazine.charAt(i) == ransomNote.charAt(j)) { 
                    len ++;
                    // ransomNote.erase(ransomNote.begin() + j); // ransomNote删除这个字符
                    break;
                }
            }
        }
        // 如果ransomNote为空，则说明magazine的字符可以组成ransomNote
        if (ransomNote.length() == len) { 
            return true;
        }
        return false;
    
    }

    // 哈希解法
    public static boolean canConstruct2(String ransomNote, String magazine) {

        int[] record = new int[26];
        for (char ch : ransomNote.toCharArray()) {
            record[ch-'a'] ++;
        }

        for (char ch : magazine.toCharArray()) {
            record[ch-'a'] --;

            if ( record[ch-'a'] < 0 ) {   // 限制当前字符个数
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa","aab"));
        System.out.println(canConstruct2("aa","aba"));
    }
}
