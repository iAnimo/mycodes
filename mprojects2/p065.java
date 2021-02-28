package mprojects2;
public class p065 {
    /**
     * 年龄：3次方4位数，4次方6位数
     */
    int max_age = 100;
    public void solutions() {
        for (int i = 0; i < max_age; i++) {
            int a = i*i*i;
            int b = a*i;
            if ( (a+"").length() != 4 ) continue; 
            if ( (b+"").length() != 6 ) continue;
            System.out.println(i+"="+a+" - "+b);
        }
    }
}
