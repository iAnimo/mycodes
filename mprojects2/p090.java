package mprojects2;
import java.math.BigInteger;

public class p090 {

    public static void main(String[] args) {
        String res = multi("123555666","123555666");
        System.out.println(res);
        BigInteger res2 = BigInteger.valueOf(123555666).multiply(BigInteger.valueOf(123555666));
        System.out.println(res2);
    }

    private static String multi(String a, String b) {
        if ( a.length() <= 4 && b.length() <= 4 ) {
            return Integer.parseInt(a) * Integer.parseInt(b) + "";
        }
        if ( a.length() > 4 ){  //大于4位要拆分
            int M = a.length() / 2;
            String a1 = a.substring(0, M);
            String a2 = a.substring(M);

            // a1*b 补零 + a2*b
            return add( multi(a1, b) + zero(a2.length()), multi(a2, b) );
        }
        return multi(b, a);
    }

    private static String add(String a, String b) {
        if ( a.length() <= 8 && b.length() <=8 ) {  
            return Integer.parseInt(a) + Integer.parseInt(b) + "";
        }

        //大于8位要拆分
        String a1 = "0";
        String a2 = a;
        if ( a.length() > 8 ){
            a1 = a.substring(0, a.length()-8 ); 
            a2 = a.substring(a.length()-8 ); //后8位
        }

        String b1 = "0";
        String b2 = b;
        if ( b.length() > 8 ){
            b1 = b.substring( 0, b.length()-8 );
            b2 = b.substring( b.length()-8 );//后8位
        }

        String t = add(a2, b2);
        while ( t.length() < 8 ) t = "0" + t; //t小于8位前面要补零
        //t有进位 a1+b1 补进位 + t
        if ( t.length() > 8 ) {
            return add(add(a1, b1),"1") + t.substring(1); 
        }
        //t无进位 a1+b1 + t
        return add(a1,b1) + t;
    }

    private static String zero(int n) {
        if ( n == 0 ) return "";
        if ( n == 1 ) return "0";
        return zero(n/2) + zero(n/2) + zero(n%2);
    }
    
}
