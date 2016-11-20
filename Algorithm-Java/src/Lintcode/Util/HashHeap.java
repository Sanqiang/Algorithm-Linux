package Lintcode.Util;

import java.util.ArrayList;
import java.util.HashMap;

class HeapNode{
	int pos_;
	int cnt_;
	public HeapNode(int pos, int cnt) {
		this.pos_ = pos;
		this.cnt_ = cnt;
	}
}

public class HashHeap {
	
	private ArrayList<Integer> heap_;
	private HashMap<Integer, HeapNode> hash_;
	private boolean is_max_;
	private int size_;
	
	public HashHeap(boolean is_max){
		this.heap_ = new ArrayList<Integer>();
		this.hash_ = new HashMap<Integer, HeapNode>(); 
		this.is_max_ = is_max;
	}
	
	//==============================implementation functions==============================//
	
	public void push(int value) {
		if(this.hash_.containsKey(value)){
			HeapNode node = this.hash_.get(value);
			node.cnt_++;
		}else{
			this.heap_.add(value);
			this.hash_.put(value, new HeapNode(this.heap_.size() - 1, 1));
			rise(this.heap_.size() - 1);
		}
		++this.size_;
	}
	
	public int poll(){
		int value = this.heap_.get(0);
		HeapNode node = this.hash_.get(value);
		if(node.cnt_ == 1){
			swap(0, this.heap_.size() - 1);
			this.heap_.remove(this.heap_.size() - 1);
			this.hash_.remove(value);
			sink(0);
		}else{
			node.cnt_--;
		}
		--this.size_;
		return value;
	}
	
	public int peek(){
		int value = this.heap_.get(0);
		return value;
	}
	
	public void delete(int value) {
		HeapNode node = this.hash_.get(value);
		if(node.cnt_ == 1){
			int idx = node.pos_;
			swap(idx, this.heap_.size() - 1);
			this.hash_.remove(value);
			this.heap_.remove(this.heap_.size() - 1);
			if(idx == heap_.size() - 1){
				rise(idx);
				sink(idx);
			}
		}else{
			node.cnt_--;
		}
		--this.size_;
	}
	
	public int getSize(){
		return this.size_;
	}
	
	public void sink(int idx){
		while (true) {
			int left_idx = getLeftChild(idx);
			int right_idx = getRightChild(idx);
			int son_idx = idx;
			if (left_idx < this.heap_.size() && isPrior(left_idx, idx)) {
				son_idx = left_idx;
			}
			if (right_idx < this.heap_.size() && isPrior(right_idx, idx)) {
				son_idx = right_idx;
			}
			if (son_idx == idx) {
				break;
			}else{
				swap(son_idx, idx);
			}
		}
	}
	
	public void rise(int idx){
		while (getParent(idx) != idx) {
			int parent_idx = getParent(idx);
			if(isPrior(idx, parent_idx)){
				swap(idx, parent_idx);
				idx = parent_idx;
			}else{
				break;
			}
		}
	}
	
	//==============================helper functions==============================//
	public int getLeftChild(int i){
		return i * 2 + 1;
	}
	
	public int getRightChild(int i){
		return i * 2 + 2;
	}
	
	public int getParent(int i) {
		return (i - 1)/2;
	}
	
	public void swap(int i, int j) {
		int val_i = heap_.get(i);
		int val_j = heap_.get(j);
		int cnt_i = hash_.get(val_i).cnt_;
		int cnt_j = hash_.get(val_j).cnt_;
		
		heap_.set(i, val_j);
		heap_.set(j, val_i);
		hash_.put(val_i, new HeapNode(j, cnt_i));
		hash_.put(val_j, new HeapNode(i, cnt_j));
	}
	
	public boolean isPrior(int left, int right){
		if(this.is_max_){
			return heap_.get(left) >= heap_.get(right);
		}else{
			return heap_.get(left) <= heap_.get(right);
		}
	}
	
	public static void main(String[] args) {
		HashHeap hh = new HashHeap(true);
		hh.push(3);
		hh.push(4);
		hh.push(3);
		hh.push(4);
		hh.push(3);
		hh.push(4);
		
		hh.delete(4);
		hh.delete(3);
		hh.delete(4);
		hh.delete(4);
		hh.delete(3);
		hh.delete(3);
		while (hh.getSize() != 0) {
			System.out.println(hh.poll());	
		}
	}
}
