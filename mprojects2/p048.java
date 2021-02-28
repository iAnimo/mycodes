package mprojects2;
public class p048 {
    // 折痕方向可以看做为一个二叉树
    /**
     * 凹-，凸+ -1 -2 +2 -3 +3 -3 +3
     */
    public void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    // 使用递归过程模拟二叉树遍历
    private void printProcess(int i, int N, boolean down) {// 中序
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 2;
        new p048().printAllFolds(N);
    }
    
}
