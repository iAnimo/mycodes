package mprojects2;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import utils.TNode;

public class p055 {
    /**
     * 1.层次遍历 = 宽度遍历，用队列
     * 2.设置层级遍历结束标志 - flag变量
     */

    public void level ( TNode head ) {
        if ( head == null ) {
            Queue<TNode> q = new LinkedList<>();
            q.add(head);
            while ( !q.isEmpty() ) {
                TNode cur = q.poll();
                System.out.println(cur.value + " ");
                if ( cur.left != null ) {
                    q.add( cur.left );
                }
                if ( cur.right != null ) {
                    q.add( cur.right );
                }
            }
        }
    }

    /**
     * 求取最大宽度
     */
    public int maxWidthUseMap(TNode head){
        if ( head == null ) {
            return 0;
        }
        Queue<TNode> q = new LinkedList<>();
        q.add(head);

        HashMap<TNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);

        int curLevel = 1;
        int curLevelNodes = 0; //出队时更新
        int max = 0;

        while ( !q.isEmpty() ) {
            TNode cur = q.poll();
            int curNodeLevel = levelMap.get(cur);
            if ( cur.left != null ) {
                levelMap.put(cur.left, curNodeLevel + 1);
                q.add( cur.left );
            }
            if ( cur.right != null ) {
                levelMap.put(cur.right, curNodeLevel + 1);
                q.add( cur.right );
            }

            if ( curLevelNodes == curLevel ){ //未结束该层
                curLevelNodes ++;
            } else { //到达下一层
                max = Math.max(max, curLevelNodes);
                curLevel ++;
                curLevelNodes = 1;
            }
        }
        return Math.max(max, curLevelNodes);
    }

    public int maxWidthNoMap(TNode head){
        if ( head == null ) {
            return 0;
        }
        Queue<TNode> q = new LinkedList<>();
        q.add(head);

        TNode curEnd = head; //当前层尾
        TNode nextEnd = null; //下一层尾

        int curLevelNodes = 0; //出队时更新
        int max = 0;

        while ( !q.isEmpty() ) {
            TNode cur = q.poll();
            if ( cur.left != null ) {
                q.add( cur.left );
                nextEnd = cur.left;
            }
            if ( cur.right != null ) {
                q.add( cur.right );
                nextEnd = cur.right;
            }
            curLevelNodes ++;
            if ( cur == curEnd ) {
                max = Math.max(max, curLevelNodes) ;
                curLevelNodes = 0;
                curEnd = nextEnd;
            }

        }
        return max;
    }
}
