package mprojects2;
public class p085 {

    /**
     * 两位参加游戏的法师分别指挥某个小和尚向上走任意多级的台阶，但会被站在高级台阶上的小和尚阻挡，不能越过。两个小和尚也不能站在同一台阶，也不能向低级台阶移动。 
两法师轮流发出指令，最后所有小和尚必然会都挤在高段台阶，再也不能向上移动。轮到哪个法师指挥时无法继续移动，则游戏结束，该法师认输。 
对于已知的台阶数和小和尚的分布位置，请你计算先发指令的法师该如何决策才能保证胜出。 
     */
    public static void main(String[] args) {
        solve(new int[]{ 1,5,9 } ); //如果不能成组，舍弃最后一个
        solve(new int[]{ 1,5,8,10 });   //两个成组
    }

    /**
     * 组合博弈论 -- 转化为尼姆堆
     */
    private static void solve(int[] x) {
        for (int i = 0; i < x.length-1; i++) {
            for (int j = x[i]+1; j < x[i+1]; j++){
                int old = x[i];
                try{
                    x[i] = j;
                    if ( f(x) == false ){
                        System.out.println(old + " " + j);
                        return;
                    }
                }finally{
                    x[i] = old;
                }
            }
        }
    }

    /**
     * 尼姆堆
     */
    private static boolean f(int[] x) {
        int sum = 0;
        for (int i = 0; i < x.length-1; i += 2) {
            sum ^= x[i+1]-x[i]-1;
        }
        return sum != 0;
    }
    //C++ ac代码
    /*
        #include<iostream>
        #define N 102
        using namespace std; 
        int main(){
        int a[N],b[N];
            int n = 0,i,j,k,sum = 0;
            while(cin>>a[n])n++;//存储又有多少个小和尚 
            for(i=1; i<n; i++)b[i-1] = a[i] - a[i-1] - 1;// 进行Nim博弈的转换 
            for(i=0; i<n-1; i+=2) sum ^= b[i];//进行异或 
            if(sum==0)cout<<-1<<endl;//若开始局面为0 则必输 
            else//若非0 则必赢，因此 需要找到第一步 将局面变为0 的步骤 
            {
                for(i=0; i<n-1; ++i)//枚举移动第i堆  使得剩下的局面异或等于0，
                    for(j=1; a[i]+j<a[i+1]; ++j) {//枚举可以移动的步数  保证 前项移动j 步后 不会超过后项 
                        b[i] -= j;//拿走 j个 ，这里代表 前一个向上移动j步 
                        if(i!=0)b[i-1] += j;//它的后一堆b[i]向取走了j个，那莫前一堆 b[i-1] 则要增加j个 第一堆除外 
                    sum = 0;
                    for(k=0; k<n-1; k+=2) sum ^= b[k];//重新计算局面， 
                if(sum==0) {cout<<a[i]<<" "<<a[i]+j<<endl; break;}//若变成0  则后手必败，先手必赢。跳出即可； 
                    b[i] += j;//回溯 这不是必赢的操作 
                    if(i!=0) b[i-1] -= j; 
                }
            }
            return 0;   
        }
    */
}
