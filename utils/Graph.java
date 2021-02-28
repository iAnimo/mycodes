package utils;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer,GNode> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}