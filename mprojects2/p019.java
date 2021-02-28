package mprojects2;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import utils.GNode;

public class p019 {
    
    //图的遍历
    public void bfs(GNode node){ //广度遍历
        if(node == null){
            return;
        }
        Queue<GNode> queue = new LinkedList<>();//辅助队列
        HashSet<GNode> set = new HashSet<>(); //已访问节点
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            GNode cur = queue.poll();
            System.out.println(cur.value);
            for(GNode next:cur.nexts){
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
    public void dfs(GNode node){//深度遍历
        if(node == null){
            return;
        }
        Stack<GNode> stack = new Stack<>();
        HashSet<GNode> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while(!stack.isEmpty()){
            GNode cur = stack.pop();
            for(GNode next:cur.nexts){
                if(!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }

    }
}
