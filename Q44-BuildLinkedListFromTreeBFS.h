//
//  Q44-BuildLinkedListFromTreeBFS.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q44_BuildLinkedListFromTreeBFS__
#define __Algorithm_Linux__Q44_BuildLinkedListFromTreeBFS__

#include <iostream>
#include <vector>
using namespace std;
#include "Entity.h"
vector<DoublyLinkedList<BinaryTreeNode<int>*>*> buildLinkedListFromTreeBFS(BinaryTreeNode<int> *root);
vector<DoublyLinkedList<BinaryTreeNode<int>*>*> buildLinkedListFromTreeDFS(BinaryTreeNode<int> *root, int n, vector<DoublyLinkedList<BinaryTreeNode<int>*>*> &lists);
#endif /* defined(__Algorithm_Linux__Q44_BuildLinkedListFromTreeBFS__) */
