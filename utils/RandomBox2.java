package utils;

//随机函数f，以p概率返回0，以1-p概率返回1
//实现等概率返回0和1
public class RandomBox2{
    private final double p;
    public RandomBox2(double zeroP){
        p = zeroP;
    }
    public int random(){
        return Math.random()<p?0:1;
    }
}