package mprojects2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import utils.Edge;
import utils.GNode;

public class p040 {
    /**
     * 
     * A B C D E 0 - - - -
     * 
     * A-> B(1),C(7),D(6) A B C D E 0 1 7 6 -
     * 
     * B-> C(2),E(170) ... A B C D E 0 1 3 5 9
     */
    public HashMap<GNode, Integer> dijkstral(GNode from) {
        HashMap<GNode, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from, 0);
        HashSet<GNode> selectedNodes = new HashSet<>();

        GNode minNode = getMinGNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                GNode toNode = edge.to;
                if (!distanceMap.containsKey(toNode) ) {
                    distanceMap.put(toNode, distance + edge.weigth);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weigth));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinGNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    /**
     * 返回当前最短路径的GNode
     * 注：无法使用小根堆,可以自己建立一个符合要求的小根堆p0040
     */
    private GNode getMinGNode(HashMap<GNode, Integer> distanceMap, HashSet<GNode> selectedNodes) {
        GNode minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entry<GNode, Integer> entry : distanceMap.entrySet()) {
            GNode node = entry.getKey();
            int distance = entry.getValue();
            if ( !selectedNodes.contains(node) && distance < minDistance ) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
