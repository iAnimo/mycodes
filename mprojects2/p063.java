package mprojects2;
public class p063 {
    /**
     * 顺时针转一下
     * 4 9 2
     * 3 5 7
     * 8 1 6
     * -------------"492357816"
     * 8 3 4
     * 1 5 9
     * 6 7 2
     * -------------"834159672"
     * 6 1 8
     * 7 5 3
     * 2 9 4
     * -------------"618753294"
     * 2 7 6
     * 9 5 1
     * 4 3 8
     * -------------"276951438"
     * 两边互换
     * 
     */
    String[] ans = { 
        "492357816","294753618",
        "834159672","438951276",
        "618753294","816357492",
        "276951438","672159834"
    };
    public void solutions(String s){
        for (int i = 0; i < ans.length; i++) {
            if ( match(s, ans[i]) ){
                prints(ans[i]);
            }
        }
    }

    private void prints(String ans) {
        System.out.println(ans.substring(0,3));
        System.out.println(ans.substring(3,6));
        System.out.println(ans.substring(6,9));
    }

    private boolean match(String s, String str) {
        for (int i = 0; i < str.length(); i++) {
            if ( s.charAt(i) == str.charAt(i) ) continue;
            if ( s.charAt(i) == '0' ) continue;
            return false;
        }
        return false;
    }
}
