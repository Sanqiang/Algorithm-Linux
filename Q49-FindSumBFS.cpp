//
//  Q49-FindSumBFS.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 BinaryTreeNode<int> *btn3 = new BinaryTreeNode<int>(3);
 BinaryTreeNode<int> *btn7 = new BinaryTreeNode<int>(7);
 BinaryTreeNode<int> *btn12 = new BinaryTreeNode<int>(12);
 BinaryTreeNode<int> *btn17= new BinaryTreeNode<int>(17);
 BinaryTreeNode<int> *btn5 = new BinaryTreeNode<int>(5, btn3, btn7);
 BinaryTreeNode<int> *btn15 = new BinaryTreeNode<int>(15, btn12, btn17);
 BinaryTreeNode<int> *btn10 = new BinaryTreeNode<int>(10, btn5, btn15);
 
 findSumBFS(btn10, 18);
 findSumBFS(btn10, 8);
*/
#include "Q49-FindSumBFS.h"

void findSumBFS(BinaryTreeNode<int> *root, int sum)
{
    int length = getDepth(root);
    int * temp_arr = (int *)malloc(sizeof(int) * length);
    findSumBFS(root, 0, temp_arr, sum);
}

void findSumBFS(BinaryTreeNode<int> *root, int n, int *&temp, int sum)
{
    if (!root) {
        return;
    }
    *(temp+n) = root->Data;
    int i = n, sum_temp = 0;
    for (; i >= 0; --i) {
        sum_temp += temp[i];
        if (sum_temp == sum) {
            printSumForfindSumBFS(temp, i, n);
        }
    }
    
    findSumBFS(root->LeftChild, n+1, temp, sum);
    findSumBFS(root->RightChild, n+1, temp, sum);
}


int getDepth(BinaryTreeNode<int> *root)
{
    if (!root) {
        return 0;
    }
    return max(getDepth(root->LeftChild), getDepth(root->RightChild)) + 1;
}

void printSumForfindSumBFS(int * arr, int s, int e)
{
    for (; s <= e; ++s) {
        std::cout<<arr[s]<<" ";
    }
    std::cout<<std::endl;
}