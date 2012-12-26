/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package Util;

public class BinaryTreeNode<T> {

    public T Data;
    public BinaryTreeNode<T> Left;
    public BinaryTreeNode<T> Right;
    public BinaryTreeNode<T> Parent; //Optional

    public BinaryTreeNode(T _data) {
        this.Data = _data;
        this.Left = null;
        this.Right = null;
    }

    public BinaryTreeNode(T _data, BinaryTreeNode<T> _left, BinaryTreeNode<T> _right) {
        this.Data = _data;
        this.Left = _left;
        this.Right = _right;
        _left = this;
        _right = this;
    }

    public BinaryTreeNode(T _data, BinaryTreeNode<T> _left, BinaryTreeNode<T> _right, BinaryTreeNode<T> _parent) {
        this.Data = _data;
        this.Left = _left;
        this.Right = _right;
        _left = this;
        _right = this;
        this.Parent = _parent;
    }

    public static BinaryTreeNode<Integer> getSampleTree() {
        BinaryTreeNode<Integer> btn2 = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> btn7 = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> btn5 = new BinaryTreeNode<Integer>(5, btn2, btn7);
        BinaryTreeNode<Integer> btn12 = new BinaryTreeNode<Integer>(12);
        BinaryTreeNode<Integer> btn17 = new BinaryTreeNode<Integer>(17);
        BinaryTreeNode<Integer> btn15 = new BinaryTreeNode<Integer>(15, btn12, btn17);
        BinaryTreeNode<Integer> btn10 = new BinaryTreeNode<Integer>(10, btn5, btn15);
        return btn10;
    }

    public static BinaryTreeNode<Integer> getSampleTree2() {
        BinaryTreeNode<Integer> btn2 = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> btn7 = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> btn5 = new BinaryTreeNode<Integer>(2, btn2, btn7);
        BinaryTreeNode<Integer> btn12 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> btn17 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> btn15 = new BinaryTreeNode<Integer>(2, btn12, btn17);
        BinaryTreeNode<Integer> btn10 = new BinaryTreeNode<Integer>(1, btn5, btn15);
        return btn10;
    }

    private static void ReverseOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        ReverseOrder(root.Right);
        System.out.println(root.Data);
        ReverseOrder(root.Left);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> sample = getSampleTree();
        ReverseOrder(sample);
    }
}
