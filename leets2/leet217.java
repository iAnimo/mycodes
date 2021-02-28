package leets2;

import java.util.HashMap;
import java.util.Map;

public class leet217 {
    //  API
    class TwoSum {
        Map<Integer, Integer> freq = new HashMap<>();
        public void add(int number) {
            freq.put(number, freq.getOrDefault(number, 0) + 1);
        }

        public boolean find(int value) {
            for (Integer key : freq.keySet()) {
                int other = value - key;

                // case 1: key+key = value
                if (other == key && freq.get(key) > 1) {
                    return true;
                }

                // case 2: key + other = value
                if (other != key && freq.containsKey(other)) {
                    return true;
                }
            }
            return false;
        }
    }
}
