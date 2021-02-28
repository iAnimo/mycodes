package mprojects2;
//找出现次数大于n/2的数
public class p006 {
    //一次删除两个不同的数，查看剩余的部分
    public int halfMajor(int[] arr) {
        int candidate = 0;
        int HP = 0; //血量
        for (int i = 0; i < arr.length; i++) {
            if( HP==0 ){
                candidate = arr[i];
                HP = 1;
            }else if( arr[i] == candidate ){
                HP ++;
            }else{
                HP --;
            }
        }
        if( HP == 0 ){
            return -1;
        }
        HP = 0;
        for (int i = 0; i < arr.length; i++) {
            if( candidate == arr[i] ){
                HP ++;
            }
        }
        return HP>arr.length/2?candidate:-1;
    }
}
