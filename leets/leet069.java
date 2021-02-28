package leets;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class leet069 {
    /**
     * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
     */
    // unordered_map<出发机场, map<到达机场, 航班次数>> targets
    Map<String, Map<String, Integer>> targets = new HashMap<>();
    boolean backtracking(int ticketNum, Vector<String> result) {
        if (result.size() == ticketNum+1) {
            return true;
        }

        // 遍历双重map
        for (Map<String, Integer> target : targets.values()) {
            for (String key : target.keySet()) {
                if (target.get(key) > 0) {

                    result.add(key);
                    target.put(key, target.get(key)-1);

                    if (backtracking(ticketNum, result)) {
                        return true;
                    }

                    result.remove(key);
                    target.put(key, target.get(key)+1);
                    
                }
            }
        }

        return false;
    }

    Vector<String> findItinerary(Vector<Vector<String>> tickets) {
        targets.clear();
        Vector<String> result = new Vector<>();
        for (Vector<String> vec : tickets) {
            // targets[vec[0]][vec[1]]++; // 记录映射关系
            Map<String, Integer> next = new HashMap<>();
            next.put(vec.get(1), 1);
            targets.put(vec.get(0), next);
        }
        result.add("JFK"); // 起始机场
        backtracking(tickets.size(), result);
        return result;
    }
}
