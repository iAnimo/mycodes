package mprojects2;
public class p083 {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(i+" "+f(i));
        }
    }

    /**
     * @param n balls  1,3,7,8
     * @return 
     */
    private static boolean f(int n) {
        if ( n == 0 ) return true; //对方取走了球

        if ( n>=1 && f(n-1)==false ) return true;
        if ( n>=3 && f(n-3)==false ) return true;
        if ( n>=7 && f(n-7)==false ) return true;
        if ( n>=8 && f(n-8)==false ) return true;
        return false;
    }
}
