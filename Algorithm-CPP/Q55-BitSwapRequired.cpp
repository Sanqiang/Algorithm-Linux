//
//  Q55-BitSwapRequired.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/12/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q55-BitSwapRequired.h"
/*
 cout<<getNumOfBitSwapRequired(13, 0);
 
*/
int getNumOfBitSwapRequired(int left, int right)
{
    int n = left ^ right, count = 0;
    for (; n > 0; n = n & (n-1)) {
        ++count;
    }
    return count;
}