package mprojects2;
public class p069 {
    //走到x,y位置有多少种
    //从(1,1)位置出发，只能向下或向右走
    static int f(int x, int y){
        if ( x == 1 || y == 1 ) return 1;
        return f(x-1,y) + f(x,y-1);
    }
    public static void main(String[] args) {
        System.out.println(f(1,2));
    }
}
