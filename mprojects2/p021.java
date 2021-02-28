package mprojects2;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import utils.Edge;
import utils.GUnionSet;
import utils.Graph;
//最小生成树MST - 并查集
/*
1.边由权值排序
2.选择最小边，加入结果集，候选集减去边
3.重复2过程，直至结果集中添加了所有的节点
*/
public class p021 {
    public Set<Edge> kruskalMST(Graph graph) {
        GUnionSet unionSet = new GUnionSet();
        unionSet.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();  //小根堆     
        for ( Edge edge : graph.edges ){
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while ( !priorityQueue.isEmpty() ){
            Edge edge = priorityQueue.poll();
            if ( !unionSet.isSameSet(edge.from, edge.to) ){
                result.add(edge);
                unionSet.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
