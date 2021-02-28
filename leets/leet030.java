package leets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class leet030 {

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     */

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
        topKFrequent(nums, 2);

    }

    // 容器适配器就是「优先级队列」
    // 出现频率前 k 高的元素 - 大顶堆
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // 使用哈希存储元素与频率的映射
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 使用小顶堆筛选前k个高频的元素，不能使用自然排序，需要重写比较的类函数
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b); // 堆中存放的是元素，但比较的应该是元素的频率
            }
        });
        int size = 0;
        for (Integer j : map.keySet()) {
            if (size < k) {
                pq.offer(j); // 前k个元素直接放入，自动排成小顶堆
                size++;
            } else if (map.get(j) > map.get(pq.peek())) {
                pq.poll();
                pq.add(j);
            }
        }

        // 返回结果
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        return ans;
    }

    // 寻找前k个最大的数--使用小顶堆
    public static List<Integer> topKMax(int[] nums, int k) {
        // 寻找前k个最小数，因此将小顶堆大小定义为k
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.offer(nums[i]); // 前k个数，直接入堆
            } else if (nums[i] > pq.peek()) { // 如果当前元素比堆顶元素大
                pq.poll(); // 说明堆顶元素（堆中最小元素）一定不属于前k大的数，出堆
                pq.offer(nums[i]); // 当前元素有可能属于前k大，入堆
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        return ans;
    }
}
