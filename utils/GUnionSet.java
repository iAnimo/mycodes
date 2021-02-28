package utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

public class GUnionSet {
    private HashMap<GNode, GNode> fatherMap;
    private HashMap<GNode, Integer> sizeMap;

    public GUnionSet() {
        fatherMap = new HashMap<GNode, GNode>();
        sizeMap = new HashMap<GNode, Integer>();
    }

    public void makeSets(Collection<GNode> nodes) {
        fatherMap.clear();
        sizeMap.clear();
        for( GNode node:nodes ){
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    public GNode findFather(GNode node){
        Stack<GNode> path = new Stack<>();
        while( node != fatherMap.get(node) ){
            path.add(node);
            node = fatherMap.get(node);
        }
        while( !path.isEmpty() ){
            fatherMap.put(path.pop(), node);
        }
        return node;
    }

    public boolean isSameSet(GNode a, GNode b){
        return findFather(a) == findFather(b);
    }

    public void union(GNode a, GNode b){
        if( a == null || b == null ){
            return;
        }
        GNode aFNode = findFather(a);
        GNode bFNode = findFather(b);
        if( aFNode != bFNode ){
            int aSetSize = sizeMap.get(aFNode);
            int bSetSize = sizeMap.get(bFNode);
            if( aSetSize <= bSetSize ) {
                fatherMap.put(aFNode, bFNode); //aFNode作为其父节点
                sizeMap.put(bFNode, aSetSize+bSetSize);
                sizeMap.remove(aFNode);
            } else {
                fatherMap.put(bFNode, aFNode);
                sizeMap.put(aFNode, aSetSize+bSetSize);
                sizeMap.remove(bFNode);
            }
        }
    }
}
