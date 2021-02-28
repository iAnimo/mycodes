package mprojects2;
import utils.RandomBox;

//随机函数可等概率范围1-5
//设置随机函数可等概率范围为1-7
//or
//随机函数可等概率范围a-b
//设置随机函数可等概率范围为c-d
/*thinking:
1-5 : 0,1
1）若将其等概率映射为0或1
2）再使用二进制表示范围
*/

public class p004 {
    //等概率返回0和1

    public int rand01(RandomBox randomBox){
        int min = randomBox.min();
        int max = randomBox.max();
        int size = max-min+1;
        boolean odd = (size&1)!=0; //奇偶判断
        int mid = size/2;
        int ans = 0;
        do{
            ans = randomBox.random()-min;
        }while( odd && ans == mid );
        return ans < mid ? 0 : 1;
    }
    public int randomTo(RandomBox randomBox, int leftBound, int rightBound){
        if( leftBound >= rightBound ){
            return leftBound;
        }
        int range = rightBound - leftBound;
        int bit = 1;
        //2^bit - 1 >= range
        while( ( 1 << bit ) - 1 < range ){ // 左移 = 值上升
            bit ++;
        }
        int ans = 0;
        do{
            ans = 0;
            for (int i = 0; i < bit; i++) {
                ans += ( rand01(randomBox) << i ); //位运算后的结果累加
            }
        }while( ans > range );
        return ans+leftBound;
    }
}
