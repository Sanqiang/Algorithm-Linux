//
//  Q45-CheckBinarySearchTree.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q45-CheckBinarySearchTree.h"
/*
 BinaryTreeNode<int> *btn3 = new BinaryTreeNode<int>(3);
 BinaryTreeNode<int> *btn7 = new BinaryTreeNode<int>(7);
 BinaryTreeNode<int> *btn12 = new BinaryTreeNode<int>(12);
 BinaryTreeNode<int> *btn17= new BinaryTreeNode<int>(17);
 BinaryTreeNode<int> *btn5 = new BinaryTreeNode<int>(5, btn3, btn7);
 BinaryTreeNode<int> *btn15 = new BinaryTreeNode<int>(15, btn12, btn17);
 BinaryTreeNode<int> *btn10 = new BinaryTreeNode<int>(10, btn5, btn15);
 int Min = -9999;
 cout<<CheckBinarySearch(btn10, -99999, 99999)<<CheckBinarySearchMidOrder(btn10, Min);
*/
bool CheckBinarySearch(BinaryTreeNode<int> *root, int min, int max)
{
    if (!root) {
        return true;
    }
    if (root->Data < min || root->Data > max ) {
        return false;
    }
    return CheckBinarySearch(root->LeftChild,min,root->Data) && CheckBinarySearch(root->RightChild,root->Data,max);
}

bool CheckBinarySearchMidOrder(BinaryTreeNode<int> *root, int &LastVal)
{
    if (!root) {
        return true;
    }
    bool result = true;
    result &= CheckBinarySearchMidOrder(root->LeftChild, LastVal);
    
    if (root->Data <= LastVal) {
        result &= false;
    }else{
        LastVal = root->Data;
    }
    
    result &= CheckBinarySearchMidOrder(root->RightChild, LastVal);
    return result;
}