package mprojects;

public class m046 {
    public static int translateNum(int num){
        //dp[i]= dp[i-1]+dp[i-2]
        String s = String.valueOf(num);
        int a = 1;
        int b = 1;
        for (int i = 2; i < s.length(); i++) {
            String temp = s.substring(i-2, i);
            System.out.println(temp);
            int c = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? a+b:a;
            b = a;
            a = c;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(translateNum(212));
    }

    
}
