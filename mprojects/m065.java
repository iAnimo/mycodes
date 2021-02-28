package mprojects;

public class m065 {
    
    public static int add(int a, int b) {
        while ( b != 0 ) {
            int c = (a&b)<<1;
            a ^= b;
            b = c;
        }

        return a;
    }

    public static void main(String[] args) {
        add(1, 3);
    }
}
