package mprojects2;
public class p043 {
    /**
     * from -> to 1. 1~N-1 from -> other 2. N from -> to 3. 1~N-1 other -> to
     */
    public void hanoi2(int n) {
        if (n > 0) {
            fromTo2(n, "left", "right", "mid");
        }
    }

    private void fromTo2(int N, String from, String to, String other) {
        if (N == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            fromTo2(N - 1, from, other, to);
            System.out.println("Move " + N + " from " + from + " to " + to);
            fromTo2(N - 1, other, to, from);
        }
    }
}
