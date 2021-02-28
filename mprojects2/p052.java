package mprojects2;
import utils.Employee;

public class p052 {
    /**
     * 1.直接上级在场,则其直接下属不会参加
     * 2.在不破坏第一条规则的情况下,返回最大快乐值
     */

    /**
     * 可能性
     * 1.X不来
     * 最大快乐值 = 0 + Math.max(最大快乐值[其下属不来],最大快乐值[其下属来])
     * 2.X来
     * 最大快乐值 = X.happy + 最大快乐值[其下属不来]
     */

    class Info{
        public int yes_value;
        public int no_value;
        public Info(int yes, int no) {
            yes_value = yes;
            no_value = no;
        }
    }

    public Info process2(Employee X){
        if ( X.subordinates.isEmpty() ){
            return new Info(X.happy, 0);
        }
        int yes_value = X.happy;
        int no_value = 0;
        for ( Employee sub : X.subordinates ){
            Info subInfo = process2(sub);
            yes_value += subInfo.no_value;
            no_value += Math.max(subInfo.yes_value, subInfo.no_value);
        }
        return new Info(yes_value, no_value);
    }
}
