package mprojects2;

public class p031 {
    /** n只鳄鱼, 1个人
     * 鳄鱼数量(只) - 死否(yes,no)
     * 1-yes
     * 2-no
     * 3-yes
     * 4-no
     * 奇数只鳄鱼人不会死
     */
    
    /** 5个海盗A,B,C,D,E 100个金币
     * E(100)
     * D(0) E(100)
     * C(100) D(0) E(0) or C(99) D(1) E(0)
     * B(98) C(0) D(1) E(1)
     * A(97) B(0) C(1) D(1) E(1) or A(97) B(0) C(1) D(0) E(2) or A(97) B(0) C(1) D(2) E(0)
     */
    
    /** 欧拉信封：每人只能收发一封信，且保证每人都能收发到信
     * f(1)=0,f(2)=1,f(3)=2
     * f(5) = 4*(f(3)+f(4)) --> f(i) = (i-1)*(f(i-1)+f(i-2))
     * 
     */
    
}
