package mprojects;

public class m64 {

    int[] res = new int[]{0};

    public int sumNums(int n) {
        return n == 0 ? 0:n+sumNums(n+1);        
    }

    public int sumNums2(int n) {

        try {
            return res[n];
        } catch (Exception e) {
            return n + sumNums2(n-1);
        }
        
    }
    
}
