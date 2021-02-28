package mprojects2;
import java.util.ArrayList;

import utils.Tools;

public class p027 {
    public ArrayList<String> permutation(String str){
        ArrayList<String> res = new ArrayList<String>();
        if ( str == null || str.length() == 0 ){
            return res;
        }
        char[] chs = str.toCharArray();
        process1(chs, 0, res);
        return res;
    }

    //str[i...] i之后的字符都有机会来到第i个位置
    public void process1(char[] str, int i, ArrayList<String> res){
        if ( i == str.length ){
            res.add(String.valueOf(str));
        }
        for ( int j = i; j < str.length; j++ ){
            Tools.swap(str, i, j);
            process1(str, i+1, res);
            Tools.swap(str, i, j); //恢复现场
        }
    }
    //分支限界
    public void process2(char[] str, int i, ArrayList<String> res){
        if ( i == str.length ){
            res.add(String.valueOf(str));
            return;
        }
        boolean[] visit = new boolean[26];//字符使用 - 非共享
        for ( int j = i; j < str.length; j++ ){
            if( !visit[str[j]-'a'] ){
                visit[str[j]-'a'] = true;
                Tools.swap(str, i, j);
                process2(str, i+1, res);
                Tools.swap(str, i, j); //恢复现场
            }
        }
    }
}
