package mprojects2;
import java.util.HashMap;

import utils.Edge;
import utils.GNode;
import utils.NodeHeap;
import utils.NodeRecord;

public class p041 {
    
    public static HashMap<GNode, Integer> dijkstra2(GNode head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        HashMap<GNode, Integer> res = new HashMap<>();
        nodeHeap.addOrUpdateOrIgnore(head, 0); //起始点
        while ( !nodeHeap.isEmpty() ){
            NodeRecord record = nodeHeap.pop(); //返回小根堆中的最小记录
            GNode cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges ){ //更新堆
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weigth + distance);
            }
            res.put(cur, distance);
        }
        return res;
    }
}
