package mprojects2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

//返回出现次数 > n/k 的数
//时间O(n) 空间O(k)
public class p007 {
    // 最多存在k-1个数 - 设置k-1个候选
    public List<Integer> kMajor(int[] arr, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> cands = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (cands.containsKey(arr[i])) {
                cands.put(arr[i], cands.get(arr[i]) + 1);
            } else {
                if (cands.size() == k - 1) {
                    // 所有cands - 1
                    minusOne(cands);
                } else {
                    cands.put(arr[i], 1);
                }
            }
        }
        HashMap<Integer, Integer> reals = getReals(arr, cands);
        for (Integer key : reals.keySet()) {
            if (reals.get(key) > arr.length / k) {
                ans.add(key);
            }
        }
        return ans;
    }

    private HashMap<Integer, Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (cands.containsKey(cur)) {
                if (ans.containsKey(cur)) {
                    ans.put(cur, ans.get(cur) + 1);
                } else {
                    ans.put(cur, 1);
                }
            }
        }
        return ans;
    }
    /*
     * tips: map集合遍历删除时，若不注意往往容易出现问题，出现 ConcurrentModificationException
     * 使用iterator迭代删除时没有问题的，在每一次迭代时都会调用hasNext（）方法判断是否有下一个，是允许集合中数据增加和减少的。
     * 使用forEach删除时，会报错ConcurrentModificationException，因为在forEach遍历时，
     * 是不允许map元素进行删除和增加。
     */
    private void minusOne(HashMap<Integer, Integer> cands) {
        Iterator<Entry<Integer, Integer>> iterator = cands.entrySet().iterator();
		while(iterator.hasNext()){
            Entry<Integer, Integer> cand = iterator.next();
            int value = cand.getValue();
            if( value == 1 ){
                //cands.remove(key);      //ConcurrentModificationException  
                iterator.remove();
            }else{
                cand.setValue(value-1);
            }
        }
    }
}
