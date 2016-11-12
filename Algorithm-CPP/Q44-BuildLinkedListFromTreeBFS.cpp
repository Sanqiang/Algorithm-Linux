//
//  Q44-BuildLinkedListFromTreeBFS.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q44-BuildLinkedListFromTreeBFS.h"
/*
 BinaryTreeNode<int> *btn3 = new BinaryTreeNode<int>(3);
 BinaryTreeNode<int> *btn7 = new BinaryTreeNode<int>(7);
 BinaryTreeNode<int> *btn12 = new BinaryTreeNode<int>(12);
 BinaryTreeNode<int> *btn17= new BinaryTreeNode<int>(17);
 BinaryTreeNode<int> *btn5 = new BinaryTreeNode<int>(5, btn3, btn7);
 BinaryTreeNode<int> *btn15 = new BinaryTreeNode<int>(15, btn12, btn17);
 BinaryTreeNode<int> *btn10 = new BinaryTreeNode<int>(10, btn5, btn15);
 //vector<DoublyLinkedList<BinaryTreeNode<int>*>*> v = buildLinkedListFromTreeBFS(btn10);
 vector<DoublyLinkedList<BinaryTreeNode<int>*>*> v1;
 vector<DoublyLinkedList<BinaryTreeNode<int>*>*> v2 = buildLinkedListFromTreeDFS(btn10, 0, v1);
*/
vector<DoublyLinkedList<BinaryTreeNode<int>*>*> buildLinkedListFromTreeBFS(BinaryTreeNode<int> *root)
{
    vector<DoublyLinkedList<BinaryTreeNode<int>*>*> lists;
    DoublyLinkedList<BinaryTreeNode<int>*> *list = new DoublyLinkedList<BinaryTreeNode<int>*>();
    list->addToTail(root);
    lists.push_back(list);
    while (list->getHead()) {
        DoublyLinkedList<BinaryTreeNode<int>*> *next_list = new DoublyLinkedList<BinaryTreeNode<int>*>();
        DoublyLinkedListElement<BinaryTreeNode<int>*> *runner = list->getHead();
        for (; runner; runner = runner->Next) {
            if (runner->Data->LeftChild) {
                next_list->addToTail(runner->Data->LeftChild);
            }
            if (runner->Data->RightChild) {
                next_list->addToTail(runner->Data->RightChild);
            }
        }
        if (next_list->getHead()) {
            lists.push_back(next_list);

        }
        list = next_list;
    }
    
    return lists;
}

vector<DoublyLinkedList<BinaryTreeNode<int>*>*> buildLinkedListFromTreeDFS(BinaryTreeNode<int> *root, int n, vector<DoublyLinkedList<BinaryTreeNode<int>*>*> &lists)
{
    if (!root) {
        return lists;
    }
    
    DoublyLinkedList<BinaryTreeNode<int>*> *list;
    if (lists.size() == n) {
        list = new DoublyLinkedList<BinaryTreeNode<int>*>();
        lists.push_back(list);
    }else{
        list = lists[n];
    }
    
    list->addToTail(root);
    
    buildLinkedListFromTreeDFS(root->LeftChild, n+1, lists);
    buildLinkedListFromTreeDFS(root->RightChild, n+1, lists);
    return lists;
}