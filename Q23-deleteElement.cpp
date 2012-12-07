//
//  Q23-deleteElement.cpp
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
 LinkedListElement<char> *l5 = new LinkedListElement<char>('e');
 l1->setNext(l2); l2->setNext(l3); l3->setNext(l4);l4->setNext(l5);
 
 printLinkedList(l1);
 deleteElement(l2);
 printLinkedList(l1);
 */
#include "Q23-deleteElement.h"

void deleteElement(LinkedListElement<char> *&pending)
{
    if (pending->Next) {
        LinkedListElement<char> *temp = pending->Next;
        pending->Data = pending->Next->Data;;
        pending->Next = pending->Next->Next;
        delete temp;
    }else{
        //delete pending;
        //pending = NULL;
        std::cout<<"Cannot do that"<<std::endl;
    }
}