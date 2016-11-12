//
//  Q47-FindCommonAncester.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q47_FindCommonAncester__
#define __Algorithm_Linux__Q47_FindCommonAncester__

#include <iostream>
#include "Entity.h"

class CommonAncesterWrapper {
public:
    BinaryTreeNode<int> *node = NULL;
    bool find = false;
};
CommonAncesterWrapper * findCommonAncesterHelper(BinaryTreeNode<int> * root, BinaryTreeNode<int> * p, BinaryTreeNode<int> *q);
BinaryTreeNode<int> * findCommonAncester(BinaryTreeNode<int> * root, BinaryTreeNode<int> * p, BinaryTreeNode<int> *q);
#endif /* defined(__Algorithm_Linux__Q47_FindCommonAncester__) */
