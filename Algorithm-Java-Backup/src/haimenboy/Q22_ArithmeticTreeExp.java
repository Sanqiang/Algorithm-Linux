/**
 * Sanqiang Zhao Www.131X.Com Jan 26, 2013
 */
package haimenboy;

import Util.BinaryTreeNode;
import java.util.Stack;

public class Q22_ArithmeticTreeExp {

    Stack<Character> stack = new Stack<>();

    void compute(BinaryTreeNode<Character> head) {
        if (head == null) {
            return;
        }
        compute(head.Left);
        compute(head.Right);
        int r, l;
        switch (head.Data) {
            case '+':
                r = stack.pop() - '0';
                l = stack.pop() - '0';
                stack.push((char) ((l + r) + '0'));
                break;
            case '-':
                r = stack.pop() - '0';
                l = stack.pop() - '0';
                stack.push((char) ((l - r) + '0'));
                break;
            case '*':
                r = stack.pop() - '0';
                l = stack.pop() - '0';
                stack.push((char) ((l * r) + '0'));
                break;
            case '/':
                r = stack.pop() - '0';
                l = stack.pop() - '0';
                stack.push((char) ((l / r) + '0'));
                break;
            default:
                stack.push(head.Data);
                break;
        }
    }

    public static void main(String[] args) {
        Q22_ArithmeticTreeExp q22 = new Q22_ArithmeticTreeExp();
        q22.compute(BinaryTreeNode.getCharSampleTree());
        char c = q22.stack.pop();
        System.out.println(c - '0');
    }
}
