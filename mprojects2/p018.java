package mprojects2;
import utils.Edge;
import utils.GNode;
import utils.Graph;

public class p018 {
    //由矩阵创建图
    public Graph createGraph(Integer[][] matrix){ //Nx3
        Graph graph = new Graph();
        for(int i=0; i<matrix.length; i++){
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new GNode(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new GNode(to));
            }
            GNode fromGNode = graph.nodes.get(from);
            GNode toGNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromGNode, toGNode);
            fromGNode.nexts.add(toGNode);
            fromGNode.out ++;
            toGNode.in ++;
            fromGNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
