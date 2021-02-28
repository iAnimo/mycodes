package mprojects2;
import java.math.BigInteger;

class Rati{
    private BigInteger zi = BigInteger.ZERO;
    private BigInteger mu = BigInteger.ONE;
    public Rati(long x){ //x为分子
        this(BigInteger.valueOf(x),BigInteger.ONE);
    }
    public Rati(BigInteger x){
        this(x, BigInteger.ONE);
    }
    public Rati(long x, long y){
        this(BigInteger.valueOf(x),BigInteger.valueOf(y));
    }
    public Rati(BigInteger x, BigInteger y){
        zi = x;
        mu = y;
        BigInteger g = gcd(zi, mu);
        zi = zi.divide(g);
        mu = mu.divide(g);
    }
    public String toString(){
        String s = zi.toString();
        if ( mu.equals(BigInteger.ONE) == false ) s += "/" + mu;
        return s;
    }
    static BigInteger gcd(BigInteger a, BigInteger b){
        if ( b.equals(BigInteger.ZERO) ) return a;
        return gcd(b, a.mod(b));
    }
    public Rati add(Rati it){
        return new Rati(zi.multiply(it.mu).add(mu.multiply(it.zi)),mu.multiply(it.mu));
    }
    public Rati mul(Rati it){
        return new Rati(zi.multiply(it.zi), mu.multiply(it.mu));
    }
}

public class p080 {
    
    public static void main(String[] args) {
        System.out.println(0.1+0.2); //0.30000000000000004
        System.out.println(0.1+0.2 == 0.3) ; //false
        //加大精度
        System.out.println(new Rati(1,3).add(new Rati(1,6)));
    }
}
