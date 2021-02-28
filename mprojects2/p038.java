package mprojects2;
import java.util.Arrays;

public class p038 {
    /**
     * 1.找到暴力递归(5种尝试)
     * 2.验证一下是否有重复解 - 无重复解则无需优化
     * 3.不讲究组织(可变参数) - 记忆化搜索
     * 4.对记忆化搜索做精细化组织 - 经典动态规划 O(N*logN)
     * tips：若记忆化搜索有枚举行为，可以使用动态规划优化
     */
    //f(i,rest)
    public static int ways1(int[] arr, int tar) {
        if (arr == null || arr.length == 0 || tar < 0) {
            return 0;
        }
        return process1(arr, 0, tar);
    }

    private static int process1(int[] arr, int i, int rest) {
        if (rest < 0) {
            return 0;
        }
        if (i == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int j = 0; j * arr[i] <= rest; j++) {
            ways += process1(arr, i + 1, rest - j * arr[i]);
        }
        return ways;
    }

    // 计划搜索
    public static int ways2(int[] arr, int tar) {
        if (arr == null || arr.length == 0 || tar < 0) {
            return 0;
        }
        // HashMap<String, Integer> map = new HashMap<>();
        int N = arr.length;
        int[][] dp = new int[N + 1][tar + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process2(arr, 0, tar, dp);
    }

    private static int process2(int[] arr, int i, int rest, int[][] dp) {
        if (dp[i][rest] != -1) {
            return dp[i][rest];
        }
        if (i == arr.length) {
            dp[i][rest] = rest == 0 ? 1 : 0;
            return dp[i][rest];
        }
        int ways = 0;
        for (int j = 0; j * arr[i] <= rest; j++) {
            ways += process2(arr, i + 1, rest - j * arr[i], dp);
        }
        dp[i][rest] = ways;
        // return dp[i][rest];
        return ways;
    }

    //动态规划 == 计划搜索
    public static int dpWays(int[] arr, int tar) {
        if (arr == null || arr.length == 0 || tar < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][tar + 1];
        dp[N][0] = 1; //dp[N][1..tar] = 0
        for (int i = N-1; i >= 0; i--) {
            for (int rest = 0; rest <= tar; rest++) {
                int ways = 0;
                for (int j = 0; j * arr[i] <= rest; j++) {
                    // ways += process2(arr, i + 1, rest - j * arr[i], dp);
                    ways += dp[i+1][rest-j*arr[i]];
                }
                dp[i][rest] = ways;
            }
        }
        return dp[0][tar];
    }
    //动态规划 - 优化枚举行为
    public static int dpWays2(int[] arr, int tar) {
        if (arr == null || arr.length == 0 || tar < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][tar + 1];
        dp[N][0] = 1; //dp[N][1..tar] = 0
        for (int i = N-1; i >= 0; i--) {
            for (int rest = 0; rest <= tar; rest++) {
                int ways = dp[i+1][rest];
                // for (int j = 0; j * arr[i] <= rest; j++) {
                //     ways += dp[i+1][rest-j*arr[i]];
                // }
                if ( rest-arr[i] >= 0 ){
                    ways += dp[i][rest-arr[i]];
                }
                dp[i][rest] = ways;
            }
        }
        return dp[0][tar];
    }
    public static void main(String[] args) {
        int[] arr = { 5, 10, 50, 100 };
        int sum = 1000;
        System.out.println(ways1(arr, sum));
        System.out.println(ways2(arr, sum));
        System.out.println(dpWays(arr, sum));
        System.out.println(dpWays2(arr, sum));
    }
}

