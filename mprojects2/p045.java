package mprojects2;
import java.util.Stack;

public class p045 {
    
    //取栈底元素
    public int getButton(Stack<Integer> stack) {
        int result = stack.pop(); //保存当前点
        if ( stack.isEmpty() ){
            return result;
        } else {
            int last = getButton(stack); //向上传递
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack){
        if ( stack.isEmpty() ) {
            return;
        }
        int res = getButton(stack); //保存当前点
        reverse(stack);
        stack.push(res);
    }
    /**
     * 1.设计暴力递归：重要原则+4中常见尝试模型
     * 2.分析有没有重复解：套路解决
     * 3.用记忆化搜索 -- 用严格表结构实现动态规划：套路解决
     * 4.看看能否继续优化：套路解决
     */
}
