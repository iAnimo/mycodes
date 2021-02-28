package mprojects2;
public class p096 {
    static boolean lian_tong(char[][] data, int y1, int x1, int y2, int x2){
        if ( y1 == y2 && x1 == x2 ) return true;
        char old = data[y1][x1];
        data[y1][x1] = '*';
        try{
            //四个方向
            if ( y1 > 0 && data[y1-1][x1] == old && lian_tong(data, y1-1, x1, y2, x2) ) return true;
            if ( y1 < data.length-1 && data[y1+1][x1] == old && lian_tong(data, y1+1, x1, y2, x2) ) return true;
            if ( x1 > 0 && data[y1][x1-1] == old && lian_tong(data, y1, x1-1, y2, x2) ) return true;
            if ( x1 < data.length-1 && data[y1][x1+1] == old && lian_tong(data, y1, x1+1, y2, x2) ) return true;
            //对于边界点，我们可以扩张数组，加入边界
        }finally{
            data[y1][x1] = old;
        }
        return false;
    }
}
