from util.tree import tree_arr

class heapq:
    def __init__(self, arr):
        self.tree = tree_arr(arr)

    def push(self, element):
        self.tree.append(element)
        loop_idx = self.tree.size()-1
        while loop_idx > 0:
            change_idx = loop_idx
            if self.tree.parent(change_idx) is not None and self.tree.arr[self.tree.parent(loop_idx)] < self.tree.arr[loop_idx]:
                change_idx = self.tree.parent(loop_idx)
            if change_idx != loop_idx:
                self.tree.swap(change_idx, loop_idx)
                loop_idx = self.tree.parent(loop_idx)
            else:
                break

    def pop(self):

        loop_idx = 0
        while True:
            min_idx = -1
            if self.tree.left_child(loop_idx) is not None and self.tree.right_child(loop_idx) is not None:
                if self.tree.arr[self.tree.left_child(loop_idx)] > self.tree.arr[self.tree.right_child(loop_idx)]:
                    min_idx = self.tree.left_child(loop_idx)
                else:
                    min_idx = self.tree.right_child(loop_idx)
            elif self.tree.left_child(loop_idx) is not None:
                min_idx = self.tree.left_child(loop_idx)
            elif self.tree.right_child(loop_idx) is not None:
                min_idx = self.tree.right_child(loop_idx)
            else:
                break
            self.tree.swap(loop_idx, min_idx)
            loop_idx = min_idx
        self.tree.swap(loop_idx, self.tree.size()-1)
        temp = self.tree.remove(self.tree.size()-1)
        return temp

q = heapq([])
q.push(3)
q.push(4)
q.push(1)
q.push(2)
q.push(9)
q.push(91)

x = q.pop()
print(x)
x = q.pop()
print(x)
x = q.pop()
print(x)
x = q.pop()
print(x)