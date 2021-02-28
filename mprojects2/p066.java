package mprojects2;
public class p066 {
    
    static String numRoman(int x){
        //取位
        int x_1 = x % 10;
        int x_2 = x % 100 / 10;
        int x_3 = x % 1000 / 100;
        int x_4 = x / 1000;

        String s = "";

        if ( x_4 == 1 ) s += "M";
        if ( x_4 == 2 ) s += "MM";
        if ( x_4 == 3 ) s += "MMM";

        if ( x_3 == 1 ) s += "C";
        if ( x_3 == 2 ) s += "CC";
        if ( x_3 == 3 ) s += "CCC";
        if ( x_3 == 4 ) s += "CD";
        if ( x_3 == 5 ) s += "D";
        if ( x_3 == 6 ) s += "DC";
        if ( x_3 == 7 ) s += "DCC";
        if ( x_3 == 8 ) s += "DCCC";
        if ( x_3 == 9 ) s += "CM";

        if ( x_2 == 1 ) s += "X";
        if ( x_2 == 2 ) s += "XX";
        if ( x_2 == 3 ) s += "XXX";
        if ( x_2 == 4 ) s += "XL";
        if ( x_2 == 5 ) s += "L";
        if ( x_2 == 6 ) s += "LX";
        if ( x_2 == 7 ) s += "LXX";
        if ( x_2 == 8 ) s += "LXXX";
        if ( x_2 == 9 ) s += "XC";


        if ( x_1 == 1 ) s += "I";
        if ( x_1 == 2 ) s += "II";
        if ( x_1 == 3 ) s += "III";
        if ( x_1 == 4 ) s += "IV";
        if ( x_1 == 5 ) s += "V";
        if ( x_1 == 6 ) s += "VI";
        if ( x_1 == 7 ) s += "VII";
        if ( x_1 == 8 ) s += "VIII";
        if ( x_1 == 9 ) s += "IX";

        return s;
    }

    static boolean isRomanNum(String s){
        for (int i = 0; i < 4000; i++) {
            if ( s.equals(numRoman(i)) ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(numRoman(909));
        System.out.println(numRoman(99));
    }
}
