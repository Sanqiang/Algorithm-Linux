//
//  Q47-FindCommonAncester.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q47-FindCommonAncester.h"
/*
 BinaryTreeNode<int> *btn3 = new BinaryTreeNode<int>(3);
 BinaryTreeNode<int> *btn7 = new BinaryTreeNode<int>(7);
 BinaryTreeNode<int> *btn12 = new BinaryTreeNode<int>(12);
 BinaryTreeNode<int> *btn17= new BinaryTreeNode<int>(17);
 BinaryTreeNode<int> *btn5 = new BinaryTreeNode<int>(5, btn3, btn7);
 BinaryTreeNode<int> *btn15 = new BinaryTreeNode<int>(15, btn12, btn17);
 BinaryTreeNode<int> *btn10 = new BinaryTreeNode<int>(10, btn5, btn15);
 
 cout<<findCommonAncester(btn10, btn3, btn5)->Data;
*/
BinaryTreeNode<int> * findCommonAncester(BinaryTreeNode<int> * root, BinaryTreeNode<int> * p, BinaryTreeNode<int> *q)
{
    CommonAncesterWrapper *result = findCommonAncesterHelper(root, p, q);
    if (result->find) {
        return result->node;
    }
    return NULL;
}

CommonAncesterWrapper * findCommonAncesterHelper(BinaryTreeNode<int> * root, BinaryTreeNode<int> * p, BinaryTreeNode<int> *q)
{
    if (!root) {
        CommonAncesterWrapper *w = new CommonAncesterWrapper();
        return w;
    }
    
    CommonAncesterWrapper *l = findCommonAncesterHelper(root->LeftChild, p, q);
    if (l->find) {
        return l;
    }
    CommonAncesterWrapper *r = findCommonAncesterHelper(root->RightChild, p, q);
    if (r->find) {
        return r;
    }
    CommonAncesterWrapper *w = new CommonAncesterWrapper();
    if (l->node && r->node) {
        w->node = root;
        w->find = true;
        return w;
    }else if(root == p || root == q)
    {
        w->node = root;
        w->find = l->node || r->node;
        return w;
    }else
    {
        w->node = l->node?l->node:r->node;
        return w;
    }
}



