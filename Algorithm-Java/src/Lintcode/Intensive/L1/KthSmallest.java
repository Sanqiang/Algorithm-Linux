package Lintcode.Intensive.L1;

import java.util.Comparator;
import java.util.PriorityQueue;


public class KthSmallest {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
	class Entry{
		int x;
		int y;
		int val;
		 public Entry(int x, int y, int val){
			 this.val = val;
			 this.x = x;
			 this.y = y;
		 }
	}
	
	class QueueComp implements Comparator<Entry>{

		@Override
		public int compare(Entry o1, Entry o2) {
			return o1.val - o2.val;
		}
		
	}
	
    public int kthSmallest(int[][] matrix, int k) {
    	PriorityQueue<Entry> queue = new PriorityQueue<>(new QueueComp());
    	queue.add(new Entry(0, 0, matrix[0][0]));
    	
    	boolean[][] checked = new boolean[matrix.length][matrix[0].length];
    	
    	while (true) {
			Entry entry = queue.poll();
			if(--k==0){
				return entry.val;
			}
			
			if(entry.x+1 < matrix.length && !checked[entry.x][entry.y]){
				queue.add(new Entry(entry.x+1, entry.y, matrix[entry.x+1][entry.y]));
				checked[entry.x+1][entry.y] = true;
			}
			if(entry.y+1 < matrix[0].length && !checked[entry.x][entry.y+1]){
				queue.add(new Entry(entry.x, entry.y+1, matrix[entry.x][entry.y+1]));
				checked[entry.x][entry.y+1] = true;
			}
			
		}
    }
    
    public static void main(String[] args) {
    	int[][] matrix = {{1,5,7},{3,7,8},{4,8,9}};
    	int value =new KthSmallest().kthSmallest(matrix, 6);
    	System.out.println(value);
	}
}
