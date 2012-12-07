//
//  Q26-findEntryInCircularList.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/7/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 LinkedListElement<char> *l1 = new LinkedListElement<char>('a');
 LinkedListElement<char> *l2 = new LinkedListElement<char>('v');
 LinkedListElement<char> *l3 = new LinkedListElement<char>('x');
 LinkedListElement<char> *l4 = new LinkedListElement<char>('y');
 LinkedListElement<char> *l5 = new LinkedListElement<char>('z');
 LinkedListElement<char> *l6 = new LinkedListElement<char>('m');
 l1->setNext(l2); l2->setNext(l3);l3->setNext(l4);
 l4->setNext(l5); l5->setNext(l6);l6->setNext(l2);
 
 LinkedListElement<char> *entry = findEntryInCircularList(l1);
 std::cout<<entry->Data;
 */
#include "Q26-findEntryInCircularList.h"

LinkedListElement<char> * findEntryInCircularList(LinkedListElement<char> * head)
{
    LinkedListElement<char> *faster = head;
    LinkedListElement<char> *slower = head;
    while (1) {
        if (!faster->Next || !faster->Next->Next || !slower) {
            std::cout<<"Not Circular"<<std::endl;
            return nullptr;
        }
        faster=faster->Next->Next;
        slower=slower->Next;
        if (faster == slower) {
            break;
        }
    }
    
    slower = head;
    while (faster != slower) {
        faster=faster->Next;
        slower=slower->Next;
    }
    
    return faster;
}