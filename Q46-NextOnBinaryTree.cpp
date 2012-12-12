//
//  Q46-NextOnBinaryTree.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q46-NextOnBinaryTree.h"
/*
 BinaryTreeNode<int> *btn3 = new BinaryTreeNode<int>(3);
 BinaryTreeNode<int> *btn7 = new BinaryTreeNode<int>(7);
 BinaryTreeNode<int> *btn12 = new BinaryTreeNode<int>(12);
 BinaryTreeNode<int> *btn17= new BinaryTreeNode<int>(17);
 BinaryTreeNode<int> *btn5 = new BinaryTreeNode<int>(5, btn3, btn7);
 BinaryTreeNode<int> *btn15 = new BinaryTreeNode<int>(15, btn12, btn17);
 BinaryTreeNode<int> *btn10 = new BinaryTreeNode<int>(10, btn5, btn15);
 
 cout<<getNextOnMidTravel(btn5)->Data;
*/
BinaryTreeNode<int> * getNextOnMidTravel(BinaryTreeNode<int> *node)
{
    if (node->RightChild) {
        node = node->RightChild;
        while (node->LeftChild) {
            node = node->LeftChild;
        }
        return node;
    }else{
        BinaryTreeNode<int> *runner = node;
        BinaryTreeNode<int> *parent = node->Parent;
        while (parent && parent->RightChild == runner) {
            runner = runner->Parent;
            parent = runner->Parent;
        }
        return parent;
    }
}