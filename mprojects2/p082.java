package mprojects2;
public class p082 {

    //2015-3-2 距离 1979-12-15
    static int day_diff(String date1,String date2){
        return Math.abs(get_day(date1) - get_day(date2));
    }

    //离基点的距离
    private static int get_day(String date) {
        int[] mons = { 0,31,28,31,30,31,30,31,31,30,31,30,31 };
        
        String[] datas = date.split("-");
        int year = Integer.valueOf(datas[0]);
        int mon = Integer.valueOf(datas[1]);
        int day = Integer.valueOf(datas[2]);

        int sum = 0;
        for (int i = 1; i < year; i++) {
            sum += 365;
            if ( is_leap_year(i) ) sum ++;
        }

        if ( is_leap_year(year) ) mons[2] ++;
        for (int i = 1; i < mon; i++) {
            sum += mons[i];            
        }
        sum += day;
        return sum;
    }

    private static boolean is_leap_year(int year) {
        return (year%4 == 0) || (year%100 != 0 && year%400 == 0)  ;
    }

    public static void main(String[] args) {
        // System.out.println(is_leap_year(2021)); 
        System.out.println(day_diff("1979-12-15", "2015-3-2"));
    }
}