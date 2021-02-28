package utils;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class VUnionSet<V> {
    public HashMap<V,RNode<V>> nodes;
    public HashMap<RNode<V>,RNode<V>> parents;
    public HashMap<RNode<V>,Integer> sizeMap;
    public VUnionSet(List<V> values){
        for(V cur : values ){
            RNode<V> node = new RNode<>(cur);
            nodes.put(cur, node);
            parents.put(node, node);
            sizeMap.put(node, 1);
        }
    }
    public RNode<V> findFather(RNode<V> cur){
        Stack<RNode<V>> path = new Stack<>();
        while( cur != parents.get(cur) ){
            path.push(cur);
            cur = parents.get(cur);
        }
        while( !path.isEmpty() ){
            parents.put(path.pop(), cur);
        }
        return cur;
    }
    public boolean isSameSet(V a, V b){
        if( !nodes.containsKey(a) || !nodes.containsKey(b)){
            return false;
        }
        return findFather(nodes.get(a)) == findFather(nodes.get(b));
    }
    public void union(V a, V b){
        if( !nodes.containsKey(a) || !nodes.containsKey(b)){
            return ;
        }
        RNode<V> aHead = findFather(nodes.get(a));
        RNode<V> bHead = findFather(nodes.get(b));
        if( aHead != bHead ){
            int aSetSize = sizeMap.get(aHead);
            int bSetSize = sizeMap.get(bHead);
            RNode<V> big = (aSetSize >= bSetSize) ? aHead:bHead;
            RNode<V> small = (big == aHead) ? bHead: aHead;
            parents.put(small, big);
            sizeMap.put(big, aSetSize+bSetSize);
            sizeMap.remove(small);
        }
    }
    public int getSetNum(){
        return sizeMap.size();
    }
}