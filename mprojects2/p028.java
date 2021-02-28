package mprojects2;
public class p028 {
    //1-A，2-B ... 26-Z
    //翻译字符，并返回可以转化结果的个数
    public int translateWords(String str){
        if ( str == null || str.length() == 0 ){
            return 0;
        }
        char[] chs = str.toCharArray();
        return process1(chs, 0);
    }

    //str[0..i-1]已完成，求i之后的转化结果个数
    public int process1(char[] str, int i) {
        if ( i == str.length ){ //到达字符串尾部
            return 1;
        }
        if ( str[i] == '0' ){  // 01 - (无法转化) 和 10 - J
            return 0;
        }
        // if ( str[i] <= '0' ){
        //     return 0;
        // }
        //剪枝
        if ( str[i] == '1' ){
            int res = process1(str, i+1); // i 单独作为部分
            if( i+1 < str.length ) {
                res += process1(str, i+2); // i,i+1 作为一部分
            }
            return res;
        }

        if ( str[i] == '2' ){
            int res = process1(str, i+1); // i 单独作为部分
            if( i+1 < str.length && str[i+1]<='6' ) {
                res += process1(str, i+2); // i,i+1 作为一部分
            }
            return res;
        }
        //3-9:C-I
        return process1(str, i+1);
    }


}
