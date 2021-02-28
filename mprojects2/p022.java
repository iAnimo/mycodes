package mprojects2;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import utils.Edge;
import utils.GNode;
import utils.Graph;

public class p022 {
    //prime
    /**
     * 初始化一个点集和邻边集
     * 1.首先，先加一个点
     * 2.将该点的出度边加入邻边集
     * 3.找最小的邻边，
     *      3.1 加入结果集
     *      3.2 将边对应的另一个点加入点集
     *      3.3 更新邻边集
     * 4.重复3过程直到所有点都在点集中
     * 
     */
    public Set<Edge> primeMST(Graph graph){

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        HashSet<GNode> nset = new HashSet<>(); //点集合
        HashSet<Edge> eset = new HashSet<>(); //边集合
        Set<Edge> result = new HashSet<>();
        //选一个node作为起始点
        for ( GNode node : graph.nodes.values() ){ 
            if ( !nset.contains(node) ){
                nset.add(node);
                for ( Edge edge : node.edges ){
                    if( !eset.contains(edge) ){
                        eset.add(edge);
                        priorityQueue.add(edge);
                    }
                }
                while ( !priorityQueue.isEmpty() ){
                    Edge edge = priorityQueue.poll();
                    GNode toNode = edge.to;
                    if ( !nset.contains(toNode) ){
                        nset.add(toNode);
                        result.add(edge);
                        for ( Edge nextEdge : toNode.edges ){
                            if( !eset.contains(nextEdge) ){
                                eset.add(nextEdge);
                                priorityQueue.add(nextEdge);
                            }
                        }
                    }
                }
            }
            break; //防森林
        }
        return result;
    }
}
