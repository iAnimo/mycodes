package mprojects2;
public class p084 {
    public static void main(String[] args) {
        System.out.println(game("***"));
        System.out.println(game("L**L"));
        System.out.println(game("L**L***L"));
        System.out.println(game("L*****L"));
    }

    /**
     * -1 LOSS
     * 0 ping
     * 1 WIN
     */
    private static int game(String s) {
        return f(s.toCharArray());
    }

    private static int f(char[] x) {
        String s = new String(x);
        if ( s.contains("LOL") ) return -1; //只要出现LOL他必赢
        if ( s.contains("*")==false ) return 0;

        boolean ping = false;
        for (int i = 0; i < x.length; i++) {
            if ( x[i] == '*' ){
                try{
                    x[i] = 'L'; //试探
                    switch(f(x)){
                        case -1: return 1;
                        case 0: ping = true;
                    }
                    x[i] = 'O'; //试探
                    switch(f(x)){
                        case -1: return 1;
                        case 0: ping = true;
                    }
                }finally{
                    x[i] = '*'; //回溯
                }
            }
        }
        if ( ping ) return 0;
        return -1;
    }
}
