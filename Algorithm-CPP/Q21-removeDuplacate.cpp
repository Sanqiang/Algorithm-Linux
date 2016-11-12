//
//  Q1121-removeDuplacate.cpp
//  Algorithm-Linux
//
//  Created by SanQ11iang Zhao on 12/6/12.
//  Copyright (c) 2012 SanQ11iang Zhao. All rights reserved.
//
/*
 LinkedListElement<char> *l1 = new LinkedListElement<char>('a');
 LinkedListElement<char> *l2 = new LinkedListElement<char>('b');
 LinkedListElement<char> *l3 = new LinkedListElement<char>('a');
 LinkedListElement<char> *l4 = new LinkedListElement<char>('c');
 l1->setNext(l2); l2->setNext(l3); l3->setNext(l4);
 
 printLinkedList(l1);
 //removeDuplicateWithHashtable(l1);
 removeDuplicateWithoutHashtable(l1);
 printLinkedList(l1);
 */
#include "Q21-removeDuplacate.h"

void removeDuplicateWithHashtable(LinkedListElement<char> *head)
{
    LinkedListElement<char> *runner = head, *temp;
    hash_map<char, bool> record;
    char value = head->Data;
    pair<char, bool> item(value,true);
    record.insert(item);
    while (runner->Next) {
        value = runner->Next->Data;
        if (record.count(value) == 0) {
            pair<char, bool> item(value,true);
            record.insert(item);
            runner = runner->Next;
        }else
        {
            temp = runner->Next;
            runner->Next = runner->Next->Next;
            delete temp;
        }
    }
}

void removeDuplicateWithoutHashtable(LinkedListElement<char> *head)
{
    LinkedListElement<char> *current = head, *runner,*temp;
    char value;
    while (current) {
        value = current->Data;
        runner = current->Next;
        if (runner) {
            while (runner->Next) {
                if (runner->Next->Data == value) {
                    temp = runner->Next;
                    runner->Next= runner->Next->Next;
                    delete temp;
                }else{
                    runner= runner->Next;
                }
            }
        }
        current=current->Next;
    }
}

void printLinkedList(LinkedListElement<char> *head)
{
    LinkedListElement<char> *runner = head;   
    while (runner) {
        std::cout<<runner->Data;
        runner=runner->Next;
    }
    std::cout<<std::endl<<"============="<<std::endl;
}