package leets;

public class leet078c {
    /**
     * 
     * 贪心算法（方法二） 首先如果总油量减去总消耗大于等于零那么一定可以跑完一圈，说明 各个站点的加油站 剩油量rest[i]相加一定是大于等于零的。
     * 
     * 局部最优：当前累加rest[j]的和curSum一旦小于0，起始位置至少要是j+1，因为从j开始一定不行。 全局最优：找到可以跑一圈的起始位置
     */
    int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;     // 局部
        int totalSum = 0;   // 整体
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }

        if (totalSum < 0) {
            return -1;
        }
        return start;
    }
}
