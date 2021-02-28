package utils;

public class Edge {
    public int weigth;
    public GNode from;
    public GNode to;
    public Edge(int weight){
        this.weigth = weight;
    }
    public Edge(int weight, GNode from, GNode to){
        this.weigth = weight;
        this.from = from;
        this.to = to;
    }
}
