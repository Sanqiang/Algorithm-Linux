package Lintcode.Base.Ladders.BinaryTreeLadder;

import java.util.ArrayList;

public class InorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	inorderTraversal(root, result);
    	return result;
    }
    
    void inorderTraversal(TreeNode root, ArrayList<Integer> result) {
    	if(root == null){
    		return;
    	}
    	inorderTraversal(root.left, result);
    	result.add(root.val);
    	inorderTraversal(root.right, result);
    }
    
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	preorderTraversal(root, result);
    	return result;
	}
    
    void preorderTraversal(TreeNode root, ArrayList<Integer> result) {
    	if(root == null){
    		return;
    	}
    	result.add(root.val);
    	preorderTraversal(root.left, result);
    	preorderTraversal(root.right, result);
    }
    
}
