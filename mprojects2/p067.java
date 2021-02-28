package mprojects2;
public class p067 {
    static void g(int a, int b){
        if ( a < b ) g(a,b-1);
        System.out.println(b);
    }

    public static void main(String[] args) {
        g(1,10);
    }
}