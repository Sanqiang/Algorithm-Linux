package Lintcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sun.glass.ui.TouchInputSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;


interface NestedInteger {

	// @return true if this NestedInteger holds a single integer,
	// rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds,
	// if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds,
	// if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

	List<NestedInteger> nestedList;
	List<Integer> index;
	
	public NestedIterator(List<NestedInteger> nestedList) {
		this.nestedList = nestedList;
		this.index =new ArrayList<Integer>();
	}

	
	// @return {int} the next element in the iteration
	@Override
	public Integer next() {
		return 0;
	}

	// @return {boolean} true if the iteration has more element or false
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public void remove() {
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext())
 * v.add(i.next());
 */