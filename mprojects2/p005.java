package mprojects2;
import utils.RandomBox2;

//随机函数f，以p概率返回0，以1-p概率返回1
//实现等概率返回0和1
public class p005 {
    //01=1 - 0,10=3 - 1
    public int rand01(RandomBox2 randomBox){
        int ans = 0;
        do{
            for (int i = 0; i < 2; i++) {
                ans += (randomBox.random()<<i);
                // ans |= (randomBox.random()<<i);
            }
        }while(ans == 0 && ans == 4);
        return ans;
    }
}
