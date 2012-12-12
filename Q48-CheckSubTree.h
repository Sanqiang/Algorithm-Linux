//
//  Q48-CheckSubTree.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q48_CheckSubTree__
#define __Algorithm_Linux__Q48_CheckSubTree__

#include <iostream>
#include "Entity.h"
bool isSubTree(BinaryTreeNode<int> *large, BinaryTreeNode<int> *small);
bool findRoot(BinaryTreeNode<int> *large, BinaryTreeNode<int> *small);
bool matchTree(BinaryTreeNode<int> *large, BinaryTreeNode<int> *small);

#include "Q18-VerifyRotation.h"
#include <stdlib.h>
#define length_tree_text 20
bool isSubTree2(BinaryTreeNode<int> *large, BinaryTreeNode<int> *small);
void generateTextForTree(BinaryTreeNode<int> *tree, char *&text);
void printCharArray(char * arr);
#endif /* defined(__Algorithm_Linux__Q48_CheckSubTree__) */
