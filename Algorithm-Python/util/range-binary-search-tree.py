from util.tree import tree_arr


def rangeBinarySearchTreeDFS(root, idx, s, e, solutions = []):
    val = root.get_value(idx)
    if val >= s and val <= e:
        solutions.append(val)
    if val >= s and root.contain_left_child(idx):
        rangeBinarySearchTreeDFS(root, root.left_child(idx), s, e, solutions)
    if val <= e and root.contain_right_child(idx):
        rangeBinarySearchTreeDFS(root, root.right_child(idx), s, e, solutions)
    return

if __name__ == '__main__':
    root = tree_arr([5,3,9,1,4,6,10])
    solutions = []
    rangeBinarySearchTreeDFS(root, 0, 3, 6, solutions)
    for i in solutions:
        print(i)
        print("\t")

