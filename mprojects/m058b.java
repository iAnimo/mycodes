package mprojects;

public class m058b {
    
    /**
     * abcdef
     * k = 2
     * 
     * cdef ab
     */

     public String reverseLeftWord(String s, int n) {
         
        return s.substring(n, s.length()) + s.substring(0, n);
     }
}
