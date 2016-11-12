//
//  Q91-CountWaysOnStairs.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/14/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
    cout<<countWays(50, new long[50]); 
*/
#include "Q91-CountWaysOnStairs.h"

long countWays(long n, long cache[])
{
    if (n == 0) {
        return 1;
    }else if(n < 0)
    {
        return 0;
    }else{
        cache[n] = countWays(n - 1, cache) + countWays(n - 2, cache) + countWays(n - 3, cache);
        return cache[n];
    }
}