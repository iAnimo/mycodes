package mprojects2;
import java.util.Scanner;

public class p094 {

    /**
     * -000
     * 0000
     * 0000
     */
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] data = new char[3][];
        data[0] = scan.nextLine().trim().toCharArray();
        data[1] = scan.nextLine().trim().toCharArray();
        data[2] = scan.nextLine().trim().toCharArray();

        solve(data);

        scan.close();
    }

    private static void solve(char[][] data) {//必胜-招法
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                try{
                    data[i][j] = '1';
                    if ( f(data) == false ) {
                        show(data);
                    }
                    data[i][j] = '-';
                    if ( f(data) == false ) {
                        show(data);
                    }
                }finally{
                    data[i][j] = '0';
                }
            }
        }
    }
    
    private static void show(char[][] data) {
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.println(new String(data[i]));
        }
    }

    static boolean f(char[][] data) { // 局面-赢否
        for (int i = 0; i < data.length; i++) {
            String s = new String(data[i]).replaceAll("0", "");
            if ( s.contains("--") ) return true;
        }
        
        for (int i = 0; i < data[0].length; i++) {
            String s = (""+data[0][i]+data[1][i]+data[2][i]);
            if ( s.contains("11") ) return true;
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if ( data[i][j] == '0' ) {
                    try{
                        data[i][j] = '1';
                        if ( f(data) == false ) return true;
                        data[i][j] = '-';
                        if ( f(data) == false ) return true;
                    }finally{
                        data[i][j] = '0';
                    }
                }
            }
        }
        return false;
    }
}
