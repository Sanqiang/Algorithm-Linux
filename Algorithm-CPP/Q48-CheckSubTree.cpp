//
//  Q48-CheckSubTree.cpp
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
 
 BinaryTreeNode<int> *btn0 = new BinaryTreeNode<int>(0);
 
 cout<<isSubTree(btn10, btn0);
 cout<<isSubTree2(btn10, btn0);
*/
#include "Q48-CheckSubTree.h"

bool isSubTree(BinaryTreeNode<int> *large, BinaryTreeNode<int> *small)
{
    return findRoot(large, small);
}

bool findRoot(BinaryTreeNode<int> *large, BinaryTreeNode<int> *small)
{
    if (!large) {
        return NULL;
    }
    if (large->Data == small->Data) {
        if (matchTree(large, small)) {
            return true;
        }
    }
    bool result = false;
    result |= findRoot(large->LeftChild, small);
    result |= findRoot(large->RightChild, small);
    return result;
}

bool matchTree(BinaryTreeNode<int> *large, BinaryTreeNode<int> *small)
{
    if ((large && !small)||(!large && !small)) {
        return true;
    }else if(!large && small)
    {
        return false;
    }else if(large->Data != small->Data)
    {
        return false;
    }
    bool result = true;
    
    result &= matchTree(large->LeftChild, small->LeftChild);
    
    result &= matchTree(large->RightChild, small->RightChild);
    
    return result;
}


bool isSubTree2(BinaryTreeNode<int> *large, BinaryTreeNode<int> *small)
{
    char * large_text = new char[length_tree_text];
    char * small_text = new char[length_tree_text];
    char * large_runner = large_text;
    char * small_runner = small_text;
    generateTextForTree(large, large_runner);
    generateTextForTree(small, small_runner);
    
    printCharArray(large_text);
    printCharArray(small_text);
    return isSubstring(large_text, small_text);
}

void generateTextForTree(BinaryTreeNode<int> *tree, char *&text)
{
    if (!tree) {
        *text = '$';
        ++text;
        return;
    }
    generateTextForTree(tree->LeftChild, text);
    
    *text = tree->Data + '0';
    ++text;
    
    generateTextForTree(tree->RightChild, text);
}

void printCharArray(char * arr)
{
    int i = 0;
    for (; i < length_tree_text; ++i) {
        std::cout<<arr[i]<<" ";
    }
    std::cout<<std::endl;
}