package mprojects2;
public class p077 {
    /**
     * 有1，3，9三个砝码
     * 1:1
     * 2:3-1
     * 3:3
     * 4:3+1
     * 5:9-3-1
     */
    

	private static String reve(String s) {
        s = s.replace("-", "#");
        s = s.replace("+", "-");
        s = s.replace("#", "-");
        return s;
    }
    private static String f(int x) {
        int a = 1;
        while ( a < x ) a *= 3;
    
        if ( x == a ) return " "+a;
        if ( x <= a/2 ) return a/3 + "+" + f(x-a/3);
		return a + reve(f(x-a));
	}
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i+" "+f(i));
        }
    }
}
