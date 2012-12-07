//
//  Q22-findLastNthElement.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/6/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 LinkedListElement<char> *l1 = new LinkedListElement<char>('a');
 LinkedListElement<char> *l2 = new LinkedListElement<char>('b');
 LinkedListElement<char> *l3 = new LinkedListElement<char>('a');
 LinkedListElement<char> *l4 = new LinkedListElement<char>('c');
 l1->setNext(l2); l2->setNext(l3); l3->setNext(l4);
 //printLinkedList(l1);
 int a = 0;
 findLastNthElementRecursive(l1, 2, a);
 findLastNthElementIterative(l1, 1);
 */
#include "Q22-findLastNthElement.h"

LinkedListElement<char> * findLastNthElementRecursive(LinkedListElement<char> *head, int n, int &current)
{
    if (!head) {
        return head;
    }
    LinkedListElement<char> *node = findLastNthElementRecursive(head->Next, n, current);
    if (++current == n) {
        std::cout<<head->Data<<std::endl;
        return head;
    }
    return node;
}

LinkedListElement<char> * findLastNthElementIterative(LinkedListElement<char> *head, int n)
{
    LinkedListElement<char> *left = head;
    LinkedListElement<char> *right = head;
    int i;
    for (i=0; i<n; ++i) {
        right=right->Next;
        if (!right) {
            std::cout<<"Too short linked list"<<std::endl;
            return nullptr;
        }
    }
    
    while (right) {
        left = left->Next;
        right = right->Next;
    }
    
    std::cout<<left->Data<<std::endl;
    return  left;
}