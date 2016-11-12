//
//  Q51-UpdateBitOnMN.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/12/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q51-UpdateBitOnMN.h"
/*
    cout<<updateBitOnNM(27, 7, 1, 3); 
*/
int updateBitOnNM(int n, int m, int i, int j)
{
    int mask = ~(((1 << j) - 1) - ((1 << i) - 1));
    n &= mask;
    m <<= i;
    return m | n;
}
