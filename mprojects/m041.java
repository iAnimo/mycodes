package mprojects;

import java.util.PriorityQueue;
import java.util.Queue;

public class m041 {
    Queue<Integer> Min = new PriorityQueue<>();
    Queue<Integer> Max = new PriorityQueue<>((x,y)->(y-x)); //大根

    void addNum(int num) {
        if ( Min.size() != Max.size() ) {
            Min.add(num);
            Max.add(Min.poll());
        } else {
            Max.add(num);
            Min.add(Max.poll());
        }
    }

    double findMedian() {
        return Min.size() == Max.size() ? (Min.peek()+Max.peek())/2.0:Min.peek();  
    }

    
}
