package mprojects;

public class m013 {
    // 机器人的运动范围
    int m, n, k;
    boolean[][] visited;
    public int m13(int m_,int n_,int k_){
        m = m_; n=n_; k=k_;
        visited = new boolean[m][n];
        return def(0,0, 0,0); 
    }

    private int def(int x, int y, int sx, int sy) {
        //边界优先
        if(x>=m|| y>=n|| k<sx+sy || visited[m][y]) return 0;
        visited[x][y]=true;
        return 1+ def(x+1, y,sx=(x+1)%10!=0 ?sx+1: sx-8, sy) //x+1
            +def(x, y+1, sx, sy=(y+1)%10!=0 ?sy+1: sy-8); // y+1
    }
}