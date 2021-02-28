package mprojects2;
public class p095 {
    /*-----枚举算法--穷举算法----
    * 1. 现有m(<=24)根火柴，求拼出  a+b=c 的等式; 
    * 2. +=为4根; 注意：a+b=c b+a=c 为2种
    * 3. 0~1111之间枚举：20个火柴最多能组成10个1，因此A+B=C这个等式中A,B,C中任意一个数都不能超过1111。
    * 4. 穷举法，当a所需火柴数 + b所需火柴数 + c所需火柴数 = m-4
    */

	//计算一个数所需的火柴棒的数目
	public static int count(int x){
		//用来记录0~9每个数字所需的火柴数
		int a[] = { 6,2,5,5,4,5,6,3,7,6 };
		int num = 0;
		
		while(x/10 != 0){				//x不只一位数
			num += a[x%10];				//获取x的末尾数字
			x = x/10;					//去掉x的末尾数字，如x = 123,则后为x = 12
		}
		
		num += a[x];					//最后加上一定为1位数的火柴数
		return num;		
	}
 
	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		//int m = s.nextInt();			//火柴数
		
		int m = 18;
		int c,sum = 0;
		for(int a = 0; a <= 1111; a++){
			for(int b = 0; b <= 1111; b++){
				c = a + b;
				//当a所需火柴数 + b所需火柴数 + c所需火柴数 = m-4
				if (count(a) + count(b) + count(c) == m - 4 ) {
					sum++;
					System.out.println(a + "+" + b + "=" + c);
				}
            }
        }
		System.out.println("总共有： " + sum);
	}
}
