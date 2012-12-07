//
//  Q24-PartitionLinkedList.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/6/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q24_PartitionLinkedList__
#define __Algorithm_Linux__Q24_PartitionLinkedList__

#include <iostream>
#include "Entity.h"
LinkedListElement<int> * partitionLinkedList(LinkedListElement<int> *head, int pivot);
void partitionLinkedListChange(LinkedListElement<int> *&head, int pivot);
#endif /* defined(__Algorithm_Linux__Q24_PartitionLinkedList__) */
