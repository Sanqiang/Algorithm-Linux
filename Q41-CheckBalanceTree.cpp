//
//  Q41-CheckBalanceTree.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q41-CheckBalanceTree.h"
/*
 BinaryTreeNode<int> *btn3 = new BinaryTreeNode<int>(3);
 BinaryTreeNode<int> *btn7 = new BinaryTreeNode<int>(7);
 BinaryTreeNode<int> *btn12 = new BinaryTreeNode<int>(12);
 BinaryTreeNode<int> *btn17= new BinaryTreeNode<int>(17);
 BinaryTreeNode<int> *btn5 = new BinaryTreeNode<int>(5, btn3, btn7);
 BinaryTreeNode<int> *btn15 = new BinaryTreeNode<int>(15, btn12, btn17);
 BinaryTreeNode<int> *btn10 = new BinaryTreeNode<int>(10, btn5, btn15);
 
 cout<<validateBalancedTree(btn10);
 
 BinaryTreeNode<int> *btn2 = new BinaryTreeNode<int>(2);
 btn3->LeftChild = btn2;
 BinaryTreeNode<int> *btn1 = new BinaryTreeNode<int>(1);
 btn2->LeftChild = btn1;
 cout<<validateBalancedTree(btn10);
*/
bool validateBalancedTree(BinaryTreeNode<int> *tree)
{
    int d = getDistance(tree);
    if (d > 1) {
        return false;
    }else{
        return true;
    }
}

int getDistance(BinaryTreeNode<int> *tree)
{
    if (!tree) {
        return -1;
    }
    int l = getDistance(tree->LeftChild);
    if (l > 1) {
        return l;
    }
    int r = getDistance(tree->RightChild);
    if (r > 1) {
        return r;
    }
    return abs(l-r);
}