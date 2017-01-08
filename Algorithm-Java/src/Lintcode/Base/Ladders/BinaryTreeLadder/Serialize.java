package Lintcode.Base.Ladders.BinaryTreeLadder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize {
	/**
	 * This method will be invoked first, you should design your own algorithm
	 * to serialize a binary tree which denote by a root node to a string which
	 * can be easily deserialized by your own "deserialize" method later.
	 */
	public String serialize(TreeNode root) {
		ArrayList<TreeNode> temp_list = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			temp_list.add(temp);
			if (temp != null) {
				if (temp.left != null) {
					q.add(temp.left);
				} else {
					q.add(null);
				}
				if (temp.right != null) {
					q.add(temp.right);
				} else {
					q.add(null);
				}
			}
		}
		for (int i = temp_list.size() - 1; i >= 0; --i) {
			if (temp_list.get(i) == null) {
				temp_list.remove(temp_list.size() - 1);
			} else {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < temp_list.size(); ++i) {
			if (temp_list.get(i) == null) {
				sb.append("#");
			} else {
				sb.append(temp_list.get(i).val);
			}
			if (i < temp_list.size() - 1) {
				sb.append(",");
			}
		}
		sb.append("}");
		return sb.toString();
	}

	/**
	 * This method will be invoked second, the argument data is what exactly you
	 * serialized at method "serialize", that means the data is not given by
	 * system, it's given by your own serialize method. So the format of data is
	 * designed by yourself, and deserialize it here as you serialize it in
	 * "serialize" method.
	 */
	public TreeNode deserialize(String data) {
		if (data.equals("{}")) {
			return null;
		}
		String[] nodes = data.substring(1, data.length() - 1).split(",");
		if (nodes.length == 0) {
			return null;
		} else {
			Queue<TreeNode> q = new LinkedList<>();
			boolean is_left = true;
			TreeNode head = new TreeNode(Integer.parseInt(nodes[0]));
			q.add(head);
			for (int i = 1; i < nodes.length; ++i) {
				String node = nodes[i];
				TreeNode temp = null;
				if (!node.equals("#")) {
					temp = new TreeNode(Integer.parseInt(node));
				}
				if (!q.isEmpty()) {
					TreeNode parent = q.peek();
					if (is_left) {
						parent.left = temp;
					} else {
						parent.right = temp;
						q.poll();
					}
					is_left = !is_left;
				}
				if (temp != null) {
					q.add(temp);
				}
			}
			return head;
		}
	}
}
