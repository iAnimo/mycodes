package mprojects2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.GNode;
import utils.Graph;

public class p020 {
    
    public List<GNode> sortedTopology(Graph graph){
        HashMap<GNode, Integer> inMap = new HashMap<>();//记录节点的入度
        Queue<GNode> zeroInQueue = new LinkedList<>(); //入度为零的节点
        for(GNode node:graph.nodes.values()){
            inMap.put(node, node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }
        
        List<GNode> res = new ArrayList<>();
        while(!zeroInQueue.isEmpty()){
            GNode cur = zeroInQueue.poll();
            res.add(cur);
            for(GNode next:cur.nexts){
                inMap.put(next, inMap.get(next)-1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return res;
    }
}
