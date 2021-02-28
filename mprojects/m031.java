package mprojects;

import java.util.Stack;

public class m031 {
    public boolean valid(int[] pushed, int[] poped) {
        Stack<Integer> temp = new Stack<>();
        int i = 0;
        for (int p : pushed) {
            temp.add(p);
            while ( !temp.empty() && temp.peek().equals(poped[i]) ) {
                temp.pop();
                i ++;
            }
        }

        return temp.empty();
    }
    
}
