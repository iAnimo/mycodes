package mprojects2;
public class p068 {

    //后n-1 + 第一个
    public static String f(String s) {
        if ( s.length() <= 1 ) return s; 
        return f(s.substring(1)) + s.charAt(0);
    }

    //最后一个 + 前n-1 
    public static String f2(String s) {
        if ( s.length() <= 1 ) {
            return s;
        }
        String ans = s.charAt(s.length()-1)+"";
        ans += f2(s.substring(0, s.length()-1));
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(f("abcdf"));
        System.out.println(f2("abcdf"));
    }
}
