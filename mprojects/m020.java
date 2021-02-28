package mprojects;

public class m020 {
    /**
     * 小数点之前不能有：. e
     * e之前不能有：e 前后必须有数字
     * +,- 在第一个位置 或者 e之后的第一个位置
     */
    public boolean isNumber(String s){
        if ( s == null || s.length() == 0 ) {
            return false;
        }
        boolean num,dot,e;
        num = dot = e = false;
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if ( str[i] >= '0' && str[i] <= '9' ) {
                num = true;
            } else if ( str[i] == '.' ) {
                if ( dot | e ) {
                    return false;
                }
                dot = true;
            } else if ( str[i] == 'e' || str[i] == 'E' ) {
                if ( e || !num ) {
                    return false;
                }
                e = true;
                num = false;
            } else if ( str[i] == '+' || str[i] == '-' ) {
                if ( i != 0 && str[i-1] != 'e' && str[i-1] != 'E' ) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return num;
    }
}
