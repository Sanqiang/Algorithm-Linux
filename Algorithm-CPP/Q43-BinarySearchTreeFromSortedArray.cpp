//
//  Q43-BinarySearchTreeFromSortedArray.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q43-BinarySearchTreeFromSortedArray.h"
/*
 int arr[] = {3,5,7,10,12,15,17};
 BinaryTreeNode<int> *root = buildBinarySearchTreeFromSortedArray(arr, 7);
*/
BinaryTreeNode<int> * buildBinarySearchTreeFromSortedArray(int arr[], int length)
{
    //int length = sizeof(arr) / sizeof(int);
    return buildBinarySearchTreeFromSortedArray(arr, 0, length-1);
}

BinaryTreeNode<int> * buildBinarySearchTreeFromSortedArray(int arr[], int s, int e)
{
    if (s > e) {
        return NULL;
    }
    int m = (s + e) / 2;
    BinaryTreeNode<int> *node = new BinaryTreeNode<int>(arr[m]);
    node->LeftChild = buildBinarySearchTreeFromSortedArray(arr, s, m-1);
    node->RightChild = buildBinarySearchTreeFromSortedArray(arr, m+1, e);
    return node;
}