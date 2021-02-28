package utils;

public class RNode<V>{
    public V value;
    public RNode<V> next;
    public RNode<V> random;
    public RNode(V v){
        value = v;
    }
}