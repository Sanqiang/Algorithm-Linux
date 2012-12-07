//
//  Q24-PartitionLinkedList.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/6/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 LinkedListElement<int> *l1 = new LinkedListElement<int>(4);
 LinkedListElement<int> *l2 = new LinkedListElement<int>(2);
 LinkedListElement<int> *l3 = new LinkedListElement<int>(3);
 LinkedListElement<int> *l4 = new LinkedListElement<int>(1);
 LinkedListElement<int> *l5 = new LinkedListElement<int>(5);
 l1->setNext(l2); l2->setNext(l3); l3->setNext(l4);l4->setNext(l5);
 l1->print();
 //LinkedListElement<int> * head = partitionLinkedList(l1, 3);
 //head->print();
 partitionLinkedListChange(l1, 3);
 */
#include "Q24-PartitionLinkedList.h"

LinkedListElement<int> * partitionLinkedList(LinkedListElement<int> *head, int pivot)
{
    LinkedListElement<int> * left = NULL;
    LinkedListElement<int> * right = NULL;
    LinkedListElement<int> * runner = head;
    while (runner) {
        
        if (runner->Data <= pivot) {
            if (!left) {
                //*left = *new LinkedListElement<int>();
                //left->Data = runner->Data;
                //eft = runner;
                left = (LinkedListElement<int> *)malloc(sizeof(LinkedListElement<int>));
                left->Data=runner->Data;
            }else{
                LinkedListElement<int> *temp = new LinkedListElement<int>();
                temp->Data=runner->Data;
                temp->Next = left;
                left = temp;
            }            
        }else
        {
            if (!right) {
                //right=runner;
                //*right = *new LinkedListElement<int>();
                //right->Data = runner->Data;
                right = (LinkedListElement<int> *)malloc(sizeof(LinkedListElement<int>));
                right->Data=runner->Data;
            }else{
                LinkedListElement<int> *temp = new LinkedListElement<int>();
                temp->Data=runner->Data;
                temp->Next=right;
                right = temp;
            }
        }
        runner = runner->Next;
    }
    if (left) {
        runner = left;
        while (runner->Next) {
            runner=runner->Next;
        }
        runner->Next = right;
        return left;
    }else{
        return right;
    }
}

void partitionLinkedListChange(LinkedListElement<int> *&head, int pivot)
{
    LinkedListElement<int> * left = NULL;
    LinkedListElement<int> * right = NULL;
    LinkedListElement<int> *runner = head;
    while (runner) {
        LinkedListElement<int> *next_loop = runner->Next;
        
        if (runner->Data <=pivot) {
            //if (!left) {
            //    left=runner;
            //    left->Next = NULL;
            //}else{
                runner->Next=left;
                left=runner;
            //}
        }else{
            //if (!right) {
            //    right=runner;
            //    right->Next = NULL;
            //}else{
                runner->Next=right;
                right=runner;
            //}
        }
        runner = next_loop;
    }
    if (left) {
        runner = left;
        while (runner->Next) {
            runner=runner->Next;
        }
        runner->Next = right;
        head = left;
    }else{
        head = right;
    }
}