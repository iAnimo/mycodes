package mprojects2;
public class p042 {
    /**
     * 思路
     * 1.将 左{N-1个盘} 通过 右 移动到  中{0} ; 中{n-1}
     * 2.将 左{盘N} 移动到 右{0} 中 ; 右{1} 
     * 3.将 中{n-1个盘} 通过 左 移动到 右{1} 中 ; 右{n}
     * 4.重复以上过程
     */
    public void hanoi1(int n){
        leftToRight(n);
    }
    //L-M->R
    private void leftToRight(int n) {
        if ( n == 1 ) {
            System.out.println("Move 1 L-M->R");
            return;
        }
        leftToMid(n-1);
        System.out.println("Move "+n+" L-M->R");
        midToRight(n-1);
    }
    //M-L->R
    private void midToRight(int n) {
        if ( n == 1 ) {
            System.out.println("Move 1 M-L->R");
            return;
        }
        midToLeft(n-1);
        System.out.println("Move "+n+" M-L->R");
        leftToRight(n-1);
    }
    //M-R->L
    private void midToLeft(int n) {
        if ( n == 1 ) {
            System.out.println("Move 1 M-R->L");
            return;
        }
        midToRight(n-1);
        System.out.println("Move "+n+" M-R->L");
        rightToLeft(n-1);
    }
    //L-R->M
    private void leftToMid(int n) {
        if ( n == 1 ) {
            System.out.println("Move 1 L-R->M");
            return;
        }
        leftToRight(n-1);
        System.out.println("Move "+n+" L-R->M");
        rightToMid(n-1);
    }

    //R-L->M
    private void rightToMid(int n) {
        if ( n == 1 ) {
            System.out.println("Move 1 R-L->M");
            return;
        }
        rightToLeft(n-1);
        System.out.println("Move "+n+" R-L->M");
        leftToMid(n-1);
    }

    //R-M->L
    private void rightToLeft(int n) {
        if ( n == 1 ) {
            System.out.println("Move 1 R-M->L");
            return;
        }
        rightToMid(n-1);
        System.out.println("Move "+n+" R-M->L");
        midToLeft(n-1);
    }
    
}
