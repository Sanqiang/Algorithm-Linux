//
//  Q45-CheckBinarySearchTree.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q45_CheckBinarySearchTree__
#define __Algorithm_Linux__Q45_CheckBinarySearchTree__

#include <iostream>
#include "Entity.h"
bool CheckBinarySearch(BinaryTreeNode<int> *root, int min, int max);
bool CheckBinarySearchMidOrder(BinaryTreeNode<int> *root, int &LastVal);
#endif /* defined(__Algorithm_Linux__Q45_CheckBinarySearchTree__) */
