package leets;

public class leet078 {
    /**
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     */
    // 暴力解法 - 时间复杂度O(n^2) 空间复杂度O(n)
    int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < cost.length; i++) {
            int rest = gas[i] - cost[i];
            int index = (i+1) % cost.length;
            // for循环适合模拟从头到尾的遍历，而while循环适合模拟环形遍
            while (rest > 0 && index != i) {
                rest += gas[index] - cost[index];
                index = (index + 1) % cost.length;
            }

            if (rest >=0 && index == i) {
                return i;
            }
        }
        return -1;
    }

}
