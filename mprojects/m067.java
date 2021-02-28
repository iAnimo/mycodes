package mprojects;

public class m067 {
    
    public int str2Int(String s) {
        char[] c = s.trim().toCharArray();
        if ( c.length == 0 ) {
            return 0;
        }

        int res = 0;
        int sign = 1;

        int temp = Integer.MAX_VALUE;
        int index = 1;
        if ( c[0] == '-' ) {
            sign = -1;
        } else {
            index = 0;
        }

        for (int i = index; i < c.length; i++) {

            if ( c[i] < '0' || c[i] > '9' ) {
                break;
            }

            if ( res > temp || res == temp && c[i] > '7' ) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + c[i] - '0';
        }

        return sign * (int)res;
    }
}
