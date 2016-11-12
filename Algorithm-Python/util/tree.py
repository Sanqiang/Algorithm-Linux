import math

class tree_arr:
    def __init__(self, arr):
        self.arr = arr

    def get_value(self, i):
        return self.arr[i]

    def contain_left_child(self, idx):
        return 2*idx + 1 < self.size()

    def contain_right_child(self, idx):
        return 2*idx + 2 < self.size()

    def left_child(self, idx):
        if 2*idx + 1 < self.size():
            return 2*idx + 1

    def right_child(self,idx):
        if 2*idx + 2 < self.size():
            return 2*idx + 2

    def parent(self, idx):
        if idx > 0:
            return math.floor((idx-1)/2)

    def append(self, element):
        self.arr.append(element)

    def remove(self, idx):
        temp = self.arr[idx]
        self.arr.pop(idx)
        return temp

    def size(self):
        return len(self.arr)

    def swap(self, index1, index2):
        temp = self.arr[index1]
        self.arr[index1] = self.arr[index2]
        self.arr[index2] = temp