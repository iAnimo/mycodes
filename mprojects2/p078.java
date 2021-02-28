package mprojects2;
public class p078 {

    static String f(int x){
        String res = "";
        int w = 1;
        while( x > 0 ){ //3进制转化
            int sh = x / 3;
            // =0 忽略
            if ( x % 3 == 1 ) res = "+" + w + res;
            if ( x % 3 == 2 ) {
                sh ++;
                res = "-" + w + res;
            }
            x = sh;
            w *= 3;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i+" "+f(i));
        }
    }
}
