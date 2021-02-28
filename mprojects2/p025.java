package mprojects2;
import java.util.ArrayList;
import java.util.List;

public class p025 {
    public List<String> subs(String s){
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str, 0, ans, path);
        return ans;
    }
    //二叉选择
    //左yes 右no
    public void process1(char[] str, int index, List<String> ans, String path) {
        if( index == str.length ){
            ans.add(path);
            return;
        }
        String no = path;
        process1(str, index+1, ans, no);
        String yes = path+String.valueOf(str[index]);
        process1(str, index+1, ans, yes);
    }
}
