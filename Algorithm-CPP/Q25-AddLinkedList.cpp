//
//  Q25-AddLinkedList.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/6/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 LinkedListElement<int> *l1 = new LinkedListElement<int>(9);
 LinkedListElement<int> *l2 = new LinkedListElement<int>(2);
 LinkedListElement<int> *l3 = new LinkedListElement<int>(4);
 LinkedListElement<int> *l4 = new LinkedListElement<int>(1);
 LinkedListElement<int> *l5 = new LinkedListElement<int>(5);
 LinkedListElement<int> *l6 = new LinkedListElement<int>(9);
 l1->setNext(l2); l2->setNext(l3);
 l4->setNext(l5); l5->setNext(l6);
 l1->print(); l4->print();
 
 //LinkedListElement<int> *result = addLinkedListAsc(l1, l4, 0);
 //result->print();
 
 LinkedListElement<int> *result = addLinkedListDesc(l1, l4);
 result->print();
 */
#include "Q25-AddLinkedList.h"

LinkedListElement<int> * addLinkedListAsc(LinkedListElement<int> *left, LinkedListElement<int> *right,int carry)
{
    int sum = carry;
    if (left) {
        sum += left->Data;
    }
    if (right) {
        sum +=right->Data;
    }
    int digit = sum % 10;
    int next_carry = sum / 10;
    
    LinkedListElement<int> *node = new LinkedListElement<int>(digit);
    
    if (next_carry != 0 || left || right) {
        node->setNext(addLinkedListAsc(left->Next, right->Next,next_carry));
    }
    
    return node;
}

LinkedListElement<int> * addLinkedListDesc(LinkedListElement<int> *left, LinkedListElement<int> *right)
{
    int length_left= left->getLength();
    int length_right = right->getLength();
    if (length_left>length_right) {
        padList(right, length_left-length_right);
    }else if(length_left<length_right)
    {
        padList(left, length_right-length_left);
    }
    
    addLinkedListDescHelperWrapper* wrapper = addLinkedListDescHelper(left, right);
    
    if (wrapper->carry != 0) {
        LinkedListElement<int> *head = new LinkedListElement<int>(wrapper->carry);
        head->Next = wrapper->node;
        return head;
    }else{
        return wrapper->node;
    }
}

addLinkedListDescHelperWrapper*  addLinkedListDescHelper(LinkedListElement<int> *left,LinkedListElement<int> *right)
{
    if (!left && !right) {
        addLinkedListDescHelperWrapper *empty = new addLinkedListDescHelperWrapper();
        return empty;
    }
    
    addLinkedListDescHelperWrapper *wrapper = addLinkedListDescHelper(left->Next, right->Next);
    
    int sum = left->Data + right->Data + wrapper->carry;
    int digit = sum % 10;
    int next_carry = sum / 10;
    
    LinkedListElement<int> * node = new LinkedListElement<int>(digit);
    node->Next = wrapper->node;
    
    wrapper->carry = next_carry;
    wrapper->node = node;
    
    return wrapper;
}

void padList(LinkedListElement<int> *&node, int length)
{
    int i=0;
    for (; i<length; ++i) {
        LinkedListElement<int> *temp = new LinkedListElement<int>(0);
        temp->Next=node;
        node=temp;
    }
}