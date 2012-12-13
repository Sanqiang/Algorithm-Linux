//
//  Q56-SwapOddEvenBit.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/12/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q56-SwapOddEvenBit.h"
/*
 int num = 0xaa;
 cout<<num<<endl;
 swapOddEvenBit(num);
 cout<<num<<0x55;
 
*/
void swapOddEvenBit(int &n)
{
    n = ((n & 0xAAAAAAAAAAAAAAAA) >> 1) | ((n & 0x5555555555555555) << 1);
}