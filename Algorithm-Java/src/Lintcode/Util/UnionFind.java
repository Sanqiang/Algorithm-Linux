package Lintcode.Util;

public class UnionFind {
	
	int[] arr;
	
	public void setVal(int ind, int val){
		this.arr[ind] = val; 
	}
	
	public int getVal(int ind){
		return this.arr[ind];
	}
	
	public UnionFind(int[] arr){
		this.arr = arr;
	}
	
	public UnionFind(int n){
		this.arr = new int[n];
		for (int i = 0; i < n; i++) {
			this.arr[i] = i;
		}
	}
	
	public int find(int ind) {
		while (true) {
			int father = this.arr[ind];
			if (father == ind) {
				return ind;
			}else{
				ind = father;
			}
		}
	}
	
	public int compressed_find(int ind){
		int root = find(ind);
		while (true) {
			int father = this.arr[ind];
			if(father == ind){
				break;
			}else{
				this.arr[ind] = root;
				ind = father;
			}
		}
		return root;
	}
	
	public void merge(int ind1, int ind2) {
		int father1 = find(ind1), father2 = find(ind2);
		if (father1 < father2) {
			this.arr[father2] = father1;
		}else{
			this.arr[father1] = father2;
		}
	}
	
	public void compressed_merge(int ind1, int ind2) {
		int father1 = compressed_find(ind1), father2 = compressed_find(ind2);
		if (father1 < father2) {
			this.arr[father2] = father1;
		}else{
			this.arr[father1] = father2;
		}
	}
	
	
	public static void main(String[] args) {
		UnionFind uFind = new UnionFind(10);
		uFind.merge(0, 1);
		uFind.merge(0, 3);
		System.out.println(uFind.find(1));
		System.out.println(uFind.find(2));
		
		uFind.compressed_merge(4, 5);
		uFind.compressed_merge(5, 9);
		System.out.println(uFind.compressed_find(9));
		System.out.println(uFind.compressed_find(8));
	}
}
