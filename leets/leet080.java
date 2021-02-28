package leets;

public class leet080 {
    /**
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
     * 
     * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     */
    boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        // int two0 = 0;
        for (int bill : bills) {
            // case 1
            if (bill == 5) {
                five ++;
            }

            // case 2
            if (bill == 10) {
                if (five <= 0) {
                    return false;
                }
                ten ++;
                five --;
            }

            // case 3
            if (bill == 20) {
                if (five > 0 && ten > 0) {
                    five --;
                    ten --;
                    // two0 ++; // 20无需记录
                } else if ( five > 3) {
                    five -= 3;
                    // two0 ++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 只需要维护三种金额的数量，5，10和20。
     * 
     * 有如下三种情况：
     * 
     * 情况一：账单是5，直接收下。
     * 
     * 情况二：账单是10，消耗一个5，增加一个10
     * 
     * 情况三：账单是20，优先消耗一个10和一个5，如果不够，再消耗三个5
     * 
     * 局部最优：遇到账单20，优先消耗美元10，完成本次找零。
     * 
     * 全局最优：完成全部账单的找零。
     */

}
