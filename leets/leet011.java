package leets;

import java.util.HashSet;
import java.util.Set;

public class leet011 {
    
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     */
    public int[] intersection(int[] a, int[] b) {
        
        Set<Integer> aset = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            aset.add(a[i]);
        }

        for (Integer bi : b) {
            if ( aset.contains(bi) ) {
                aset.remove(bi);
            }
        }
        
        int[] res = new int[aset.size()];
        int k = 0;
        for (Integer ai : aset) {
            res[k++] = ai;
        }

        return res;
    }

    public int[] intersection3(int[] a, int[] b) {

        Set<Integer> aset = new HashSet<>();
        Set<Integer> bset = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            aset.add(a[i]);
        }

        for (Integer bi : b) {
            bset.add(bi);
        }

        aset.removeAll(bset);

        int[] res = new int[aset.size()];
        int k = 0;
        for (Integer ai : aset) {
            res[k++] = ai;
        }
        return res;
    }
    
    public Set<Integer> intersection2(Set<Integer> a, Set<Integer> b) {

        Set<Integer> numSet = new HashSet<>(a);
        Set<Integer> numSet2 = new HashSet<>(b);
        numSet.removeAll(numSet2);

        return numSet;

    }
}
