package mprojects2;
public class p070 {
    
    /**
     * 
     * @param a 等待进栈数目
     * @param b 栈中的个数
     * @return 进站顺序的总数
     */
    static int f(int a, int b) {
        if ( a == 0 ) return 1;
        if ( b == 0 ) return f(a-1, 1);
        return f(a-1, b+1) + f(a,b-1);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 16; i++) {
            System.out.println(i+":"+f(i,0));
        }
    }
}
