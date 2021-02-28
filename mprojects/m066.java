package mprojects;

public class m066 {

    // b[i] = a[0-(i-1)] * a[(i+1)-(n-1)]
    
    public static int[] constructArr(int[] a) {

        int n = a.length;
        int[] res = new int[n];

        for (int i = 0, p = 1; i < n; i++) {
            res[i] = p;
            p *= a[i];
        }

        for (int i = n-1, p = 1; i >= 0; i--) {
            res[i] *= p;
            p *= a[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        constructArr(a);
    }
}
