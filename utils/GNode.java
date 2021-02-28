package utils;

import java.util.ArrayList;

public class GNode {
    public int value;
    public int in;
    public int out;
    public ArrayList<GNode> nexts;
    public ArrayList<Edge> edges;
    public GNode(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}