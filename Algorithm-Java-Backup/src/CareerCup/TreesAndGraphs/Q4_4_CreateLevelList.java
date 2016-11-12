/**
 * Sanqiang Zhao Www.131X.Com Jan 4, 2013
 */
package CareerCup.TreesAndGraphs;

import Util.BinaryTreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q4_4_CreateLevelList {

    public ArrayList<LinkedList<BinaryTreeNode<Integer>>> getLevelList2(BinaryTreeNode<Integer> root) {
        ArrayList<LinkedList<BinaryTreeNode<Integer>>> solution = new ArrayList<>();
        getLevelList2Helper(solution, 0, root);
        return solution;
    }

    private void getLevelList2Helper(ArrayList<LinkedList<BinaryTreeNode<Integer>>> solution, int level, BinaryTreeNode<Integer> root) {
        LinkedList<BinaryTreeNode<Integer>> list = null;
        if (level >= solution.size()) {
            list = new LinkedList<>();
            solution.add(list);
        } else {
            list = solution.get(level);
        }
        list.add(root);
        if (root.Left != null) {
            getLevelList2Helper(solution, 1 + level, root.Left);
        }
        if (root.Right != null) {
            getLevelList2Helper(solution, 1 + level, root.Right);
        }
    }

    public ArrayList<LinkedList<BinaryTreeNode<Integer>>> getLevelList(BinaryTreeNode<Integer> root) {
        ArrayList<LinkedList<BinaryTreeNode<Integer>>> solution = new ArrayList<>();
        LinkedList<BinaryTreeNode<Integer>> list = new LinkedList<>();
        if (root != null) {
            list.add(root);
            solution.add(list);
        }
        while (!list.isEmpty()) {
            LinkedList<BinaryTreeNode<Integer>> next_list = new LinkedList<>();
            for (int i = 0; i < list.size(); i++) {
                BinaryTreeNode<Integer> cur = list.get(i);
                if (cur.Left != null) {
                    next_list.add(cur.Left);
                }
                if (cur.Right != null) {
                    next_list.add(cur.Right);
                }
            }
            list = next_list;
            solution.add(list);
        }
        return solution;
    }

    public static void main(String[] args) {
        Q4_4_CreateLevelList q44 = new Q4_4_CreateLevelList();
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        ArrayList<LinkedList<BinaryTreeNode<Integer>>> solution = q44.getLevelList2(root);
        print(solution);
    }

    private static void print(ArrayList<LinkedList<BinaryTreeNode<Integer>>> solution) {
        for (LinkedList<BinaryTreeNode<Integer>> list : solution) {
            for (BinaryTreeNode<Integer> binaryTreeNode : list) {
                System.out.print(binaryTreeNode.Data + " ");
            }
            System.out.println();;
        }

    }
}
