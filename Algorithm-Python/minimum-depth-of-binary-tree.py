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


    def minDepth(self, root):
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
                    if node.left is None and node.right is None:
                        return level
                    else:
                        if node.left is not None:
                            q_even.append(node.left)
                        if node.right is not None:
                            q_even.append(node.right)
            else: #for even
                for node in q_even:
                    del q_odd[:]
                    if node.left is None and node.right is None:
                        return level
                    else:
                        if node.left is not None:
                            q_odd.append(node.left)
                        if node.right is not None:
                            q_odd.append(node.right)
            level += 1



        