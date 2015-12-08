from Queue import Queue
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def minDepth2(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        elif root.left is None and root.right is None:
            return 1
        else:
            ll = root.left is not None
            rr = root.right is not None

            if ll and rr:
                return 1+min(self.minDepth(root.left), self.minDepth(root.right))
            elif rr:
                return 1+self.minDepth(root.right)
            elif ll:
                return 1+self.minDepth(root.left)


    def minDepth3(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return  0

        q_odd = list()
        q_even = list()
        q_odd.append(root)
        level = 1
        while True:
            if level % 2 == 1: #for odd
                del q_even[:]
                for node in q_odd:
                    ll = node.left is None
                    rr = node.right is None
                    if ll and rr:
                        return level
                    else:
                        if not ll:
                            q_even.append(node.left)
                        if not rr:
                            q_even.append(node.right)
            else: #for even
                del q_odd[:]
                for node in q_even:
                    ll = node.left is None
                    rr = node.right is None
                    if ll and rr:
                        return level
                    else:
                        if not ll:
                            q_odd.append(node.left)
                        if not rr:
                            q_odd.append(node.right)
            level += 1

    def minDepth(self, root):
        if root is None:
            return 0
        q = Queue()
        q.put(root)
        next_num = 0
        cur_num = 1
        level = 0
        while not q.empty():
            node = q.get()
            cur_num -= 1
            ll = node.left is None
            rr = node.right is None
            if ll and rr:
                return level
            if not ll:
                q.put(node.left)
                next_num += 1
            if not rr:
                q.put(node.right)
                next_num += 1
            if cur_num == 0:
                cur_num = next_num
                next_num = 0
                level += 1

