package utils;

import java.util.HashMap;

public class NodeHeap {
    private GNode[] nodes;
    private HashMap<GNode, Integer> heapIndexMap; //记录已经进入堆的节点，出去的节点记为-1
    private HashMap<GNode, Integer> distanceMap;
    private int size;

	public NodeHeap(int size) {
        nodes = new GNode[size];
        heapIndexMap = new HashMap<>();
        distanceMap = new HashMap<>();
        size = 0;
    }

	public void addOrUpdateOrIgnore(GNode node, int distance) {
        if ( isInHeap(node) ){
            distanceMap.put(node, Math.min(distance, distanceMap.get(node)));
            insertHeap(node, heapIndexMap.get(node)); //加入并调整堆
        }
        if ( !isEntered(node) ){
            nodes[size] = node;
            heapIndexMap.put(node, size);
            distanceMap.put(node, distance);
            insertHeap(node, size++); //加入并调整堆
        }
    }
    
    private void insertHeap(GNode node, int index) { //从下往上调整
        // (index-1)/2 - 父节点
        while ( distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index-1)/2]) ){
            swap( index, (index-1)/2 );
            index = (index-1)/2;
        }
    }

    public NodeRecord pop() {
        NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]) );
        swap(0, size-1);
        heapIndexMap.put(nodes[size-1], -1);
        distanceMap.remove(nodes[size-1]);
        nodes[size-1] = null;
        heapify(0, -- size); //调整堆
		return nodeRecord;
	}

    private void heapify(int index, int size) { //自顶向下调整堆
        int left = index * 2 + 1; //左
        while ( left < size ) {
            int smallest = left + 1 < size && distanceMap.get(nodes[left+1]) < distanceMap.get(nodes[left])
                            ? left + 1
                            : left;
            smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index])
                            ? smallest
                            : index;
            if ( smallest == index ){
                break; //无需调整
            }
            swap(smallest, index);
            index = smallest;
            left = index * 2 + 1;
        }
    }

    private void swap(int i, int j) { //堆中位置与元素的交换
        heapIndexMap.put(nodes[i], j);
        heapIndexMap.put(nodes[j], i);
        GNode tmp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = tmp;
    }

    public boolean isEntered(GNode node) {
        return heapIndexMap.containsKey(node);
    }

    public boolean isInHeap(GNode node){
        return isEntered(node) && heapIndexMap.get(node) != -1;
    }

	public boolean isEmpty() {
		return size == 0;
	}
}
