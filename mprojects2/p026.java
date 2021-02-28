package mprojects2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class p026 {
    public List<String> subs(String s){
        char[] str = s.toCharArray();
        String path = "";
        HashSet<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        process1(str, 0, set, path);
        for(String cur : set) {
            ans.add(cur);
        }
        return ans;
    }
    //二叉选择
    //左yes 右no
    public void process1(char[] str, int index, HashSet<String> set, String path) {
        if( index == str.length ){
            set.add(path);
            return;
        }
        String no = path;
        process1(str, index+1, set, no);
        String yes = path+String.valueOf(str[index]);
        process1(str, index+1, set, yes);
    }
    //扩展：非重复子序列的个数
}
