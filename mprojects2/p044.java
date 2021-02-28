package mprojects2;
import java.util.Stack;

public class p044 {
    
    class Record{
        public boolean finish1;
        public int base;
        public String from;
        public String to;
        public String other;
        public Record(String f, String t, String o) {
            from = f;
            to = t;
            other = o;
        }
        public Record(int b,String f, String t, String o) {
            base = b;
            from = f;
            to = t;
            other = o;
        }
        public Record(boolean f1,int b,String f, String t, String o) {
            finish1 = f1;
            base = b;
            from = f;
            to = t;
            other = o;
        }
    }

    public void hanoi3(int N) {
        if ( N < 1 ) {
            return;
        }
        Stack<Record> s = new Stack<>();
        s.add(new Record(false,N, "left", "right", "mid"));
        while ( !s.isEmpty() ){
            Record cur = s.pop();
            if ( cur.base == 1 ){
                System.out.println("move 1 from "+ cur.from + " to " + cur.to);
                if ( !s.isEmpty() ){
                    s.peek().finish1 = true;
                }
            } else {
                if ( !cur.finish1 ) {
                    s.push(cur);
                }
            }
        }
    }
}
