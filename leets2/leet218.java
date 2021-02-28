package leets2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet218 {
    // 哈希集合
    class TwoSum {
        Set<Integer> sum = new HashSet<>();
        List<Integer> nums = new ArrayList<>();

        public void add(int number) {
            for (int n : nums) {
                sum.add(n + number);
            }
            nums.add(number);
        }

        public boolean find(int value) {
            return sum.contains(value);
        }
    }
}
