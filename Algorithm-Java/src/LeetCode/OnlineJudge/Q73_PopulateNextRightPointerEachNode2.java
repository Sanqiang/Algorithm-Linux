/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package LeetCode.OnlineJudge;

public class Q73_PopulateNextRightPointerEachNode2 {

    private void connect(TreeLinkNode node) {
        if (node == null) {
            return;
        }
        TreeLinkNode t = node, b = null, next = null;

        while (t != null) {
            if (t.left != null) {
                if (b == null) {
                    b = t.left;
                } else {
                    b.next = t.left;
                    b = b.next;
                }
                if (next == null) {
                    next = node.left;
                }
            }
            if (t.right != null) {
                if (b == null) {
                    b = t.right;
                } else {
                    b.next = t.right;
                    b = b.next;
                }
                if (next == null) {
                    next = t.right;
                }
            }
            t = t.next;
        }
        connect(next);
    }

    public class TreeLinkNode {

        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Q73_PopulateNextRightPointerEachNode2 q73 = new Q73_PopulateNextRightPointerEachNode2();
        TreeLinkNode tln1 = q73.new TreeLinkNode(1);
        TreeLinkNode tln2 = q73.new TreeLinkNode(2);
        TreeLinkNode tln3 = q73.new TreeLinkNode(3);
        TreeLinkNode tln4 = q73.new TreeLinkNode(4);
        TreeLinkNode tln5 = q73.new TreeLinkNode(5);
        TreeLinkNode tln6 = q73.new TreeLinkNode(6);
        TreeLinkNode tln7 = q73.new TreeLinkNode(7);
        TreeLinkNode tln8 = q73.new TreeLinkNode(8);
        tln1.left = tln2;
        tln1.right = tln3;
        tln2.left = tln4;
        tln2.right = tln5;
        tln3.right = tln6;
        tln4.left = tln7;
        tln4.right = tln8;
        q73.connectMy(tln1);
        System.out.println();
    }

    private void connectMy(TreeLinkNode node) {
        TreeLinkNode horizontal = node, vertical = node, last = null;
        while (vertical != null) {
            horizontal = vertical;
            TreeLinkNode next = null;
            last = null;
            while (horizontal != null) {
                if (horizontal.left != null) {
                    if (last == null) {
                        last = horizontal.left;
                    } else {
                        last.next = horizontal.left;
                        last = horizontal.left;
                    }
                    if (next == null) {
                        next = horizontal.left;
                    }
                }
                if (horizontal.right != null) {
                    if (last == null) {
                        last = horizontal.right;
                    } else {
                        last.next = horizontal.right;
                        last = horizontal.right;
                    }
                    if (next == null) {
                        next = last.right;
                    }
                }
                horizontal = horizontal.next;
            }
            vertical = next;
        }
    }
}
