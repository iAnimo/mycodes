package leets;

import java.util.Arrays;

public class leet077 {
    /**
     * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]， 然后总共重复这个过程 K
     * 次。（我们可以多次选择同一个索引 i。）
     * 
     * 以这种方式修改数组后，返回数组可能的最大和。
     */

    /**
     * 第一步：将数组按照绝对值大小从大到小排序，「注意要按照绝对值的大小」 
     * 第二步：从前向后遍历，遇到负数将其变为正数，同时K--
     * 第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完 
     * 第四步：求和
     */
    int largestSumAfterKNegations(Integer[] A, int k) {
        Arrays.sort(A, (a1, a2) -> Math.abs(a2)-Math.abs(a1));  // 逆序
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 && k > 0) {
                A[i] *= -1;
                k --;
            }
        }

        while ( k -- > 0) {
            A[A.length-1] *= -1;
        }

        int result = 0;
        for (Integer a : A) {
            result += a;
        }
        return result;
    }     
}
