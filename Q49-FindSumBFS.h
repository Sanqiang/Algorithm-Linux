//
//  Q49-FindSumBFS.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q49_FindSumBFS__
#define __Algorithm_Linux__Q49_FindSumBFS__

#include <iostream>
#include "Entity.h"
#include <math.h>
void findSumBFS(BinaryTreeNode<int> *root, int sum);
void findSumBFS(BinaryTreeNode<int> *root, int n, int *&temp, int sum);
int getDepth(BinaryTreeNode<int> *root);
void printSumForfindSumBFS(int * arr, int s, int e);
#endif /* defined(__Algorithm_Linux__Q49_FindSumBFS__) */
