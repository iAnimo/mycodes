package mprojects2;
public class p064 {
    
    public static int romaNum(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I')
                ans += 1;
            if (c == 'V')
                ans += 5;
            if (c == 'X')
                ans += 10;
            if (c == 'L')
                ans += 50;
            if (c == 'C')
                ans += 100;
            if (c == 'D')
                ans += 500;
            if (c == 'M')
                ans += 1000;
        }
        // 补偿
        if (s.indexOf("IV") >= 0) ans -= 2;
        if (s.indexOf("IX") >= 0) ans -= 2;
        if (s.indexOf("XL") >= 0) ans -= 20;
        if (s.indexOf("XC") >= 0) ans -= 20;
        if (s.indexOf("CD") >= 0) ans -= 200;
        if (s.indexOf("CM") >= 0) ans -= 200;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romaNum("MCCMXIV"));
        System.out.println(romaNum("CMXCIX")); //999
    }
}
