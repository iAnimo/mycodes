package mprojects2;
public class p011 {
    /** 案例
     * arr1     arr2
     * abcdef - bcdef a, cdef ab, def abc, ef abcd, f abcde
     */
    /**
     * 1.原数组arr1增加一倍
     * 2.检查arr2是否为arr1的子串
     */
    public boolean rotateChars(String arr1, String arr2){
        String temp = arr1 + arr1;
        // return isSubString(temp, arr2, arr1.length());
        return temp.contains(arr2);
    }

    public boolean isSubString(String temp, String arr2, int length) {
        return false;
    }
}
