package leets;

import java.util.Arrays;

public class leet081 {
    /**
     * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     * 
     * 对 people 排序
     */
    int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] - p2[0]);
        int[] que = new int[people.length]; // 记录元素所在的位置
        for (int i = 0; i < que.length; i++) {
            que[i] = i;
        }
        for (int i = 0; i < people.length; i++) {
            int position = people[i][1]; // 第 i 个元素
            // 将第 i 个元素插入到 position 位置
            insertToQue(que, i, position); // que[position]  -- k 
        }

        // 复原
        int[][] result = new int[people.length][2];
        for (int i = 0; i < que.length; i++) {
            result[i][0] = people[que[i]][0];
            result[i][1] = people[que[i]][1];
        }

        return result;
    }

    /**
     * 「局部最优：优先按身高高的people的k来插入。插入操作过后的people满足队列属性」
     * 
     * 「全局最优：最后都做完插入操作，整个队列满足题目队列属性」
     */
    
    // 将第 i 个元素插入到 position 位置
    public static void insertToQue(int[] que, int k, int position) { // 将元素插入
        int t = que[k];
        // 从后向前
        for (int i = k; i > position; i--) {
            que[i] = que[i-1];
        }
        que[position] = t;
    }

    public static void main(String[] args) {
        int[] que = new int[5]; 
        for (int i = 0; i < que.length; i++) {
            que[i] = i;
        }
        insertToQue(que, 1, 0);
        insertToQue(que, 3, 1);
    }

}
