package mprojects;

import java.util.Deque;
import java.util.LinkedList;

public class m059a {
    
    public int[] maxSliding(int[] nums, int k) {

        if ( nums.length == 0 || k == 0 ) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q =  new LinkedList<>();

        int index = 0;

        for (int i = 0; i < res.length; i++) {
            
            if ( !q.isEmpty() && i - q.peekFirst() >= k ) {
                q.pollFirst();
            }

            while ( !q.isEmpty() && nums[i] > nums[q.peekLast()] ) {
                q.pollLast();
            }

            q.add(i);

            if ( i >= k-1 ) {
                res[index ++] = nums[q.peekFirst()];
            }
        }

        return res;
    }
}
