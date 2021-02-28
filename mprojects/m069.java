package mprojects;

public class m069 {
    
    public static void print(int n) {
        int pre = n;
        if ( n == 0 ) {
            return;
        }
        print(n-1);
        System.out.println(pre);
    }

    public static void main(String[] args) {
        print(6);
        printv(6);
    }

    private static void printv(int n) {
        System.out.println(n);
        if ( n == 1 ) {
            return;
        }
        printv(n-1);
    }

}
