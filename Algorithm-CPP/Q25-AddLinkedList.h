//
//  Q25-AddLinkedList.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/6/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q25_AddLinkedList__
#define __Algorithm_Linux__Q25_AddLinkedList__

#include <iostream>
#include "Entity.h"
LinkedListElement<int> * addLinkedListAsc(LinkedListElement<int> *left, LinkedListElement<int> *right,int carry);
LinkedListElement<int> * addLinkedListDesc(LinkedListElement<int> *left, LinkedListElement<int> *right);
void padList(LinkedListElement<int> *&node, int length);
class addLinkedListDescHelperWrapper
{
public:
    LinkedListElement<int> *node;
    int carry;
};
addLinkedListDescHelperWrapper * addLinkedListDescHelper(LinkedListElement<int> *left,LinkedListElement<int> *right);

#endif /* defined(__Algorithm_Linux__Q25_AddLinkedList__) */
