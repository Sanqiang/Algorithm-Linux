//
//  Q53-NextNumWithSameBit.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/12/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q53-NextNumWithSameBit.h"

void setBit(int &n, int index, bool val)
{
    if (val) {
        n = (1 << index) | n;
    }else
    {
        n = (~(1 << index)) & n;
    }
}

bool getBit(int n, int index)
{
    return (n >> index) % 2 > 0;
}

int nextLarger(int n)
{
    int c0 = 0;
    while (1) {
        if (getBit(n, c0)) { // n >> count; n & 1 > 0
            break;
        }
        ++c0;
    }
    int c1 = c0;
    while (1) {
        if (!getBit(n, c1)) {
            break;
        }
    }
    setBit(n, c1, true); // (1 << c1) | n
    n &= (~((1 << c1) - 1));
    int i = (c1-c0) - 1;
    n = ((1 << i) - 1) | n;
}

int nextSmaller(int n)
{
    int c1 = 0;
    while (1) {
        if (!getBit(n, c1)) {
            break;
        }
        ++c1;
    }
    int c0 = c1;
    while (1) {
        if (getBit(n, c0)) {
            break;
        }
        ++c0;
    }
    setBit(n, c0, false); //
    n &= (~((1 << c0) - 1));
    int i = c1 + 1;
    n = ((1 << i) - 1) << (c0 - c1 - 1);
}