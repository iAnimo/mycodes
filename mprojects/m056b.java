package mprojects;

public class m056b {
    
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            
            for (int i = 0; i < 32; i++) {  // 低到高
                
                counts[i] += num & 1;
                num >>= 1;
            }
        }

        int res = 0;
        int mod = 3;
        for (int i = 0; i < 32; i++) {  // 高到低
            
            res <<= 1;
            res += counts[31-i] % mod;
        }

        return res;
    }

    public int singleNumber2(int[] nums) {

        int one = 0;
        int two = 0;
        for (int x : nums) {
            
            one = (one ^ x) & ~two;
            two = (two ^ x) & ~one;
        }

        return one;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,4,4,6};

        int ans = new m056b().singleNumber(nums);
        int ans2 = new m056b().singleNumber2(nums);

        System.out.println(ans);
        System.out.println(ans2);
    }
}
