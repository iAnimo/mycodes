package mprojects2;
public class p033 {
    public int f(int n){
        if( n == 1 ){
            return 1;
        }else if ( n == 2 ){
            return 1;
        }
        return f(n-1)+f(n-2);
    }
}
