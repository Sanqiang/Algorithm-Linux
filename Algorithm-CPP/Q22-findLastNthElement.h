//
//  Q22-findLastNthElement.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/6/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q22_findLastNthElement__
#define __Algorithm_Linux__Q22_findLastNthElement__

#include <iostream>
#include "Entity.h"
LinkedListElement<char> * findLastNthElementRecursive(LinkedListElement<char> *head, int n, int &current);
LinkedListElement<char> * findLastNthElementIterative(LinkedListElement<char> *head, int n);
#endif /* defined(__Algorithm_Linux__Q22_findLastNthElement__) */
