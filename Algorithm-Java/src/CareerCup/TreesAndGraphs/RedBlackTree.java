package CareerCup.TreesAndGraphs;

import java.util.*;

public class RedBlackTree<T extends Comparable>
{
	//������������ɫ
	private static final boolean RED   = false;
	private static final boolean BLACK = true;
	static class Node
	{
		Object data;
		Node parent; 
		Node left;
		Node right;
		//�ڵ��Ĭ����ɫ�Ǻ�ɫ
		boolean color = BLACK;
		public Node(Object data , Node parent 
			, Node left , Node right)
		{
			this.data = data;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		public String toString()
		{
			return "[data=" + data
				+ ", color=" + color + "]"; 
		}
		public boolean equals(Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			if (obj.getClass() == Node.class)
			{
				Node target = (Node)obj;
				return data.equals(target.data)
					&& color == target.color
					&& left == target.left
					&& right == target.right
					&& parent == target.parent;
			}
			return false;
		}
	}
	private Node root;
	//�������������ڴ������������
	public RedBlackTree()
	{
		root = null;
	}
	public RedBlackTree(T o)
	{
		root = new Node(o , null , null , null);
	}
	//��ӽڵ�
	public void add(T ele)
	{
		//����ڵ�Ϊnull
		if (root == null)
		{
			root = new Node(ele , null , null , null);
		}
		else
		{
			Node current = root;
			Node parent = null;
			int cmp = 0;
			//�������ʵ�Ҷ�ӽڵ㣬�Ը�Ҷ�ӽڵ�Ϊ���ڵ�����½ڵ�
			do
			{
				parent = current;
				cmp = ele.compareTo(current.data);
				//����½ڵ��ֵ���ڵ�ǰ�ڵ��ֵ
				if (cmp > 0)
				{
					//�����ӽڵ���Ϊ��ǰ�ڵ�
					current = current.right;
				}
				//����½ڵ��ֵС�ڵ�ǰ�ڵ��ֵ
				else
				{
					//�����ӽڵ���Ϊ��ǰ�ڵ�
					current = current.left;
				}
			}
			while (current != null);
			//�����½ڵ�
			Node newNode = new Node(ele , parent , null , null);
			//����½ڵ��ֵ���ڸ��ڵ��ֵ
			if (cmp > 0)
			{
				//�½ڵ���Ϊ���ڵ�����ӽڵ�
				parent.right = newNode;
			}
			//����½ڵ��ֵС�ڸ��ڵ��ֵ
			else
			{
				//�½ڵ���Ϊ���ڵ�����ӽڵ�
				parent.left = newNode;
			}
			//ά�������
			fixAfterInsertion(newNode);
		}
	}
	//ɾ��ڵ�
	public void remove(T ele)
	{
		//��ȡҪɾ��Ľڵ�
		Node target = getNode(ele);
		//���ɾ��ڵ��������������������Ϊ��
		if (target.left != null && target.right != null) 
		{
			//�ҵ�target�ڵ���������ǰһ���ڵ�
			//s���ڱ���target�ڵ����������ֵ���Ľڵ�
			Node s = target.left;
			//����target�ڵ����������ֵ���Ľڵ�
			while (s.right != null)
			{
				s = s.right;
			}
			//��s�ڵ�������p�ڵ�
			target.data = s.data;
			target = s;
		} 
		//��ʼ�޸�����滻�ڵ㣬�����滻�ڵ㲻Ϊnull
		Node replacement = (target.left != null ? target.left : target.right);
		if (replacement != null) 
		{
			// ��replacement��parentָ��target��parent
			replacement.parent = target.parent;
			//���target��parentΪnull������target�����Ǹ�ڵ�
			if (target.parent == null)
			{
				root = replacement;
			}
			//���target���丸�ڵ�����ӽڵ�
			else if (target == target.parent.left)
			{
				//��target�ĸ��ڵ�leftָ��replacement
				target.parent.left  = replacement;
			}
			//���target���丸�ڵ�����ӽڵ�
			else
			{
				//��target�ĸ��ڵ�rightָ��replacement
				target.parent.right = replacement;
			}
			//����ɾ��target�ڵ�
			target.left = target.right = target.parent = null;

			// �޸������
			if (target.color == BLACK)
			{
				fixAfterDeletion(replacement);
			}
		}
		//target�����Ǹ�ڵ�
		else if (target.parent == null) 
		{
			root = null;
		} 
		else 
		{
			//targetû���ӽڵ㣬���������滻�ڵ㡣
			//�޸������
			if (target.color == BLACK)
			{
				fixAfterDeletion(target);
			}
			if (target.parent != null) 
			{
				//���target���丸�ڵ�����ӽڵ�
				if (target == target.parent.left)
				{
					//��target�ĸ��ڵ�left��Ϊnull
					target.parent.left = null;
				}
				//���target���丸�ڵ�����ӽڵ�
				else if (target == target.parent.right)
				{
					//��target�ĸ��ڵ�right��Ϊnull
					target.parent.right = null;
				}
				//��target��parent����null
				target.parent = null;
			}
		}
	}
	//��ݸ��ֵ�����ڵ�
	public Node getNode(T ele)
	{
		//�Ӹ�ڵ㿪ʼ����
		Node p = root;
		while (p != null) 
		{
			int cmp = ele.compareTo(p.data);
			//���������ֵС�ڵ�ǰp�ڵ��ֵ
			if (cmp < 0)
			{
				//������������
				p = p.left;
			}
			//���������ֵ���ڵ�ǰp�ڵ��ֵ
			else if (cmp > 0)
			{
				//������������
				p = p.right;
			}
			else
			{
				return p;
			}
		}
		return null;
	}
	//������ȱ���
	public List<Node> breadthFirst()
	{
		Queue<Node> queue = new ArrayDeque<Node>();
		List<Node> list = new ArrayList<Node>();
		if( root != null)
		{
			//����Ԫ���롰���С�
			queue.offer(root);
		}
		while(!queue.isEmpty())
		{
			//���ö��еġ���β����Ԫ����ӵ�List��
			list.add(queue.peek());
			Node p = queue.poll();
			//������ӽڵ㲻Ϊnull�������롰���С�
			if(p.left != null)
			{
				queue.offer(p.left);
			}
			//������ӽڵ㲻Ϊnull�������롰���С�
			if(p.right != null)
			{
				queue.offer(p.right);
			}
		}
		return list;
	}
	//����ڵ���޸������
	private void fixAfterInsertion(Node x) 
	{
		x.color = RED;
		//ֱ��x�ڵ�ĸ��ڵ㲻�Ǹ���x�ĸ��ڵ㲻�Ǻ�ɫ
		while (x != null && x != root 
			&& x.parent.color == RED) 
		{
			//���x�ĸ��ڵ����丸�ڵ�����ӽڵ�
			if (parentOf(x) == leftOf(parentOf(parentOf(x)))) 
			{
				//��ȡx�ĸ��ڵ���ֵܽڵ�
				Node y = rightOf(parentOf(parentOf(x)));
				//���x�ĸ��ڵ���ֵܽڵ��Ǻ�ɫ
				if (colorOf(y) == RED) 
				{
					//��x�ĸ��ڵ���Ϊ��ɫ
					setColor(parentOf(x), BLACK);
					//��x�ĸ��ڵ���ֵܽڵ���Ϊ��ɫ
					setColor(y, BLACK);
					//��x�ĸ��ڵ�ĸ��ڵ���Ϊ��ɫ
					setColor(parentOf(parentOf(x)), RED);
					x = parentOf(parentOf(x));
				}
				//���x�ĸ��ڵ���ֵܽڵ��Ǻ�ɫ
				else
				{
					//���x���丸�ڵ�����ӽڵ�
					if (x == rightOf(parentOf(x))) 
					{
						//��x�ĸ��ڵ���Ϊx
						x = parentOf(x);
						rotateLeft(x);
					}
					//��x�ĸ��ڵ���Ϊ��ɫ
					setColor(parentOf(x), BLACK);
					//��x�ĸ��ڵ�ĸ��ڵ���Ϊ��ɫ
					setColor(parentOf(parentOf(x)), RED);
					rotateRight(parentOf(parentOf(x)));
				}
			} 
			//���x�ĸ��ڵ����丸�ڵ�����ӽڵ�
			else 
			{
				//��ȡx�ĸ��ڵ���ֵܽڵ�
				Node y = leftOf(parentOf(parentOf(x)));
				//���x�ĸ��ڵ���ֵܽڵ��Ǻ�ɫ
				if (colorOf(y) == RED) 
				{
					//��x�ĸ��ڵ���Ϊ��ɫ��
					setColor(parentOf(x), BLACK);
					//��x�ĸ��ڵ���ֵܽڵ���Ϊ��ɫ
					setColor(y, BLACK);
					//��x�ĸ��ڵ�ĸ��ڵ���Ϊ��ɫ
					setColor(parentOf(parentOf(x)), RED);
					//��x��Ϊx�ĸ��ڵ�Ľڵ�
					x = parentOf(parentOf(x));
				}
				//���x�ĸ��ڵ���ֵܽڵ��Ǻ�ɫ
				else 
				{
					//���x���丸�ڵ�����ӽڵ�
					if (x == leftOf(parentOf(x))) 
					{
						//��x�ĸ��ڵ���Ϊx
						x = parentOf(x);
						rotateRight(x);
					}
					//��x�ĸ��ڵ���Ϊ��ɫ
					setColor(parentOf(x), BLACK);
					//��x�ĸ��ڵ�ĸ��ڵ���Ϊ��ɫ
					setColor(parentOf(parentOf(x)), RED);
					rotateLeft(parentOf(parentOf(x)));
				}
			}
		}
		//����ڵ���Ϊ��ɫ
		root.color = BLACK;
	}
	//ɾ��ڵ���޸������
	private void fixAfterDeletion(Node x) 
	{
		//ֱ��x���Ǹ�ڵ㣬��x����ɫ�Ǻ�ɫ
		while (x != root && colorOf(x) == BLACK) 
		{
			//���x���丸�ڵ�����ӽڵ�
			if (x == leftOf(parentOf(x)))
			{
				//��ȡx�ڵ���ֵܽڵ�
				Node sib = rightOf(parentOf(x));
				//���sib�ڵ��Ǻ�ɫ
				if (colorOf(sib) == RED)
				{
					//��sib�ڵ���Ϊ��ɫ
					setColor(sib, BLACK);
					//��x�ĸ��ڵ���Ϊ��ɫ
					setColor(parentOf(x), RED);
					rotateLeft(parentOf(x));
					//�ٴν�sib��Ϊx�ĸ��ڵ�����ӽڵ�
					sib = rightOf(parentOf(x));
				}
				//���sib�������ӽڵ㶼�Ǻ�ɫ
				if (colorOf(leftOf(sib)) == BLACK
					&& colorOf(rightOf(sib)) == BLACK) 
				{
					//��sib��Ϊ��ɫ
					setColor(sib, RED);
					//��x����x�ĸ��ڵ�
					x = parentOf(x);
				} 
				else 
				{
					//���sib��ֻ�����ӽڵ��Ǻ�ɫ
					if (colorOf(rightOf(sib)) == BLACK) 
					{
						//��sib�����ӽڵ�Ҳ��Ϊ��ɫ
						setColor(leftOf(sib), BLACK);
						//��sib��Ϊ��ɫ
						setColor(sib, RED);
						rotateRight(sib);
						sib = rightOf(parentOf(x));
					}
					//����sib����ɫ��x�ĸ��ڵ����ɫ��ͬ
					setColor(sib, colorOf(parentOf(x)));
					//��x�ĸ��ڵ���Ϊ��ɫ
					setColor(parentOf(x), BLACK);
					//��sib�����ӽڵ���Ϊ��ɫ
					setColor(rightOf(sib), BLACK);
					rotateLeft(parentOf(x));
					x = root;
				}
			}
			//���x���丸�ڵ�����ӽڵ�
			else
			{
				//��ȡx�ڵ���ֵܽڵ�
				Node sib = leftOf(parentOf(x));
				//���sib����ɫ�Ǻ�ɫ
				if (colorOf(sib) == RED) 
				{
					//��sib����ɫ��Ϊ��ɫ
					setColor(sib, BLACK);
					//��sib�ĸ��ڵ���Ϊ��ɫ
					setColor(parentOf(x), RED);
					rotateRight(parentOf(x));
					sib = leftOf(parentOf(x));
				}
				//���sib�������ӽڵ㶼�Ǻ�ɫ
				if (colorOf(rightOf(sib)) == BLACK 
					&& colorOf(leftOf(sib)) == BLACK) 
				{
					//��sib��Ϊ��ɫ
					setColor(sib, RED);
					//��x����x�ĸ��ڵ�
					x = parentOf(x);
				}
				else 
				{
					//���sibֻ�����ӽڵ��Ǻ�ɫ
					if (colorOf(leftOf(sib)) == BLACK) 
					{
						//��sib�����ӽڵ�Ҳ��Ϊ��ɫ
						setColor(rightOf(sib), BLACK);
						//��sib��Ϊ��ɫ
						setColor(sib, RED);
						rotateLeft(sib);
						sib = leftOf(parentOf(x));
					}
					//��sib����ɫ��Ϊ��x�ĸ��ڵ���ɫ��ͬ
					setColor(sib, colorOf(parentOf(x)));
					//��x�ĸ��ڵ���Ϊ��ɫ
					setColor(parentOf(x), BLACK);
					//��sib�����ӽڵ���Ϊ��ɫ
					setColor(leftOf(sib), BLACK);
					rotateRight(parentOf(x));
					x = root;
				}
			}
		}
		setColor(x, BLACK);
	}
	//��ȡָ���ڵ����ɫ
	private boolean colorOf(Node p)
	{
		return (p == null ? BLACK : p.color);
	}
	//��ȡָ���ڵ�ĸ��ڵ�
	private Node parentOf(Node p) 
	{
		return (p == null ? null: p.parent);
	}
	//Ϊָ���ڵ�������ɫ
	private void setColor(Node p, boolean c)
	{
		if (p != null)
		{
			p.color = c;
		}
	}
	//��ȡָ���ڵ�����ӽڵ�
	private Node leftOf(Node p) 
	{
		return (p == null) ? null: p.left;
	}
	//��ȡָ���ڵ�����ӽڵ�
	private Node rightOf(Node p) 
	{
		return (p == null) ? null: p.right;
	}
	/**
	 * ִ������ת��
	 *  p        r
	 *     r   p   
	 *  q        q
	 */
	private void rotateLeft(Node p) 
	{
		if (p != null) 
		{
			//ȡ��p�����ӽڵ�
			Node r = p.right;
			Node q = r.left;
			//��r�����ӽڵ�����p���ҽڵ�����
			p.right = q;
			//��r�����ӽڵ��parentָ��p�ڵ�
			if (q != null)
			{
				q.parent = p;
			}
			r.parent = p.parent;
			//���p�Ѿ��Ǹ�ڵ�
			if (p.parent == null)
			{
				root = r;
			}
			//���p���丸�ڵ�����ӽڵ�
			else if (p.parent.left == p)
			{
				//��r��Ϊp�ĸ��ڵ�����ӽڵ�
				p.parent.left = r;
			}
			else
			{
				//��r��Ϊp�ĸ��ڵ�����ӽڵ�
				p.parent.right = r;
			}
			r.left = p;
			p.parent = r;
		}
	}
	/**
	 * ִ������ת��
	 *     p       l
	 *  l              p
	 *     q       q
	 */
	private void rotateRight(Node p) 
	{
		if (p != null)
		{
			//ȡ��p�����ӽڵ�
			Node l = p.left;
			Node q = l.right;
			//��l�����ӽڵ�����p����ڵ�����
			p.left = q;
			//��l�����ӽڵ��parentָ��p�ڵ�
			if (q != null) 
			{
				q.parent = p;
			}
			l.parent = p.parent;
			//���p�Ѿ��Ǹ�ڵ�
			if (p.parent == null)
			{
				root = l;
			}
			//���p���丸�ڵ�����ӽڵ�
			else if (p.parent.right == p)
			{
				//��l��Ϊp�ĸ��ڵ�����ӽڵ�
				p.parent.right = l;
			}
			else 
			{
				//��l��Ϊp�ĸ��ڵ�����ӽڵ�
				p.parent.left = l;
			}
			l.right = p;
			p.parent = l;
		}
	}
	//ʵ���������
	public List<Node> inIterator()
	{
		return inIterator(root);
	}
	private List<Node> inIterator(Node node)
	{
		List<Node> list = new ArrayList<Node>();
		//�ݹ鴦��������
		if (node.left != null)
		{
			list.addAll(inIterator(node.left));
		}
		//�����ڵ�
		list.add(node);
		//�ݹ鴦��������
		if (node.right != null)
		{
			list.addAll(inIterator(node.right));
		}
		return list;
	}
	
	public static void main(String[] args) 
	{
		RedBlackTree<Integer> tree 
			= new RedBlackTree<Integer>();
		//��ӽڵ�
		tree.add(5);
		tree.add(20);
		tree.add(10);
		tree.add(3);
		tree.add(8);
		tree.add(15);
		tree.add(30);
		System.out.println(tree.breadthFirst());
		//ɾ��ڵ�
		tree.remove(20);
		System.out.println(tree.breadthFirst());
//		System.out.println(tree.inIterator());
		
	}
}
