package mprojects2;
public class p029 {
    
    public int getMaxValue(int[] w, int[] v, int bag ){
        return process1(w, v, 0, 0, bag);
    }

    public int process1(int[] w, int[] v, int i, int curw, int bag) {
        if ( curw > bag ){
            return -1;
        }
        if ( i == w.length ){
            return 0;
        }
        int p1 = process1(w, v, i+1, curw, bag);
        int p2next = process1(w, v, i+1, curw+w[i], bag);
        int p2 = -1;
        if ( p2next != -1 ){
            p2 = v[i] + p2next;
        }
        return Math.max(p1, p2);
    }

    public int getMaxValue2(int[] w, int[] v, int bag ){
        return process2(w, v, 0, bag);
    }

    public int process2(int[] w, int[] v, int i, int rest) {
        if ( rest < 0 ){
            return -1;
        }
        if ( i == w.length ){
            return 0;
        }
        int p1 = process2(w, v, i+1, rest);
        int p2 = Integer.MAX_VALUE;
        if ( rest >= w[i] ){
            p2 = v[i] + process2(w, v, i+1, rest-w[i]);
        }
        return Math.max(p1, p2);
    }
}
